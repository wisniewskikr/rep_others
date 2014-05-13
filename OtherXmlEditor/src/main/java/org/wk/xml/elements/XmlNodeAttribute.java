package org.wk.xml.elements;

public class XmlNodeAttribute {
	
	
	private String key;
	private String value;
	
	
	public XmlNodeAttribute(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		return key + " = " + value;
	}


	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
		
	
}
