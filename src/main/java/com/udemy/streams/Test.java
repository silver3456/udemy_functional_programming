package com.udemy.streams;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int sum = a + b;
        b = sum - b;
        a = sum - a;

        System.out.println("a : " + a + " " + "b : " + b);

    }
}
