package pl.kwi.threads;

import java.util.Random;

import pl.kwi.items.CommunicationItem;

public class WorkerThread extends Thread{
	
	
	private CommunicationItem item;
		

	public WorkerThread(CommunicationItem item) {
		this.item = item;
	}


	@Override
	public void run() {
		
		try {				
				
			System.out.println("New Thread Created");
			
			Random random = new Random();
			int delay = random.nextInt(10000);
			Thread.currentThread().sleep(delay);
				
			String response = "This thread was handled with deley: " + delay;
			item.setResponse(response);
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	

}
