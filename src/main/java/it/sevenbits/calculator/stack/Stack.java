package it.sevenbits.calculator.stack;

/**
 * FIFO data structure.
 */
public interface Stack {
    double pop();

    void push(double n);

    boolean isEmpty();
}
