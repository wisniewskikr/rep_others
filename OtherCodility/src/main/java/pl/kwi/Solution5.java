package pl.kwi;

public class Solution5 {
	
	private int[] array;
	
	public int[] array_closest_ascenders(int A[]){
		
		this.array = A;
		int[] result = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			
			Ascender asc = null;
			
			Ascender leftAscender = getAscender(0, i - 1, array[i]);
			Ascender rightAscender = getAscender(i + 1, A.length - 1, array[i]);
			
			if(leftAscender != null && rightAscender != null){
				if (leftAscender.value == rightAscender.value){
					int idxLeft = Math.abs(i - leftAscender.index);
					int idxRight = Math.abs(i - rightAscender.index);
					if(idxLeft <= idxRight){
						asc = leftAscender;
					}else{
						asc = rightAscender;
					}					
				}else if(leftAscender.value < rightAscender.value){
					asc = leftAscender;
				}else{
					asc = rightAscender;
				}
			}else if(leftAscender != null && rightAscender == null){
				asc = leftAscender;
			}else if(leftAscender == null && rightAscender != null){
				asc = rightAscender;
			}
			
			if(asc == null){
				result[i] = 0;
			}else{
				result[i] = Math.abs(i - asc.index);
			}
			
		}
		
		return result;
		
	}
	
	public Ascender getAscender(int startIndex, int endIndex, int value){
				
		Ascender result = null;
		
		if(endIndex < startIndex){
			return result;
		}			
		
		for(int i = startIndex; i <= endIndex; i++){
			int arrayValue = array[i];
			int tmpValue = arrayValue - value;
			
			if(tmpValue > 0 && result == null){
				result = new Ascender(arrayValue, i);
			}else if(tmpValue > 0 && result != null && tmpValue < (result.value - value)){
				result = new Ascender(arrayValue, i);
			}
			
		}
		
		return result;
		
	}
	
	class Ascender{
		
		int value;
		int index;
		
		
		public Ascender(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
	}
}




