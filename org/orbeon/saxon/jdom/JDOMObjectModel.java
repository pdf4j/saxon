package org.orbeon.saxon.jdom;

import org.orbeon.saxon.Configuration;
import org.orbeon.saxon.expr.XPathContext;
import org.orbeon.saxon.value.Value;
import org.orbeon.saxon.trans.XPathException;
import org.orbeon.saxon.event.Receiver;
import org.orbeon.saxon.event.PipelineConfiguration;
import org.orbeon.saxon.om.DocumentInfo;
import org.orbeon.saxon.om.ExternalObjectModel;
import org.orbeon.saxon.om.VirtualNode;
import org.orbeon.saxon.om.NodeInfo;
import org.jdom.*;

import javax.xml.transform.Result;
import javax.xml.transform.Source;


/**
 * This interface must be implemented by any third-party object model that can
 * be wrapped with a wrapper that implements the Saxon Object Model (the NodeInfo interface).
 * This implementation of the interface supports wrapping of JDOM Documents.
 */

public class JDOMObjectModel implements ExternalObjectModel {
    
    public JDOMObjectModel() {}

     /**
     * Test whether this object model recognizes a given node as one of its own
     */

    public boolean isRecognizedNode(Object object) {
         return object instanceof Document ||
                 object instanceof Element ||
                 object instanceof Attribute ||
                 object instanceof Text ||
                 object instanceof CDATA ||
                 object instanceof Comment ||
                 object instanceof ProcessingInstruction ||
                 object instanceof Namespace;
    }

    /**
     * Test whether this object model recognizes a particular kind of JAXP Result object,
     * and if it does, return a Receiver that builds an instance of this data model from
     * a sequence of events. If the Result is not recognised, return null.
     */

    public Receiver getDocumentBuilder(Result result) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Test whether this object model recognizes a particular kind of JAXP Source object,
     * and if it does, send the contents of the document to a supplied Receiver, and return true.
     * Otherwise, return false.
     */

    public boolean sendSource(Source source, Receiver receiver, PipelineConfiguration pipe) throws XPathException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Wrap or unwrap a node using this object model to return the corresponding Saxon node. If the supplied
     * source does not belong to this object model, return null
     */

    public NodeInfo unravel(Source source, Configuration config) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Convert a Java object to an XPath value. If the supplied object is recognized as a representation
     * of a value using this object model, the object model should convert the value to an XPath value
     * and return this as the result. If not, it should return null. If the object is recognized but cannot
     * be converted, an exception should be thrown
     */

    public Value convertObjectToXPathValue(Object object, Configuration config) throws XPathException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Convert an XPath value to an object in this object model. If the supplied value can be converted
     * to an object in this model, of the specified class, then the conversion should be done and the
     * resulting object returned. If the value cannot be converted, the method should return null. Note
     * that the supplied class might be a List, in which case the method should inspect the contents of the
     * Value to see whether they belong to this object model.
     */

    public Object convertXPathValueToObject(Value value, Class targetClass, XPathContext context) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Wrap a document node in the external object model in a document wrapper that implements
     * the Saxon DocumentInfo interface
     * @param node    a node (any node) in the third party document
     * @param baseURI the base URI of the node (supply "" if unknown)
     * @param config the Saxon configuration (which among other things provides access to the NamePool)
     * @return the wrapper, which must implement DocumentInfo
     */ 
    
    public DocumentInfo wrapDocument(Object node, String baseURI, Configuration config) {
        Document documentNode = getDocumentRoot(node);
        return new DocumentWrapper(documentNode, baseURI, config);
    }

    /**
     * Wrap a node within the external object model in a node wrapper that implements the Saxon
     * VirtualNode interface (which is an extension of NodeInfo)
     * @param document the document wrapper, as a DocumentInfo object
     * @param node the node to be wrapped. This must be a node within the document wrapped by the
     * DocumentInfo provided in the first argument
     * @return the wrapper for the node, as an instance of VirtualNode
     */ 
    
    public VirtualNode wrapNode(DocumentInfo document, Object node) {
        return ((DocumentWrapper)document).wrap(node);
    }

    /**
     * Get the document root
     */

    private Document getDocumentRoot(Object node) {
        while (!(node instanceof Document)) {
            if (node instanceof Element) {
                if (((Element)node).isRootElement()) {
                    return ((Element)node).getDocument();
                } else {
                    node = ((Element)node).getParent();
                }
            } else if (node instanceof Text) {
                node = ((Text)node).getParent();
            } else if (node instanceof Comment) {
                node = ((Comment)node).getParent();
            } else if (node instanceof ProcessingInstruction) {
                node = ((ProcessingInstruction)node).getParent();
            } else if (node instanceof Attribute) {
                node = ((Attribute)node).getParent();
            } else if (node instanceof Document) {
                return (Document)node;
            } else if (node instanceof Namespace) {
                throw new UnsupportedOperationException("Cannot find parent of JDOM namespace node");
            } else {
                throw new IllegalStateException("Unknown JDOM node type " + node.getClass());
            }
        }
        return (Document)node;
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
// Contributor(s): Gunther Schadow (changes to allow access to public fields; also wrapping
// of extensions and mapping of null to empty sequence).
//
