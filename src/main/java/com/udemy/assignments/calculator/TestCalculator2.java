package com.udemy.assignments.calculator;


public class TestCalculator2 {

    public static void main(String[] args) {

        MathOperation add = (a, b) -> a + b;
        MathOperation substract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;

        int onScreenNumber = 0;

        onScreenNumber = calculate(5, add, 2);
        onScreenNumber = calculate(onScreenNumber, substract, 3);
        onScreenNumber = calculate(onScreenNumber, multiply, 7);
        onScreenNumber = calculate(onScreenNumber, add, 2);
        onScreenNumber = calculate(onScreenNumber, divide, 3);


        System.out.println("Result: " + onScreenNumber);


        // 5 + 2 - 3 * 7 + 2 /3

    }

    private static int calculate(int onScreenNumber, MathOperation mo, int enteredNumber) {
        return mo.operate(onScreenNumber, enteredNumber);
    }
}
