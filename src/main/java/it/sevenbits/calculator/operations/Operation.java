package it.sevenbits.calculator.operations;

public interface Operation {
    String getSymbol();

    float apply(float... operands);

    int getArity();
}
