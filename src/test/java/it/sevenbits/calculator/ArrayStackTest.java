package it.sevenbits.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {
    private float epsilon = 0.0000001f;

    @Test
    public void shouldPush() throws StackException {
        Stack stack = new ArrayStack();
        assertTrue(stack.isEmpty());
        stack.push(42f);
        assertFalse(stack.isEmpty());
        assertEquals(42f, stack.pop(), epsilon);
    }

    @Test
    public void shouldBeFILO() throws StackException {
        Stack stack = new ArrayStack();
        stack.push(42f);
        stack.push(13f);
        assertEquals(13f, stack.pop(), epsilon);
        assertEquals(42f, stack.pop(), epsilon);
        assertTrue(stack.isEmpty());
    }

    @Test(expected = StackException.class)
    public void shouldThrowError() throws StackException {
        Stack stack = new ArrayStack();
        assertTrue(stack.isEmpty());
        stack.pop();
    }
}