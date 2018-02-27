package it.sevenbits.calculator;

import it.sevenbits.calculator.loader.StaticOperationsLoader;
import it.sevenbits.calculator.parser.ParserImpl;
import it.sevenbits.calculator.stack.ArrayStack;
import it.sevenbits.calculator.tokenizer.SpaceTokenizer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {
    private Calc calc = new Calc(
            new SpaceTokenizer(),
            new ParserImpl(new StaticOperationsLoader().load()),
            ArrayStack::new);
    private double epsilon = 0.0001;

    @Test
    public void empty() throws Exception {
        assertEquals(0.0, calc.eval(""), epsilon);
        assertEquals(0.0, calc.eval(null), epsilon);
    }

    @Test
    public void noOp() throws Exception {
        assertEquals(3.0, calc.eval("1 2 3"), epsilon);
        assertEquals(-1.0, calc.eval("-1"), epsilon);
        assertEquals(-0.54, calc.eval("0 1 -0.54"), epsilon);
    }

    @Test
    public void addition() throws Exception {
        assertEquals(5.0, calc.eval("2 3 +"), epsilon);
        assertEquals(-1.0, calc.eval("-2 1 +"), epsilon);
        assertEquals(0.0, calc.eval("-1.5 1.5 +"), epsilon);
    }

    @Test
    public void subtraction() throws Exception {
        assertEquals(1.0, calc.eval("3 2 -"), epsilon);
        assertEquals(-1.0, calc.eval("-2 -1 -"), epsilon);
        assertEquals(-0.1, calc.eval("0 0.1 -"), epsilon);
    }

    @Test
    public void multiplication() throws Exception {
        assertEquals(0.0, calc.eval("0 100 *"), epsilon);
        assertEquals(6.0, calc.eval("-2 -3 *"), epsilon);
        assertEquals(1.1, calc.eval("0.1 11 *"), epsilon);
    }

    @Test
    public void division() throws Exception {
        assertEquals(0f, calc.eval("0 100 /"), epsilon);
        assertEquals(2.5f, calc.eval("5 2 /"), epsilon);
        assertEquals(-17, calc.eval("34 -2 /"), epsilon);
    }

    @Test
    public void combination() throws Exception {
        assertEquals(14f, calc.eval("5 1 2 + 4 * + 3 -"), epsilon);
        assertEquals(5f, calc.eval("15 7 1 1 + - / 3 * 2 1 1 + + -"), epsilon);
    }
}
