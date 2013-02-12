package pl.kwi;
import java.util.HashSet;
import java.util.Set;


public class Solution12 {
	
	public static void main(String[] args) {
		
		int[] A = new int[6];
		A[0] = 2;
		A[1] = 1;
		A[2] = 1;
		A[3] = 2;
		A[4] = 3;
		A[5] = 1;
		
		Solution12 s = new Solution12();
		int result = s.distinct(A);
		
		System.out.println(result);
		
		
	}
	
	public int distinct ( int[] A ) {
		
		if(A == null || A.length > 100000){
			return 0;
		}
		
		Set<Integer> s = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; i++) {
			s.add(A[i]);
		}
		
		return s.size();
	
	}

}
