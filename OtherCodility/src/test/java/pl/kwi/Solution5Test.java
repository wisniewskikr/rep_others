package pl.kwi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Solution5Test {

	private Solution5 solution5;
	
	@Before
	public void setUp(){
		solution5 = new Solution5();
	}

	@Test
	public void array_closest_ascenders() {
		int[] A = new int[9];
		A[0] = 4;
		A[1] = 3;
		A[2] = 1;
		A[3] = 4;
		A[4] = -1;
		A[5] = 2;
		A[6] = 1;
		A[7] = 5;
		A[8] = 7;
		
		int[] result = solution5.array_closest_ascenders(A);
		assertEquals(7, result[0]);
		assertEquals(1, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		assertEquals(2, result[4]);
		assertEquals(4, result[5]);
		assertEquals(1, result[6]);
		assertEquals(1, result[7]);
		assertEquals(0, result[8]);
	}

}
