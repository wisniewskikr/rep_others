package org.wk.services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DomService {
	
	public Element addElement(Document doc, Node parent, String name) {
		Element element = doc.createElement(name);
		
		if(parent == null) {
			return (Element)doc.appendChild(element);
		} else {
			return (Element)parent.appendChild(element);
		}
		
	}
	
	public void addAttribute(Element element, String name, String value) {
		element.setAttribute(name, value);
	}
	
	public void addValue(Element element, String value) {
		element.setTextContent(value);
	}

}
