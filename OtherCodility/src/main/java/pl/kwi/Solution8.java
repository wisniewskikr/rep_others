package pl.kwi;

public class Solution8 {
	
	public static void main(String[] args) {
		
		int i = Integer.parseInt("101", 2);
		System.out.println(i);
		String s = Integer.toBinaryString(i);
		System.out.println(s);
		
		
		
	}
	
	public int sparse_binary_count(String S,String T,int K){
		
		int result = 0;
		
		int startIndex = Integer.parseInt(S, 2);
		int endIndex = Integer.parseInt(T, 2);
		
		String pattern = getPattern(K);
		for (int i = startIndex; i <= endIndex; i++) {
			if(isSparse(i, pattern)){
				result++;
			}
		}
		
		return result;
		
	}
	
	public boolean isSparse(int i, String pattern){
		
		String binaryRep = Integer.toBinaryString(i);
		
		if(binaryRep.contains(pattern)){
			return true;
		} else if(isPower2(binaryRep)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public String getPattern(int K){
		
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		for (int i = 0; i < K; i++) {
			sb.append("0");
		}
		sb.append("1");
		return sb.toString();
		
	}
	
	public boolean isPower2(String s){
		
		boolean result = false;
		
		int counter = 0;
		for( int i=0; i<s.length(); i++ ) {
		    if( s.charAt(i) == '1' ) {
		        counter++;
		    } 
		}
		
		if(counter == 1){
			return true;
		}
		
		return result;
	}
	
}




