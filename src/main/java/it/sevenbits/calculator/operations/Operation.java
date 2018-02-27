package it.sevenbits.calculator.operations;

public interface Operation {
    String getSymbol();

    double apply(double... operands);

    int getArity();
}
