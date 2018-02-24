package it.sevenbits.calculator;

import it.sevenbits.calculator.parser.Parser;
import it.sevenbits.calculator.parser.SpaceParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SpaceParserTest {
    private final Parser parser = new SpaceParser();

    @Test
    public void shouldSplitBySpace() {
        List<String> tokens = parser.parse("1 2 3 + * ");
        assertArrayEquals(new String[]{"1", "2", "3", "+", "*"}, tokens.toArray());
    }

    @Test
    public void shouldReturnEmptyArrayWhenEmptyInput() {
        List<String> tokens = parser.parse("");
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayWhenNullInput() {
        List<String> tokens = parser.parse(null);
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayWhenBlankInput() {
        List<String> tokens = parser.parse("        ");
        assertTrue(tokens.isEmpty());
    }
}
