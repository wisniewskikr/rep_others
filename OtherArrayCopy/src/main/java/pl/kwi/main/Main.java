package pl.kwi.main;

import pl.kwi.utils.ArrayCopyUtil;

public class Main {
	
	public static void main(String[] args) {
		
		testCopyByAssociation();
		testCopyByClone();
		testCopyByArrayCopy();
		
	}
	
	private static void testCopyByAssociation() {
		
		String[] source = {"text1", "text2", "text3"};
		
		String[] result = source;
		
		result[0] = "change";
		
		System.out.println("Association: " + source[0]);
		
	}
	
	private static void testCopyByClone() {
		
		String[] source = {"text1", "text2", "text3"};
		
		String[] result = source.clone();
		
		result[0] = "change";
		
		System.out.println("Clone: " + source[0]);
		
	}
	
	private static void testCopyByArrayCopy() {
		
		String[] source = {"text1", "text2", "text3"};
		
		String[] result = ArrayCopyUtil.arrayCopyString(source);
		
		result[0] = "change";
		
		System.out.println("Array copy: " + source[0]);
		
	}

}
