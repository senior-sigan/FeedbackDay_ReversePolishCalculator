package it.sevenbits.calculator.core.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack implements Stack {
    private List<Double> list = new ArrayList<>();

    @Override
    public double pop() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't pop element: empty stack");

        Double last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return last;
    }

    @Override
    public void push(final double n) {
        list.add(n);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
