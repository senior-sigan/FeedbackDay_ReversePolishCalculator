package it.sevenbits.calculator.core.loader;

import it.sevenbits.calculator.core.operations.Operation;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class DynamicJsOperationsLoaderTest {
    private final double epsilon = 0.0001;

    @Test
    public void ShouldLoadScripts() throws Exception {
        OperationsLoader loader = new DynamicJsOperationsLoader(new File("src/test/resources/js/").getAbsolutePath());
        List<Operation> ops = loader.load();
        Operation op = ops.stream().filter(it -> it.getSymbol().equals("+")).findFirst().get();

        Assert.assertNotNull(op);
        Assert.assertEquals(3, op.apply(1, 2), epsilon);
        Assert.assertEquals(-8, op.apply(6, -14), epsilon);
        Assert.assertEquals(2, op.getArity());
        Assert.assertEquals("+", op.getSymbol());
    }
}
