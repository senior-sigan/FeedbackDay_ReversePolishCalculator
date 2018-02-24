package it.sevenbits.calculator.tokens;

import it.sevenbits.calculator.stack.Stack;

public interface Token {
    void act(Stack stack);
}
