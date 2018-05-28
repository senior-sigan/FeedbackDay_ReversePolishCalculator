package it.sevenbits.calculator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SpaceTokenizerTest {
    private Tokenizer tokenizer = new SpaceTokenizer();

    @Test
    public void shouldSplitStringBySpace() {
        List<String> tokens = tokenizer.tokenize("  1 2 3 + * ");
        assertArrayEquals(new String[]{"1", "2", "3", "+", "*"}, tokens.toArray());
    }

    @Test
    public void shouldReturnEmptyArrayWhenEmptyInput() {
        List<String> tokens = tokenizer.tokenize("");
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayWhenBlankInput() {
        List<String> tokens = tokenizer.tokenize("    ");
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayWhenNullInput() {
        List<String> tokens = tokenizer.tokenize(null);
        assertTrue(tokens.isEmpty());
    }
}