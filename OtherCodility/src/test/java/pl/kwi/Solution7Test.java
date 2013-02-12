package pl.kwi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Solution7Test {
	
	private Solution7 solution7;
	
	@Before
	public void setUp(){
		solution7 = new Solution7();
	}

	@Test
	public void power_fib() {
		int N = 2;
		int M = 3;
		
		long result = solution7.power_fib(N, M);
		
		assertEquals(21, result);
	}

}
