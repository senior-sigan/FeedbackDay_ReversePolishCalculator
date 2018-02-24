package it.sevenbits.calculator.tokens;

import it.sevenbits.calculator.operations.Operation;
import it.sevenbits.calculator.stack.Stack;

public class OperationToken implements Token {
    private final Operation operation;

    public OperationToken(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void act(final Stack stack) {
        float[] operands = new float[operation.getArity()];
        for (int i = 0; i < operation.getArity(); i++) {
            operands[i] = stack.pop();
        }
        stack.push(operation.apply(operands));
    }
}
