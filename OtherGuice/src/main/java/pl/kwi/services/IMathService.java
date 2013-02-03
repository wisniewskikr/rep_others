package pl.kwi.services;

import com.google.inject.ImplementedBy;

@ImplementedBy(MathService.class)
public interface IMathService {
	
	public int add(int a, int b);

}
