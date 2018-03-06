package it.sevenbits.calculator.core.operations;

public interface Operation {
    String getSymbol();

    double apply(double... operands);

    int getArity();
}
