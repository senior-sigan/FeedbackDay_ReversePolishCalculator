package it.sevenbits.calculator.core.loader;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import it.sevenbits.calculator.core.operations.Operation;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DynamicGroovyOperationsLoader loads groovy files.
 * Groovy file should contains all the functions
 * we have in {@link Operation} interface and return `this`.
 */
public class DynamicGroovyOperationsLoader implements OperationsLoader {
    private File root;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public DynamicGroovyOperationsLoader(File root) {
        this.root = root;
    }

    @Override
    public List<Operation> load() {
        return Arrays.stream(Objects.requireNonNull(
                root.list((dir, name) -> name.endsWith(".groovy"))
        )).map(it -> {
            try {
                return loadOperationFrom(new File(root, it));
            } catch (Exception e) {
                logger.error("Can't load operation", e);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private Operation loadOperationFrom(File file) throws Exception {
        GroovyClassLoader classLoader = new GroovyClassLoader(getClass().getClassLoader());
        GroovyShell shell = new GroovyShell();
        Script script = (Script) shell.evaluate(file);
        return (Operation) Proxy.newProxyInstance(classLoader, new Class[]{Operation.class},
                (proxy, method, args) -> script.invokeMethod(method.getName(), args));
    }
}
