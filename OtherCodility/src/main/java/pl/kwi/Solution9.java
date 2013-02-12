package pl.kwi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {
	
	public int invCount(int[] A){
		
		if(A == null || A.length < 2){
			return 0;
		}
				
		List<Integer> orgList = getList(A);
		
		int[] B = A.clone();
		Arrays.sort(B);
		List<Integer> sortedList = getList(B);
		
		int count = 0;
		while(!orgList.isEmpty()){
			Integer integer = orgList.get(0);
			
			count += sortedList.indexOf(integer);
			
			orgList.remove(integer);
			sortedList.remove(integer);
		}
		
		
		return count;
		
	}
	
	public List<Integer> getList(int[] array){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i : array) {
			list.add(i);
		}
		
		return list;
		
	}
	
}




