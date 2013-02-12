package pl.kwi;

public class Solution11 {
	
	
	public static void main(String[] args) {
		
		Solution11 s = new Solution11();
		int[] A = new int[10];		
		A[0] =  0;
		A[1] =  1;
		A[2] = 3;
		A[3] = -2;
		A[4] =  0;
		A[5] = 1;
		A[6] =  0;
		A[7] = -3;    
		A[8] = 2;
		A[9] =  3;
		
		int result = s.deepest_pit(A);
		System.out.println(result);
		
	}

	
	 public int deepest_pit ( int[] A ) {
		    
		 if(A == null || A.length == 0 || A.length > 1000000){
			 return 0;
		 }
		 
		 int N = A.length;
		    Integer result = null;
		    
		    
		    
		    for (int i = 0; i < N - 2; i++) {
		    	int P = i;
		    	for (int j = i + 1; j < N - 1; j++) {
					int Q = j;
					
					if(!isDecreasing(P, Q, A)){
						continue;
					}
					
					for (int k = j + 1; k < N; k++) {
						int R = k;
						
						if(!isIncreasing(Q, R, A)){
							continue;
						}
						
						int pick = getPick(P, Q, R, A);
						if(result == null || pick > result){
							result = pick;
						}
						
					}
				}
				
			}
		    
		    if(result == null){
		    	return -1;
		    }else{
		    	return result;
		    }
		    
	 }
	 
	 private boolean isDecreasing(int P, int Q, int[] A ){
		 
		 for (int i = P; i < Q; i++) {
			 
				 int first = A[i];
				 int second = A[i + 1];
				 
				 if(second >= first){
					 return false;
				 }				 
			
		}
			 
		 return true;
		 
	 }
	 
	 private boolean isIncreasing(int Q, int R, int[] A ){
		 
		 for (int i = Q; i < R; i++) {
			 
			 int first = A[i];
			 int second = A[i + 1];
			 
			 if(second <= first){
				 return false;
			 }				 
		
	}
		 
	 return true;
		 
	 }
	 
	 private int getPick(int P, int Q, int R, int[] A){
		 
		 return Math.min(A[P] - A[Q], A[R] - A[Q]);
		 
	 }
	
}
