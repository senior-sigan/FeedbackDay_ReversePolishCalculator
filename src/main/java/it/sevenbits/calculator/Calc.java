package it.sevenbits.calculator;

import it.sevenbits.calculator.operations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private Map<String, Operation> operations;
    private Tokenizer tokenizer;
    private Supplier<Stack> stackBuilder;

    public Calc(Tokenizer tokenizer, Supplier<Stack> stackBuilder) {
        this.tokenizer = tokenizer;
        this.stackBuilder = stackBuilder;
        operations = new HashMap<>();
        operations.put("+", new AdditionOperation());
        operations.put("*", new MultiplicationOperation());
        operations.put("-", new SubtractionOperation());
        operations.put("/", new DivisionOperation());
    }

    public float eval(String expression) {
        List<String> tokens = tokenizer.tokenize(expression);
        if (tokens == null || tokens.isEmpty()) return 0f;
        Stack numbers = stackBuilder.get();
        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Float.parseFloat(token));
            } else {
                numbers.push(operations.get(token).apply(
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
