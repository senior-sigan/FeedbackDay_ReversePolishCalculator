package it.sevenbits.calculator;

import it.sevenbits.calculator.operations.Operation;

import java.util.List;

public interface OperationsLoader {
    List<Operation> load();
}
