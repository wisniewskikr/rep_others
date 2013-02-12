package pl.kwi;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	
	
	public int ps ( int[] A ) {
		
        if(A == null || A.length == 0 || A.length > 1000000){
          return -1;
	}
          
	    
	Set set = new HashSet();
	    
	for(int i = 0; i < A.length; i++){
	    	
	    	int x = A[i];	    	
		if(x > A.length -1){
	    		return -1;
	    	}	    	
	      set.add(x);
	}
	    
	for(int i = 0; i < A.length; i++){
	      set.remove(A[i]);
	      if(set.isEmpty()){
	    	  return i;
	      }
	}
	    
	return -1;	    
	    
    }

}
