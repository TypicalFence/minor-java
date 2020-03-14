package moe.zaun.prismriver.minor.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import moe.zaun.prismriver.minor.controller.OrderController;

public class OrderModule implements Module {
   public void configure(final Binder binder) {
      binder.bind(OrderController.class);
   }
}
