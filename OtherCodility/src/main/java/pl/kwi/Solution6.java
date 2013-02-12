package pl.kwi;

import java.util.Arrays;

public class Solution6 {
	
	public static void main(String[] args) {
		
		int[] A = new int[9];
		A[0] = 4;
		A[1] = 3;
		A[2] = 1;
		A[3] = 4;
		A[4] = -1;
		A[5] = 2;
		A[6] = 1;
		A[7] = 5;
		A[8] = 7;
		
		int[] array = A.clone();
		Arrays.sort(array);
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(array));
		
	}
	
	
	public int[] array_closest_ascenders(int A[]){
		
		int[] array = A.clone();
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			int current = array[i];
			
			Integer ascender = null;
			if(i == array.length -1){
				ascender = null;
			}else{
				for(int j = i + 1; j < array.length; j++){
					if(array[j] > current){
						ascender = array[j];
					}else{
						ascender = null;
					}
				}
			}
			
			if(ascender == null){
				
			}
			
			
			
		}
		
		return null;
		
	}
	
	
}




