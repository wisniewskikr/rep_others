package org.wk.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserEntity {
	
	
	private String name;
	
	
	public UserEntity(){}
	
	public UserEntity(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
