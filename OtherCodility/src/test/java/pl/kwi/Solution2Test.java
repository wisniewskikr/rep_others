package pl.kwi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Solution2Test {

	
	private Solution2 solution2;
	
	@Before
	public void setUp(){
		solution2 = new Solution2();
	}
	
	@Test
	public void ps() {
		int[] A = new int[5];
		A[0] = 2;
		A[1] = 2;
		A[2] = 1;
		A[3] = 0;
		A[4] = 1;
		
		int result = solution2.ps(A);
		
		assertEquals(3, result);
		
	}
	
	@Test
	public void ps_2() {
		int[] A = new int[5];
		A[0] = 0;
		A[1] = 1;
		A[2] = 2;
		A[3] = 3;
		A[4] = 4;
		
		int result = solution2.ps(A);
		
		assertEquals(4, result);
		
	}

}
