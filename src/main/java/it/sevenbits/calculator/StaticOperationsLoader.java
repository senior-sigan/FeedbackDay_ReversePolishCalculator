package it.sevenbits.calculator;

import it.sevenbits.calculator.operations.AddOperation;
import it.sevenbits.calculator.operations.DivOperation;
import it.sevenbits.calculator.operations.MulOperation;
import it.sevenbits.calculator.operations.SubOperation;

import java.util.Arrays;
import java.util.List;

public class StaticOperationsLoader implements OperationsLoader {
    @Override
    public List<Operation> load() {
        return Arrays.asList(
                new AddOperation(),
                new SubOperation(),
                new DivOperation(),
                new MulOperation()
        );
    }
}
