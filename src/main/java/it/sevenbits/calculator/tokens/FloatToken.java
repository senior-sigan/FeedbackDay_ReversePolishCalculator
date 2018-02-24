package it.sevenbits.calculator.tokens;

import it.sevenbits.calculator.stack.Stack;

public class FloatToken implements Token {
    private final float value;

    public FloatToken(float value) {
        this.value = value;
    }

    @Override
    public void act(final Stack stack) {
        stack.push(value);
    }
}
