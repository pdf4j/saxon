package org.pdf4j.saxon.functions;
import org.pdf4j.saxon.expr.Expression;
import org.pdf4j.saxon.expr.ExpressionVisitor;
import org.pdf4j.saxon.expr.Literal;
import org.pdf4j.saxon.trans.XPathException;
import org.pdf4j.saxon.value.AnyURIValue;

/**
 * This class supports the static-base-uri() function in XPath 2.0. The expressio
 * is always evaluated at compile time.
*/

public class StaticBaseURI extends CompileTimeFunction {

    /**
    * Compile time evaluation
     * @param visitor an expression visitor
     */

    public Expression preEvaluate(ExpressionVisitor visitor) throws XPathException {
        String baseURI = visitor.getStaticContext().getBaseURI();
        if (baseURI == null) {
            return Literal.makeEmptySequence();
        }
        return Literal.makeLiteral(new AnyURIValue(baseURI));
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
