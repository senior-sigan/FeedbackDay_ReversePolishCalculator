package it.sevenbits.calculator.cli;

import it.sevenbits.calculator.core.Calc;
import it.sevenbits.calculator.core.loader.DynamicJsOperationsLoader;
import it.sevenbits.calculator.core.loader.OperationsLoader;
import it.sevenbits.calculator.core.operations.Operation;
import it.sevenbits.calculator.core.parser.Parser;
import it.sevenbits.calculator.core.parser.ParserException;
import it.sevenbits.calculator.core.parser.ParserImpl;
import it.sevenbits.calculator.core.stack.ArrayStack;
import it.sevenbits.calculator.core.tokenizer.SpaceTokenizer;
import it.sevenbits.calculator.core.tokenizer.Tokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String jsOperationsPath = args[0];
        Tokenizer tokenizer = new SpaceTokenizer();
        OperationsLoader loader = new DynamicJsOperationsLoader(jsOperationsPath);
        List<Operation> operations = loader.load();
        Parser parser = new ParserImpl(operations);
        Calc calc = new Calc(tokenizer, parser, ArrayStack::new);
        ExpressionsStream commandsStream = new DummyExpressionsStream();

        commandsStream.forEach(expr -> {
            try {
                Double result = calc.eval(expr);
                logger.info("Result: " + result);
            } catch (ParserException e) {
                logger.error("Can't eval expression '" + expr + "': " + e.getMessage(), e);
            }
        });
    }
}
