package it.sevenbits.calculator.loader;

import it.sevenbits.calculator.operations.Operation;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class DynamicGroovyOperationsLoaderTest {
    private final double epsilon = 0.0001;

    @Test
    public void ShouldLoadScripts() throws Exception {
        OperationsLoader loader = new DynamicGroovyOperationsLoader(new File("src/test/resources/groovy/"));
        List<Operation> ops = loader.load();
        Operation op = ops.stream().filter(it -> it.getSymbol().equals("*")).findFirst().get();

        Assert.assertNotNull(op);
        Assert.assertEquals(4, op.apply(2, 2), epsilon);
        Assert.assertEquals(-12, op.apply(6, -2), epsilon);
        Assert.assertEquals(2, op.getArity());
        Assert.assertEquals("*", op.getSymbol());
    }
}
