package it.sevenbits.calculator.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack implements Stack {
    private List<Float> list = new ArrayList<>();

    @Override
    public float pop() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't pop element: empty stack");

        float last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return last;
    }

    @Override
    public void push(final float n) {
        list.add(n);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
