package it.sevenbits.calculator;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    public float eval(String expression) throws CalcException {
        if (expression == null || expression.isEmpty()) return 0f;
        String[] list = expression.split(" ");
        Stack numbers = new ArrayStack();
        for (String el : list) {
            if (isNumber(el)) {
                numbers.push(Float.parseFloat(el));
            } else {
                try {
                    switch (el) {
                        case "+":
                            numbers.push(numbers.pop() + numbers.pop());
                            break;
                        case "-":
                            numbers.push(-numbers.pop() + numbers.pop());
                            break;
                        case "*":
                            numbers.push(numbers.pop() * numbers.pop());
                            break;
                        case "/":
                            numbers.push((1f / numbers.pop()) * numbers.pop());
                            break;
                    }
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
