package pl.kwi;

public class Solution4 {
	
	public int count_tilings(int N, int M){
		
		if(N < 2 || M < 2){
			return 1;
		}
		
		int rows = N;
		int cols = M;
		// No 2/2 tiles
		int count = 1;
		
		int rowCount = countForOneRow(cols);
		count += countForAllSingleRows(rowCount, rows);
		count += countForAllCombinateRows(rowCount, rows);
		
		return count;
		
	}
	
	public int countForOneRow(int cols){
		
		int result = 0;
		
		int maxInCol = cols/2;
		for(int i = maxInCol; i >= 1; i--){
			int rest = cols - (i * 2);
			result += (i * rest) + 1;
		}
		
		return result;
		
	}
	
	public int countForAllSingleRows(int rowCount, int rows){		
		return (rows -1) * rowCount;		
	}
	
	public int countForAllCombinateRows(int rowCount, int rows){
		return ((rows / 2) - 1) * (rowCount * rowCount);	
	}
	
}




