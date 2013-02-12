package pl.kwi;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Solution3 {
	
	public int dominator(Vector<Integer> A) {
		
		Map<Integer, Count> map = new HashMap<Integer, Count>();
		int half = A.size()/2;
		
		for (Integer integer : A) {
			
			Count c = map.get(integer);
			if(c == null){
				c = new Count();
				map.put(integer, c);
			}else{
				c.increase();
			}
						
			if(c.getCount() > half){
				return integer;
			}			
		}
		
		return -1;
		
	}
	
	class Count{
		
		private int count = 1;
		
		public int getCount(){
			return count;
		}
		
		public void increase(){
			count ++;
		}
		
	}

}




