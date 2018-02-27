package it.sevenbits.calculator.nodes;

import it.sevenbits.calculator.stack.Stack;

/**
 * The Node responsible for modifying stack in way only this node know.
 * We may have as much Node implementations
 * as many types we have defined in our syntax.
 */
public interface Node {
    void act(Stack stack);
}
