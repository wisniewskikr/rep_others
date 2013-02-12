package pl.kwi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Solution10Test {
	
	private Solution10 solution10;
	
	@Before
	public void setUp(){
		solution10 = new Solution10();
	}

	@Test
	public void number_of_disc_intersections() {
		
		int[] A = new int[6];
		A[0] = 1;
		A[1] = 5;
		A[2] = 2;
		A[3] = 1;
		A[4] = 4;
		A[5] = 0; 
		
		int result = solution10.number_of_disc_intersections(A);
		
		assertEquals(11, result);
	}

}
