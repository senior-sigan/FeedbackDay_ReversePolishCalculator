package it.sevenbits.calculator.stack;

/**
 * FIFO data structure.
 */
public interface Stack {
    float pop();

    void push(float n);

    boolean isEmpty();
}
