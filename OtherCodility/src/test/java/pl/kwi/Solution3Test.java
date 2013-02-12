package pl.kwi;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class Solution3Test {
	
private Solution3 solution3;
	
	@Before
	public void setUp(){
		solution3 = new Solution3();
	}

	@Test
	public void dominator() {
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
		v.add(2);
		v.add(2);
		v.add(1);
		v.add(3);
		v.add(1);
		v.add(2);
		v.add(2);
		
		int result = solution3.dominator(v);
		
		assertEquals(-1, result);
	}

}
