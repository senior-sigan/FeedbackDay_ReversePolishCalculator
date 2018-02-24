package it.sevenbits.calculator;

import it.sevenbits.calculator.operations.Operation;

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

    public Calc(Tokenizer tokenizer, Supplier<Stack> stackBuilder, List<Operation> operations) {
        this.tokenizer = tokenizer;
        this.stackBuilder = stackBuilder;
        this.operations = new HashMap<>();
        operations.forEach(operation ->
                this.operations.put(operation.getSymbol(), operation));
    }

    public float eval(String expression) {
        List<String> tokens = tokenizer.tokenize(expression);
        if (tokens == null || tokens.isEmpty()) return 0f;
        Stack numbers = stackBuilder.get();
        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Float.parseFloat(token));
            } else {
                Operation op = operations.get(token);
                float[] operands = new float[op.getArity()];
                for (int i = 0; i < op.getArity(); i++) {
                    operands[i] = numbers.pop();
                }
                numbers.push(op.apply(operands));
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
