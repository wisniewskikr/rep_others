package pl.kwi.entities;

import java.io.Serializable;

public class ExampleEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public ExampleEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

}
