package it.sevenbits.calculator;

import java.util.ArrayList;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    public float eval(String expression) {
        if (expression == null || expression.isEmpty()) return 0f;
        String[] list = expression.split(" ");
        ArrayList<Float> numbers = new ArrayList<>();
        for (String el : list) {
            if (isNumber(el)) {
                numbers.add(Float.parseFloat(el));
            } else {
                float n;
                switch (el) {
                    case "+":
                        n = numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.add(n);
                        break;
                    case "-":
                        n = numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.add(n);
                        break;
                    case "*":
                        n = numbers.get(numbers.size() - 2) * numbers.get(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.add(n);
                        break;
                    case "/":
                        n = numbers.get(numbers.size() - 2) / numbers.get(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.add(n);
                        break;
                }
            }
        }

        return numbers.get(numbers.size() - 1);
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
