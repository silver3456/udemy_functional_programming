package com.udemy.polymorphism;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {

        Predicate<Integer> isGT2 = (n)-> n > 2;
        Predicate<Integer> isLT10 = (n)-> n < 10;

        System.out.println(
               isGT2.and(isLT10).test(3)
        );


    }
}
