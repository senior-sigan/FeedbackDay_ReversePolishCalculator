package it.sevenbits.calculator.operations;

public class AdditionOperation implements Operation {
    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public float apply(final float... operands) {
        return operands[0] + operands[1];
    }

    @Override
    public int getArity() {
        return 2;
    }
}
