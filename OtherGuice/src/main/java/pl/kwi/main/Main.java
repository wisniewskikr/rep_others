package pl.kwi.main;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import pl.kwi.services.IMathService;

public class Main {
		
	@Inject
	private IMathService mathService;
	
	
	public int add(int a, int b){
		return mathService.add(a, b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector();
        Main main = injector.getInstance(Main.class);
		int result = main.add(2, 3);
		System.out.println("result: " + result);
		
	}

}
