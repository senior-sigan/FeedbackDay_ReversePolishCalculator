package it.sevenbits.calculator.core.stack;

/**
 * FIFO data structure.
 */
public interface Stack {
    double pop();

    void push(double n);

    boolean isEmpty();
}
