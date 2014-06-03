package org.pdf4j.saxon.functions;
import org.pdf4j.saxon.expr.XPathContext;
import org.pdf4j.saxon.om.Item;
import org.pdf4j.saxon.trans.XPathException;
import org.pdf4j.saxon.value.AtomicValue;
import org.pdf4j.saxon.value.DateTimeValue;
import org.pdf4j.saxon.value.DateValue;
import org.pdf4j.saxon.value.TimeValue;


/**
* This class supports the dateTime($date, $time) function
*/

public class DateTimeConstructor extends SystemFunction {

    /**
    * Evaluate the expression
    */

    public Item evaluateItem(XPathContext context) throws XPathException {
        AtomicValue arg0 = (AtomicValue)argument[0].evaluateItem(context);
        AtomicValue arg1 = (AtomicValue)argument[1].evaluateItem(context);
        try {
            return DateTimeValue.makeDateTimeValue((DateValue)arg0, (TimeValue)arg1);
        } catch (XPathException e) {
            e.maybeSetLocation(this);
            e.maybeSetContext(context);
            throw e;
        }
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
// The Initial Developer of the Original Code is Michael H. Kay
//
// Portions created by (your name) are Copyright (C) (your legal entity). All Rights Reserved.
//
// Contributor(s): none.
//
