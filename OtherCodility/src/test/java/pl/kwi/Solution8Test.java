package pl.kwi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Solution8Test {
	
	private Solution8 solution8;
	
	@Before
	public void setUp(){
		solution8 = new Solution8();
	}

	@Test
	public void sparse_binary_count() {
		
		String S = "101";
		String T = "1111";
		int K = 2;
		
		int result = solution8.sparse_binary_count(S, T, K);
		
		assertEquals(2, result);
	}

}
