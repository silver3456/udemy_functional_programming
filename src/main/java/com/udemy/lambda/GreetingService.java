package com.udemy.lambda;

// SAM - single abstract method

@FunctionalInterface
public interface GreetingService {

    String greet(String name);


}
