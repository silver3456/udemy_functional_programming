package com.udemy.optional;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {

        String a = "Apple";
        String b = "Banana";
        String c = "Carrot";

        Optional<String> smallest = findSmallest(a, b, c);

        if (smallest.isPresent()) {
            System.out.println(smallest.get());
        } else {
            System.out.println("Nothing is found");
        }


    }

    private static Optional<String> findSmallest(String var1, String var2, String var3) {
        return Stream.of(var1, var2, var3)
                .min(Comparator.naturalOrder());
    }
}
