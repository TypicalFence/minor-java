package moe.zaun.prismriver.minor.service;

public class DefaultGreeter implements Greeter {
   public String greet(final String name) {
      return "Hello " + name;
   }
}
