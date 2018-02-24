package it.sevenbits.calculator.operations;

public class DivisionOperation implements Operation {
    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public float apply(final float... operands) {
        return operands[1] / operands[0];
    }

    @Override
    public int getArity() {
        return 2;
    }
}
