package it.sevenbits.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private Map<String, Operation> operations;

    public Calc() {
        this.operations = new HashMap<>();
        operations.put("+", (left, right) -> left + right);
        operations.put("-", (left, right) -> right - left);
        operations.put("*", (left, right) -> left * right);
        operations.put("/", (left, right) -> right / left);
    }

    public float eval(String expression) throws CalcException {
        if (expression == null || expression.isEmpty()) return 0f;
        String[] list = expression.split(" ");
        Stack numbers = new ArrayStack();
        for (String el : list) {
            if (isNumber(el)) {
                numbers.push(Float.parseFloat(el));
            } else {
                try {
                    Operation operation = operations.get(el);
                    if (operation == null)
                        throw new CalcException(String.format("Cannot eval expression '%s', unknown operation: '%s'", expression, el));
                    numbers.push(operation.apply(numbers.pop(), numbers.pop()));
                } catch (StackException e) {
                    throw new CalcException("Can't eval expression: " + expression, e);
                }
            }
        }

        try {
            return numbers.pop();
        } catch (StackException e) {
            throw new CalcException("Can't get calculation result", e);
        }
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
