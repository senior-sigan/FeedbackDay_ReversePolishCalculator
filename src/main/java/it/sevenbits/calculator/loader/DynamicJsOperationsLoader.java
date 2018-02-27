package it.sevenbits.calculator.loader;

import it.sevenbits.calculator.operations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DynamicJsOperationsLoader loads javascript files.
 * Js file should contains all the functions
 * we have in {@link Operation} interface.
 */
public class DynamicJsOperationsLoader implements OperationsLoader {
    private File root;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public DynamicJsOperationsLoader(String rootPath) {
        this.root = new File(rootPath);
    }

    @Override
    public List<Operation> load() {
        return Arrays.stream(Objects.requireNonNull(
                root.list((dir, name) -> name.endsWith(".js"))
        )).map(it -> {
            try {
                return loadOperationFrom(new File(root, it).getAbsolutePath());
            } catch (Exception e) {
                logger.error("Can't load operation", e);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private Operation loadOperationFrom(String path) throws FileNotFoundException, ScriptException {
        final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader(path));
        final Invocable invocable = (Invocable) engine;
        return new Operation() {
            @Override
            public String getSymbol() {
                try {
                    return (String) invocable.invokeFunction("getSymbol");
                } catch (Exception e) {
                    throw new RuntimeException("Can't invoke function 'getSymbol'", e);
                }
            }

            @Override
            public double apply(double... operands) {
                try {
                    Object[] operandsJs = Arrays.stream(operands).mapToObj(it -> (Object) it).toArray();
                    return (double) invocable.invokeFunction("apply", operandsJs);
                } catch (Exception e) {
                    throw new RuntimeException("Can't invoke function 'getSymbol'", e);
                }
            }

            @Override
            public int getArity() {
                try {
                    return (int) invocable.invokeFunction("getArity");
                } catch (Exception e) {
                    throw new RuntimeException("Can't invoke function 'getSymbol'", e);
                }
            }
        };
    }
}
