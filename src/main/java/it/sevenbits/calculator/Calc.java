package it.sevenbits.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private final Map<String, Operation> operations;
    private final Tokenizer tokenizer;
    private final Supplier<Stack> stackBuilder;

    public Calc(
            final Tokenizer tokenizer,
            final Supplier<Stack> stackBuilder,
            final OperationsLoader loader
    ) {
        this.tokenizer = tokenizer;
        this.stackBuilder = stackBuilder;
        this.operations = new HashMap<>();
        for (final Operation op : loader.load()) {
            operations.put(op.getName(), op);
        }
    }

    public float eval(String expression) throws CalcException {
        List<String> tokens = tokenizer.tokenize(expression);
        Stack numbers = stackBuilder.get();
        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Float.parseFloat(token));
            } else {
                try {
                    Operation operation = operations.get(token);
                    if (operation == null)
                        throw new CalcException(String.format("Cannot eval expression '%s', unknown operation: '%s'", expression, token));
                    numbers.push(operation.apply(numbers.pop(), numbers.pop()));
                } catch (StackException e) {
                    throw new CalcException("Can't eval expression: " + expression, e);
                }
            }
        }

        try {
            if (numbers.isEmpty()) return 0f;
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
