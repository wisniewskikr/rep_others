package org.wk.xml.elements;

public class XmlNode {
	
	
	private String text;
	
	
	public XmlNode(String text) {
		this.text = text;
	}
	
	
	@Override
	public String toString() {
		return text;
	}

	
}
