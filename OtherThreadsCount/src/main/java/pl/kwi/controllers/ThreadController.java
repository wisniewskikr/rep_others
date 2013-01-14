package pl.kwi.controllers;

import java.util.ArrayList;
import java.util.List;

import pl.kwi.items.CommunicationItem;
import pl.kwi.threads.WorkerThread;

public class ThreadController{
	
	private final static int DELAY = 3000;

	
	public List<CommunicationItem> runThreads(List<CommunicationItem> items, int maxThreadCount){
		
		List<CommunicationItem> resultList = new ArrayList<CommunicationItem>();
		
		try {
			
			while(!items.isEmpty()){
				
				System.out.println("Controller Iteration");
				
				int activeCount = Thread.activeCount();
				int availableCount = maxThreadCount - activeCount;
				
				for (int i = 0; i <= availableCount; i++) {
					CommunicationItem item = items.remove(0);
					resultList.add(item);
					WorkerThread workerThread = new WorkerThread(item);
					workerThread.start();
				}
				
				Thread.currentThread().sleep(DELAY);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
		
	}


}
