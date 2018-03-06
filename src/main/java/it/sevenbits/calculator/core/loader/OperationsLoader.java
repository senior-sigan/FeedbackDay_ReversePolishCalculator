package it.sevenbits.calculator.core.loader;

import it.sevenbits.calculator.core.operations.Operation;

import java.util.List;

/**
 * OperationsLoader is responsible for loading operations from somewhere and somehow.
 * Implementations may support dynamic loading, static and etc.
 */
public interface OperationsLoader {
    List<Operation> load();
}
