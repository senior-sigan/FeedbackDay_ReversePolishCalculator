package it.sevenbits.calculator.tokenizer;

import it.sevenbits.calculator.tokens.FloatToken;
import it.sevenbits.calculator.tokens.OperationToken;
import it.sevenbits.calculator.tokens.Token;
import it.sevenbits.calculator.operations.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenizerImpl implements Tokenizer {
    private final Map<String, Operation> operations;

    public TokenizerImpl(final List<Operation> operations) {
        this.operations = new HashMap<>();
        operations.forEach(operation ->
                this.operations.put(operation.getSymbol(), operation));
    }

    @Override
    public List<Token> tokenize(List<String> atoms) throws TokenizerException {
        List<Token> tokens = new ArrayList<>();
        for (String atom : atoms) {
            if (isNumber(atom)) {
                tokens.add(new FloatToken(Float.parseFloat(atom)));
            } else if (operations.containsKey(atom)) {
                tokens.add(new OperationToken(operations.get(atom)));
            } else {
                throw new TokenizerException(String.format("Atom %s is not supported", atom));
            }
        }

        return tokens;
    }

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
