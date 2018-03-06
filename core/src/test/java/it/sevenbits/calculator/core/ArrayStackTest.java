package it.sevenbits.calculator.core;

import it.sevenbits.calculator.core.stack.ArrayStack;
import it.sevenbits.calculator.core.stack.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {
    private final float epsilon = 0.0001f;

    @Test
    public void shouldPushElement() {
        Stack stack = new ArrayStack();
        assertTrue(stack.isEmpty());
        stack.push(1f);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void shouldBeFIFO() {
        Stack stack = new ArrayStack();
        stack.push(2f);
        stack.push(-1f);
        assertEquals(-1f, stack.pop(), epsilon);
        assertEquals(2f, stack.pop(), epsilon);
        assertTrue(stack.isEmpty());
    }
}
