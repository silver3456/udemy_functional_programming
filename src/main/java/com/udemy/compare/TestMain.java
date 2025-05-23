package com.udemy.compare;

import java.util.*;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {

        Student a = new Student("Adam", 80, 150);
        Student b = new Student("Bob", 96, 123);
        Student c = new Student("Carl", 75, 135);

        Optional<Student> op = Stream.of(a, b, c)
                .max(Comparator.comparing(s -> s.getHeight()));

        System.out.println(op.get().toString());

    }
}
