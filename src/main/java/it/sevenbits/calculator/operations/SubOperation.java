package it.sevenbits.calculator.operations;

import it.sevenbits.calculator.Operation;

public class SubOperation implements Operation {
    @Override
    public float apply(final float left, final float right) {
        return right - left;
    }

    @Override
    public String getName() {
        return "-";
    }
}
