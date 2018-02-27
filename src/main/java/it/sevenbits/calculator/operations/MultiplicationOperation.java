package it.sevenbits.calculator.operations;

public class MultiplicationOperation implements Operation {
    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public double apply(double... operands) {
        return operands[0] * operands[1];
    }

    @Override
    public int getArity() {
        return 2;
    }
}
