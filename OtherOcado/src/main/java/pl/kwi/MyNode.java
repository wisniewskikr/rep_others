package pl.kwi;

public class MyNode {
	
	private int i;
	private MyNode next;
	private static int size = 0;
	
	public MyNode(int i){
		this.i = i;
		next = null;
	}

	public MyNode getNext() {
		return next;
	}
	public void setNext(MyNode next) {
		this.next = next;
	}

	public int getValue() {
		return i;
	}
	
	public int size(){
		
		size++;
		
		if(next == null){
			return size;
		}else{
			return next.size();
		}
		
	}

}
