package com.udemy.streams;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);


        list.stream()
                .peek(i-> System.out.println("Filter received:: " + i))
                .filter(i -> i % 2 == 0)
//                .sorted()
                .limit(3)
                .map(i -> i * i)
                .forEach(System.out::println);
    }
}
