package pl.kwi.main;

import pl.kwi.MyList;

public class Main {
	
	public static void main(String[] args) {
		
		MyList list = new MyList();
		list.addSorted(2);
		list.addSorted(1);
		list.addSorted(3);
		list.addSorted(0);
		list.addSorted(1);
		list.addSorted(4);
		list.addSorted(1);
		
		list.displayList();
		
	}

}
