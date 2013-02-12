package pl.kwi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Solution4Test {
	
	private Solution4 solution4;
	
	@Before
	public void setUp(){
		solution4 = new Solution4();
	}

	@Test
	public void count_tilings() {
		
		int rows = 1;
		int cols = 1;
		
		int result = solution4.count_tilings(rows, cols);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void count_tilings2() {
		
		int rows = 2;
		int cols = 2;
		
		int result = solution4.count_tilings(rows, cols);
		
		assertEquals(2, result);
		
	}
	
	@Test
	public void count_tilings3() {
		
		int rows = 2;
		int cols = 3;
		
		int result = solution4.count_tilings(rows, cols);
		
		assertEquals(3, result);
		
	}
	
	@Test
	public void count_tilings4() {
		
		int rows = 4;
		int cols = 3;
		
		int result = solution4.count_tilings(rows, cols);
		
		assertEquals(11, result);
		
	}
	
	@Test
	public void count_tilings5() {
		
		int rows = 6;
		int cols = 5;
		
		int result = solution4.count_tilings(rows, cols);
		
		assertEquals(134, result);
		
	}

}
