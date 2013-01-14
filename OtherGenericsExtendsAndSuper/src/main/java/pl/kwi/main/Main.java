package pl.kwi.main;

import pl.kwi.persons.Father;
import pl.kwi.persons.Grandfather;
import pl.kwi.persons.Child;

public class Main<T> {


	public static void main(String[] args) {
//		Child extends Father extends Grandfather
		
//		// Extends
		Main<? extends Father> main1 = new Main<Father>();
		Main<? extends Father> main2 = new Main<Child>();
//		Main<? extends Father> main3 = new Main<Grandfather>();
		
		// Super
		Main<? super Father> main4 = new Main<Father>();
		Main<? super Father> main5 = new Main<Grandfather>();
//		Main<? super Father> main6 = new Main<Child>();

	}


}
