package moe.zaun.prismriver.minor.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import moe.zaun.prismriver.minor.controller.HelloController;
import moe.zaun.prismriver.minor.service.DefaultGreeter;
import moe.zaun.prismriver.minor.service.Greeter;

public class HelloModule implements Module {
    public void configure(final Binder binder) {
        binder.bind(HelloController.class);
        binder.bind(Greeter.class).to(DefaultGreeter.class);
    }
}
