package com.udemy.assignments.calculator;

public class TestCalculator {

    public static void main(String[] args) {

        // Add function
        MathOperation add = (a, b )-> a + b;
        int addResult = calculate(add);
        System.out.println("Addition: " + addResult);

        // Substract function
        MathOperation substract = (a, b)-> a-b;
        int subResult = calculate(substract);
        System.out.println("Substraction: " + subResult);

        // Multiply function
        MathOperation multiply = (a, b) -> a * b;
        int multipResult = calculate(multiply);
        System.out.println("Multiply result: " + multipResult);

        // Division function
        MathOperation divide = (a, b) -> a / b;
        int devisionResult = calculate(divide);
        System.out.println("Division result: " + devisionResult);



    }

    private static int calculate(MathOperation mo) {
        int a = 100;
        int b = 5;
        return mo.operate(a, b);
    }
}
