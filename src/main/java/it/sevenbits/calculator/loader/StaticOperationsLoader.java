package it.sevenbits.calculator.loader;

import it.sevenbits.calculator.operations.*;

import java.util.ArrayList;
import java.util.List;

public class StaticOperationsLoader implements OperationsLoader {
    @Override
    public List<Operation> load() {
        List<Operation> operations = new ArrayList<>();
        operations.add(new AdditionOperation());
        operations.add(new MultiplicationOperation());
        operations.add(new DivisionOperation());
        operations.add(new SubtractionOperation());
        return operations;
    }
}
