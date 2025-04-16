package com.udemy.callable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CallableTest {

    public static void main(String[] args) throws Exception {

        Supplier<Double> random1 = Math::random;
        Callable<Double> random2 = Math::random;

        System.out.println(random1.get());
        System.out.println(random2.call());

    }
}


