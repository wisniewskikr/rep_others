package pl.kwi.main;

import java.util.ArrayList;
import java.util.List;

import pl.kwi.controllers.ThreadController;
import pl.kwi.items.CommunicationItem;

public class Main {


	public static void main(String[] args) {

		List<CommunicationItem> items = getCommunicationItems();
		
		ThreadController tc = new ThreadController();
		items = tc.runThreads(items, 10);
		
		displayCommunicationItems(items);
		
	}
	
	public static List<CommunicationItem> getCommunicationItems(){
		
		List<CommunicationItem> items = new ArrayList<CommunicationItem>();		
		
		for (int i = 0; i < 100; i++) {
			String request = "This is request nr: " + i;
			items.add(new CommunicationItem(request));
		}
		
		return items;
		
	}
	
	public static void displayCommunicationItems(List<CommunicationItem> items){
		
		for (CommunicationItem item : items) {
			
			System.out.println("Request: " + item.getRequest());
			System.out.println("Response: " + item.getResponse());
			
		}
		
	}


}
