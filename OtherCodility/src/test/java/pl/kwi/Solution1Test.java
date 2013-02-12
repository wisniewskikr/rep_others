package pl.kwi;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class Solution1Test {
	
	private Solution1 solution1;
	
	@Before
	public void setUp(){
		solution1 = new Solution1();
	}

	@Test
	public void equi() {
		int[] A = new int[7];
		A[0] = -7;
		A[1] =  1;  
		A[2] = 5;
		A[3] =  2;   
		A[4] = -4;   
		A[5] = 3;
		A[6] =  0;
		
		int result = solution1.equi(A);
		
		Assert.assertEquals(3, result);
	}

}
