package net.sf.saxon.instruct;
import net.sf.saxon.Err;
import net.sf.saxon.event.ReceiverOptions;
import net.sf.saxon.event.SequenceReceiver;
import net.sf.saxon.expr.*;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NamePool;
import net.sf.saxon.om.Navigator;
import net.sf.saxon.om.Orphan;
import net.sf.saxon.pattern.NodeKindTest;
import net.sf.saxon.style.StandardNames;
import net.sf.saxon.trans.DynamicError;
import net.sf.saxon.trans.StaticError;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.type.*;
import net.sf.saxon.value.StringValue;
import net.sf.saxon.value.Value;

import java.io.PrintStream;

/**
* An xsl:value-of element in the stylesheet. <br>
* The xsl:value-of element takes attributes:<ul>
* <li>a mandatory attribute select="expression".
* This must be a valid String expression</li>
* <li>an optional disable-output-escaping attribute, value "yes" or "no"</li>
* <li>an optional separator attribute. This is handled at compile-time: if the separator attribute
* is present, the select expression passed in here will be a call to the string-join() function.</li>
* </ul>
*/

public final class ValueOf extends SimpleNodeConstructor {

    private int options;
    private boolean isNumberingInstruction = false;  // set to true if generated by xsl:number

    public ValueOf( Expression select,
                    boolean disable ) {
        this.select = select;
        this.options = (disable ? ReceiverOptions.DISABLE_ESCAPING : 0);
        adoptChildExpression(select);
    }

    /**
     * Indicate that this is really an xsl:nunber instruction
     */

    public void setIsNumberingInstruction() {
        isNumberingInstruction = true;
    }

    /**
    * Get the name of this instruction for diagnostic and tracing purposes
    */

    public int getInstructionNameCode() {
        if (isNumberingInstruction) {
            return StandardNames.XSL_NUMBER;
        } else if (select instanceof StringValue) {
            return StandardNames.XSL_TEXT;
        } else {
            return StandardNames.XSL_VALUE_OF;
        }
    }

    /**
    * Offer promotion for subexpressions. The offer will be accepted if the subexpression
    * is not dependent on the factors (e.g. the context item) identified in the PromotionOffer.
    * By default the offer is not accepted - this is appropriate in the case of simple expressions
    * such as constant values and variable references where promotion would give no performance
    * advantage. This method is always called at compile time.
    *
    * @param offer details of the offer, for example the offer to move
    *     expressions that don't depend on the context to an outer level in
    *     the containing expression
    * @exception XPathException if any error is detected
    */

    protected void promoteInst(PromotionOffer offer) throws XPathException {
//        if (separator != null) {
//            separator = separator.promote(offer);
//        }
        super.promoteInst(offer);
    }

    public ItemType getItemType() {
        return NodeKindTest.TEXT;
    }

    public int getCardinality() {
        return StaticProperty.EXACTLY_ONE;
    }

    public void typeCheck(StaticContext env, ItemType contextItemType) {

    }

    /**
      * Check statically that the results of the expression are capable of constructing the content
      * of a given schema type.
      *
      * @param parentType The schema type
      * @param env        the static context
      * @param whole
      * @throws net.sf.saxon.trans.XPathException
      *          if the expression doesn't match the required content type
      */

     public void checkPermittedContents(SchemaType parentType, StaticContext env, boolean whole) throws XPathException {
         // if the expression is a constant value, check that it is valid for the type
         if (select instanceof Value) {
             SimpleType stype = null;
             if (parentType instanceof SimpleType && whole) {
                 stype = (SimpleType)parentType;
             } else if (parentType instanceof ComplexType && ((ComplexType)parentType).isSimpleContent()) {
                 stype = ((ComplexType)parentType).getSimpleContentType();
             }
             if (whole && stype != null && !stype.isNamespaceSensitive()) {
                        // Can't validate namespace-sensitive content statically
                 XPathException err = stype.validateContent(((Value)select).getStringValue(), null);
                 if (err != null) {
                     err.setLocator(this);
                     throw err;
                 }
                 return;
             }
             if (parentType instanceof ComplexType &&
                     !((ComplexType)parentType).isSimpleContent() &&
                     !((ComplexType)parentType).isMixedContent() &&
                     !Navigator.isWhite(((Value)select).getStringValue())) {
                 StaticError err = new StaticError("Complex type " + parentType.getDescription() +
                         " does not allow text content " +
                         Err.wrap(((Value)select).getStringValue()));
                 err.setLocator(this);
                 err.setIsTypeError(true);
                 throw err;
             }
         }
     }



    public TailCall processLeavingTail(XPathContext context) throws XPathException {
        SequenceReceiver out = context.getReceiver();
        out.characters(expandChildren(context), locationId, options);
        return null;
    }

    public Item evaluateItem(XPathContext context) throws XPathException {
        try {
            CharSequence val = expandChildren(context);
            Orphan o = new Orphan(context.getController().getConfiguration());
            o.setNodeKind(Type.TEXT);
            o.setStringValue(val);
            return o;
        } catch (XPathException err) {
            throw new DynamicError(err);
        }
    }

    /**
     * Display this instruction as an expression, for diagnostics
     */

    public void display(int level, NamePool pool, PrintStream out) {
        out.println(ExpressionTool.indent(level) + "value-of");
        select.display(level+1, pool, out);
    }
}

//
// The contents of this file are subject to the Mozilla Public License Version 1.0 (the "License");
// you may not use this file except in compliance with the License. You may obtain a copy of the
// License at http://www.mozilla.org/MPL/
//
// Software distributed under the License is distributed on an "AS IS" basis,
// WITHOUT WARRANTY OF ANY KIND, either express or implied.
// See the License for the specific language governing rights and limitations under the License.
//
// The Original Code is: all this file.
//
// The Initial Developer of the Original Code is Michael H. Kay.
//
// Portions created by (your name) are Copyright (C) (your legal entity). All Rights Reserved.
//
// Contributor(s): none.
//
