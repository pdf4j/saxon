package net.sf.saxon.expr;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NamePool;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.type.ItemType;
import net.sf.saxon.type.Type;
import net.sf.saxon.value.BooleanValue;

import java.io.PrintStream;


/**
* A position() eq last() expression, generated by the optimizer.
*/

public final class IsLastExpression extends ComputedExpression {

    private boolean condition;

    /**
    * Construct a condition that tests position() eq last() (if condition
    * is true) or position() ne last() (if condition is false).
    */

    public IsLastExpression(boolean condition){
        this.condition = condition;
    };

    public boolean getCondition() {
        return condition;
    }

    public Expression simplify(StaticContext env) {
        return this;
    }

    public Expression analyze(StaticContext env, ItemType contextItemType) {
        return this;
    }

    /**
     * Determine the special properties of this expression
     * @return {@link StaticProperty#NON_CREATIVE}.
     */

    public int computeSpecialProperties() {
        int p = super.computeSpecialProperties();
        return p | StaticProperty.NON_CREATIVE;
    }

    public Item evaluateItem(XPathContext c) throws XPathException {
        return BooleanValue.get(condition==c.isAtLast());
    }

    /**
    * Determine the data type of the expression
    * @return Type.BOOLEAN
    */

    public ItemType getItemType() {
        return Type.BOOLEAN_TYPE;
    }

    /**
    * Determine the static cardinality
    */

    public int computeCardinality() {
        return StaticProperty.EXACTLY_ONE;
    }

    /**
    * Get the dependencies of this expression on the context
    */

    public int getIntrinsicDependencies() {
        return StaticProperty.DEPENDS_ON_POSITION | StaticProperty.DEPENDS_ON_LAST;
    }

    /**
    * Diagnostic print of expression structure
    */

    public void display(int level, NamePool pool, PrintStream out) {
        out.println(ExpressionTool.indent(level) + (condition ? "" : "not ") + "isLast()");
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
