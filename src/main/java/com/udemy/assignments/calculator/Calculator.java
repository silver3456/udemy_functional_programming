package com.udemy.assignments.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final Map<String, MathOperation> MAP = new HashMap<>();

    static {
        MAP.put("+", (a, b) -> a + b);
        MAP.put("-", (a, b) -> a - b);
        MAP.put("*", (a, b) -> a * b);
        MAP.put("/", (a, b) -> a / b);

    }

    public static void addOperation(String operator, MathOperation op) {
        MAP.put(operator, op);
    }

    public static int calculate(String expression) {
        String[] exps = expression.split(" ");
        int onScreenNumber = Integer.parseInt(exps[0]);
        for (int i = 1; i < exps.length; i = i + 2) {
            MathOperation op = MAP.get(exps[i]);
            int enteredNumber = Integer.parseInt(exps[i + 1]);
            onScreenNumber = calculate(onScreenNumber, op, enteredNumber);
        }
        return onScreenNumber;
    }

    private static int calculate(int onScreenNumber, MathOperation mo, int enteredNumber) {
        return mo.operate(onScreenNumber, enteredNumber);
    }

}
