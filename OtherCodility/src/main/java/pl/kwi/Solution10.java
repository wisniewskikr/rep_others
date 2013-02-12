package pl.kwi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10 {
	
	private static int MAX_RESULT = 10000000;
	
	public int number_of_disc_intersections(int[] A){
		
		Math.abs(1d);
		
		if(A == null || A.length == 0){
			return -1;
		}
		
		int result = 0;
		
		List<Disk> list = new ArrayList<Disk>();
		for (int i = 0; i < A.length; i++) {
			list.add(new Disk(i, A[i]));
		}
		
		int index = 0;
		while(!list.isEmpty()){
			Disk current = list.get(0);
			index++;
			if(index >= list.size()){
				list.remove(0);
				index = 0;
			}else{
				
				Disk next = list.get(index);
								
				if(next.min <= current.max && next.max >= current.min){
					result++;
					
					if(result > MAX_RESULT){
						return -1;
					}
				}
			}			
		}
		
		return result;
		
	}
	
	
	class Disk{
				
		int index;
		int radius;
		int max;
		int min;
		
		public Disk(int index, int radius) {
			this.index = index;
			this.radius = radius;
			
			this.max = index + radius;
			this.min = index - radius;
		}
		
		
		
	}
	
	
	public int number_of_disc_intersections2(int[] A){
		
		if (A == null || A.length < 2) {
			  return 0;
			}

			int[] B = Arrays.copyOf(A, A.length);
			Arrays.sort(B);
			int biggest = B[A.length - 1];
			int intersections = 0;
			for (int i = 0; i < A.length; i++) {
			  for (int j = i + 1; j < A.length; j++) {
			    if (j - biggest > i + A[i]) {
			      break;
			    }
			    if (j - A[j] <= i + A[i]) {
			      intersections++;
			    }
			    if (intersections > 10000000) {
			      return -1;
			    }
			  }
			}

			return intersections;
		
	}
	
}




