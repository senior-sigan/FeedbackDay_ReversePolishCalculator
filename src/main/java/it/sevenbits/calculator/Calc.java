package it.sevenbits.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private Map<String, BiFunction<Float, Float, Float>> operations;

    public Calc() {
        operations = new HashMap<>();
        operations.put("+", (left, right) -> left + right);
        operations.put("*", (left, right) -> left * right);
        operations.put("-", (left, right) -> right - left);
        operations.put("/", (left, right) -> right / left);
    }

    public float eval(String expression) {
        if (expression == null || expression.isEmpty()) return 0f;
        String[] list = expression.split(" ");
        Stack numbers = new ArrayStack();
        for (String el : list) {
            if (isNumber(el)) {
                numbers.push(Float.parseFloat(el));
            } else {
                numbers.push(operations.get(el).apply(
                        numbers.pop(),
                        numbers.pop()
                ));
            }
        }

        return numbers.pop();
    }

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
