package it.sevenbits.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack implements Stack {
    private List<Float> container = new ArrayList<>();

    @Override
    public void push(final float value) {
        container.add(value);
    }

    @Override
    public float pop() throws StackException {
        if (isEmpty()) throw new StackException("Can't pop from empty stack");

        float last = container.get(container.size() - 1);
        container.remove(container.size() - 1);
        return last;
    }

    @Override
    public boolean isEmpty() {
        return container.isEmpty();
    }
}
