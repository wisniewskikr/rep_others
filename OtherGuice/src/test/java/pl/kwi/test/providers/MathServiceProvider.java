package pl.kwi.test.providers;

import org.mockito.Mockito;

import com.google.inject.Provider;

import pl.kwi.services.IMathService;

public class MathServiceProvider implements Provider<IMathService>{

	@Override
	public IMathService get() {
		
		IMathService mock = Mockito.mock(IMathService.class);
		Mockito.when(mock.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
		
		return mock;
	}

}
