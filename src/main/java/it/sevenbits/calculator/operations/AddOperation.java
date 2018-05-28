package it.sevenbits.calculator.operations;

import it.sevenbits.calculator.Operation;

public class AddOperation implements Operation {
    @Override
    public float apply(final float left, final float right) {
        return left + right;
    }

    @Override
    public String getName() {
        return "+";
    }
}
