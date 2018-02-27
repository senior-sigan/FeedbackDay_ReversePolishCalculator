package it.sevenbits.calculator.nodes;

import it.sevenbits.calculator.stack.Stack;

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
