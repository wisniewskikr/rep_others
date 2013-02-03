package pl.kwi.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.kwi.test.modules.MainTestModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainTest {
	
	private Main main;
	
	@Before
	public void setUp(){
		Injector injector = Guice.createInjector(new MainTestModule());
        main = injector.getInstance(Main.class);
	}

	@Test
	public void add() {
		int result = main.add(3, 2);
		assertEquals(5, result);
	}

}
