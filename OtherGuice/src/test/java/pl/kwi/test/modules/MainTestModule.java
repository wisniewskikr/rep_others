package pl.kwi.test.modules;

import pl.kwi.services.IMathService;
import pl.kwi.test.providers.MathServiceProvider;

import com.google.inject.Binder;
import com.google.inject.Module;

public class MainTestModule implements Module {

	public void configure(Binder binder) {
        binder.bind(IMathService.class).toProvider(MathServiceProvider.class);
    }

}
