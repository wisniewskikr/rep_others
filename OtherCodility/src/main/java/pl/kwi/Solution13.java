package pl.kwi;
import java.util.HashMap;
import java.util.Map;


public class Solution13 {
	
	public static void main(String[] args) {
		
		int[] A = new int[8];
		A[0] = 3;
		A[1] = 4;
		A[2] =  3;
		A[3] = 2;
		A[4] = 3;
		A[5] = -1;
		A[6] = 3;
		A[7] = 3;
		
		Solution13 s = new Solution13();
		int result = s.dominator(A);
		
		System.out.println(result);
		
	}
	
public int dominator(int[] A) {
	
	if(A == null || A.length > 1000000){
		return 0;
	}
		
		Map<Integer, Count> map = new HashMap<Integer, Count>();
		int half = A.length/2;
		
		int index = 0;
		for (Integer integer : A) {
			
			Count c = map.get(integer);
			if(c == null){
				c = new Count();
				map.put(integer, c);
			}else{
				c.increase();
			}
						
			if(c.getCount() > half){
				return index;
			}
			
			index++;
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
