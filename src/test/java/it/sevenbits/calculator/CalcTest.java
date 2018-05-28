package it.sevenbits.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {
    private Calc calc = new Calc(new SpaceTokenizer());
    private float epsilon = 0.0001f;

    @Test
    public void empty() throws CalcException {
        assertEquals(0f, calc.eval(""), epsilon);
        assertEquals(0f, calc.eval(null), epsilon);
    }

    @Test
    public void noOp() throws CalcException {
        assertEquals(3f, calc.eval("1 2 3"), epsilon);
        assertEquals(-1f, calc.eval("-1"), epsilon);
        assertEquals(-0.54f, calc.eval("0 1 -0.54"), epsilon);
    }

    @Test
    public void addition() throws CalcException {
        assertEquals(5f, calc.eval("2 3 +"), epsilon);
        assertEquals(-1f, calc.eval("-2 1 +"), epsilon);
        assertEquals(0, calc.eval("-1.5 1.5 +"), epsilon);
    }

    @Test
    public void subtraction() throws CalcException {
        assertEquals(1f, calc.eval("3 2 -"), epsilon);
        assertEquals(-1f, calc.eval("-2 -1 -"), epsilon);
        assertEquals(-0.1, calc.eval("0 0.1 -"), epsilon);
    }

    @Test
    public void multiplication() throws CalcException {
        assertEquals(0f, calc.eval("0 100 *"), epsilon);
        assertEquals(6f, calc.eval("-2 -3 *"), epsilon);
        assertEquals(1.1, calc.eval("0.1 11 *"), epsilon);
    }

    @Test
    public void division() throws CalcException {
        assertEquals(0f, calc.eval("0 100 /"), epsilon);
        assertEquals(2.5f, calc.eval("5 2 /"), epsilon);
        assertEquals(-17, calc.eval("34 -2 /"), epsilon);
    }

    @Test
    public void combination() throws CalcException {
        assertEquals(14f, calc.eval("5 1 2 + 4 * + 3 -"), epsilon);
        assertEquals(5f, calc.eval("15 7 1 1 + - / 3 * 2 1 1 + + -"), epsilon);
    }

    @Test(expected = CalcException.class)
    public void shouldThrowExceptionWhenUnknownOperation() throws CalcException {
        calc.eval("1 2 3 ???");
    }
}
