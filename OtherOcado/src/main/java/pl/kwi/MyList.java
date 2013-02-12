package pl.kwi;

public class MyList {
	
	private MyNode head;
	
	public void addFirst(int i){
		
		if(head == null){
			head = new MyNode(i);
			return;
		}
			
		MyNode firstNode = new MyNode(i);
		firstNode.setNext(head);
		head = firstNode;

	}
	
	public void addLast(int i){
		
		if(head == null){
			head = new MyNode(i);
			return;
		}
			
		MyNode current = head;
		MyNode next = current.getNext();
		
		while(next != null){				
			current = next;
			next = current.getNext();
		}
		
		current.setNext(new MyNode(i));
		
	}
	
	public void addSorted(int i){
		
		MyNode newNode = new MyNode(i);
		
		if(head == null){
			head = new MyNode(i);
			return;
		}
			
		if(newNode.getValue() < head.getValue()){
			addFirst(i);
			return;
		}
			
		MyNode current = head;
		MyNode next = current.getNext();
		
		while(next != null){				
			
			if(newNode.getValue() < next.getValue()){
				newNode.setNext(next);
				current.setNext(newNode);
				return;
			}
			
			current = next;
			next = current.getNext();
		}
		
		current.setNext(newNode);
			
		
		
	}
	
	public int size(){
		if(head == null){
			return 0;
		}else{
			return head.size();
		}
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	public void displayList(){
		
		MyNode current = head;
		MyNode next = current.getNext();
		
		while(current != null){
			System.out.println(current.getValue());
			current = next;
			if(next != null){
				next = current.getNext();
			}
		}
		
	}
	
}
