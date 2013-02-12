package pl.kwi;

import java.util.HashMap;
import java.util.Map;

public class Solution7 {
	
	Map<Long, Long> map = new HashMap<Long, Long>();
	
	public Long power_fib(int N, int M){
		
		Double x = Math.pow(N, M);
		return fib(x.longValue());
	}
	
	public Long fib(Long x){
		
		Long result = map.get(x);
		
		if(result != null) {
			return result;
		}
		
		if(x < 0){
			result = 0L;
		} else if(x == 0){
			result = 0L;
		} else if(x == 1){
			result = 1L;
		} else{
			result = fib(x - 1) + fib(x - 2);
		}
		
		map.put(x, result);
		return result;
		
	}
	
	
}




