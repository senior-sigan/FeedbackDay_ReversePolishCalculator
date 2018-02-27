package it.sevenbits.calculator;

import it.sevenbits.calculator.tokenizer.Tokenizer;
import it.sevenbits.calculator.tokenizer.SpaceTokenizer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTokenizerTest {
    private final Tokenizer tokenizer = new SpaceTokenizer();

    @Test
    public void shouldSplitBySpace() {
        List<String> tokens = tokenizer.tokenize("1 2 3 + * ");
        assertArrayEquals(new String[]{"1", "2", "3", "+", "*"}, tokens.toArray());
    }

    @Test
    public void shouldReturnEmptyArrayWhenEmptyInput() {
        List<String> tokens = tokenizer.tokenize("");
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayWhenNullInput() {
        List<String> tokens = tokenizer.tokenize(null);
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayWhenBlankInput() {
        List<String> tokens = tokenizer.tokenize("        ");
        assertTrue(tokens.isEmpty());
    }
}
