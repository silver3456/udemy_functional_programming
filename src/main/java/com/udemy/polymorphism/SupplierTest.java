package com.udemy.polymorphism;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Double> random = Math::random;
        System.out.println(random.get());


    }


}
