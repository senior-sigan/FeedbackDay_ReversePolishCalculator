package it.sevenbits.calculator.nodes;

import it.sevenbits.calculator.operations.Operation;
import it.sevenbits.calculator.stack.Stack;

public class OperationNode implements Node {
    private final Operation operation;

    public OperationNode(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void act(final Stack stack) {
        double[] operands = new double[operation.getArity()];
        for (int i = 0; i < operation.getArity(); i++) {
            operands[i] = stack.pop();
        }
        stack.push(operation.apply(operands));
    }
}
