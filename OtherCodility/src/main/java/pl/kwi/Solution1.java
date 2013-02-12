package pl.kwi;

//you can also use imports, for example:
//import java.math.*;
class Solution1 {

	int[] array;

	public int equi(int[] A) {
		
		if(A == null || A.length == 0 || A.length > 10000000){
			return -1;
		}

		this.array = A;
		int N = A.length;
		long leftIndex;
		long rightIndex;

		for (int i = 1; i < N; i++) {

			leftIndex = getSum(0, i - 1);
			rightIndex = getSum(i + 1, N - 1);

			if (leftIndex == rightIndex) {
				return i;
			}

		}

		int sum = getSum(0, N - 1);
		if (sum == 0) {
			return N - 1;
		} else {
			return -1;
		}

	}

	protected int getSum(int from, int to) {

		int result = 0;

		for (int i = from; i <= to; i++) {
			result += array[i];
		}

		return result;

	}

}
