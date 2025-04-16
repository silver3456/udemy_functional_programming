package com.udemy.function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

//        Function<String, Integer> strLen = (s -> s.length());
//        Function<Integer, Integer> square = (i -> i * i);
//
//        System.out.println(
//                strLen.andThen(square).apply("hey how are you doing?")
//
//        );

        Function<Integer, Integer> plus2 = (s -> s + 2);
        Function<Integer, Integer> square = (i -> i * i);

//        System.out.println(
//                plus2.andThen(square).apply(8)
//
//        );

        System.out.println(
                plus2.compose(square).apply(8)

        );
    }
}
