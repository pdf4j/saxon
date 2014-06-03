package org.pdf4j.saxon.functions;
import org.pdf4j.saxon.expr.XPathContext;
import org.pdf4j.saxon.om.EmptyIterator;
import org.pdf4j.saxon.om.Item;
import org.pdf4j.saxon.om.SequenceIterator;
import org.pdf4j.saxon.trans.XPathException;
import org.pdf4j.saxon.value.StringValue;

/**
 * This class supports the function string-to-codepoints()
 */

public class StringToCodepoints extends SystemFunction {

    public SequenceIterator iterate(XPathContext c) throws XPathException {
        Item item = argument[0].evaluateItem(c);
        if (item==null) {
            return EmptyIterator.getInstance();
        }
        return ((StringValue)item).iterateCharacters();
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
