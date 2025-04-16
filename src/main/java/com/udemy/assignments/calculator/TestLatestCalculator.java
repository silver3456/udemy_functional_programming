package com.udemy.assignments.calculator;

public class TestLatestCalculator {


    //
    public static void main(String[] args) {
        String exp = "5 + 2 - 3 * 7 + 2 / 3 ^ 2";

        Calculator.addOperation("^", (a, b) -> (int) Math.pow(a, b));

        System.out.println(
                Calculator.calculate(exp)

        );
    }
}
