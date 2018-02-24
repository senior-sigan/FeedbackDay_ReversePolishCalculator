package it.sevenbits.calculator;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    public float eval(String expression) {
        if (expression == null || expression.isEmpty()) return 0f;
        String[] list = expression.split(" ");
        Stack numbers = new ArrayStack();
        for (String el : list) {
            if (isNumber(el)) {
                numbers.push(Float.parseFloat(el));
            } else {
                float n;
                switch (el) {
                    case "+":
                        n = numbers.pop() + numbers.pop();
                        numbers.push(n);
                        break;
                    case "-":
                        n = -numbers.pop() + numbers.pop();
                        numbers.push(n);
                        break;
                    case "*":
                        n = numbers.pop() * numbers.pop();
                        numbers.push(n);
                        break;
                    case "/":
                        n = (1f / numbers.pop()) * numbers.pop();
                        numbers.push(n);
                        break;
                }
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
