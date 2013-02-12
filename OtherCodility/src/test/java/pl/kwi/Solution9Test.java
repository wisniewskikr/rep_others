package pl.kwi;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class Solution9Test {
	
	private Solution9 solution9;
	
	@Before
	public void setUp(){
		solution9 = new Solution9();
	}

	@Test
	public void invCount() {
		int[] A = new int[3];
		A[0] = 3;
		A[1] = 2;
		A[2] = 1;
		
		int result = solution9.invCount(A);
		
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void invCount2(){
		
		int[] A = new int[4];
		A[0] = 4;
		A[1] = 2;
		A[2] = 1;
		A[3] = 3;
		
		int result = solution9.invCount(A);
		
		Assert.assertEquals(4, result);
		
	}

}
