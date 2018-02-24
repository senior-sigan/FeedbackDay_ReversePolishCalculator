package it.sevenbits.calculator;

/**
 * FIFO data structure.
 */
public interface Stack {
    float pop();

    void push(float n);

    boolean isEmpty();
}
