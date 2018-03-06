package it.sevenbits.calculator.core.nodes;

import it.sevenbits.calculator.core.stack.Stack;

public class FloatNode implements Node {
    private final float value;

    public FloatNode(float value) {
        this.value = value;
    }

    @Override
    public void act(final Stack stack) {
        stack.push(value);
    }
}
