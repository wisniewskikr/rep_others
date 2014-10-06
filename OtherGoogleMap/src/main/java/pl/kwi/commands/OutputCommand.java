package pl.kwi.commands;

import java.io.Serializable;

/**
 * Class with data of page "Output".
 * 
 * @author Krzysztof Wisniewski
 *
 */
public class OutputCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String address;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
