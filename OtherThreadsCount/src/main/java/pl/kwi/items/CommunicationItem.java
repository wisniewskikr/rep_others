package pl.kwi.items;

public class CommunicationItem {
	
	
	private String request;
	private String response;
		
	
	public CommunicationItem(String request) {
		this.request = request;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
		

}
