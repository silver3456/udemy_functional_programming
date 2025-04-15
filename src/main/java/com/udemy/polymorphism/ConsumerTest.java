package com.udemy.polymorphism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Alex");
        list.add("Seliverov");

        Consumer<String> dbConsumer = (s ->
                System.out.println("Writing into DB:: " + s));

        Consumer<String> logConsumer = (s ->
                System.out.println("Writing into log file:: " + s));

        Consumer<String> dbLogConsumer = dbConsumer.andThen(logConsumer);

        list.forEach(dbLogConsumer);

        BiConsumer<String, Integer> biConsumer = (s, i) -> {
            System.out.println("My name is : " + s);
            System.out.println("My age is : " + i);
        };

        biConsumer.accept("Alex", 38);


        final Map<String, Consumer<String>> MAP = new HashMap<>();
        MAP.put("db", dbConsumer);
        MAP.put("log", logConsumer);
        MAP.put("dbLog", dbLogConsumer);

        MAP.forEach((k, v)->{
            System.out.println("My key is: " + k);
        });
    }
}