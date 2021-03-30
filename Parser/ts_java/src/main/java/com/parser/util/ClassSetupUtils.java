package com.parser.util;


import com.parser.listener.DescriptiveErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import com.parser.listener.TSCustomListener;
import com.parser.ts.tsLexer;
import com.parser.ts.tsParser;

public class ClassSetupUtils {

    public static TSCustomListener setupTsListener(String sample, boolean needDebugInfo) {
        CodePointCharStream input = CharStreams.fromString(sample);
        tsLexer lexer = new tsLexer(input);

        // https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4/18137301#18137301
        lexer.removeErrorListeners();
        lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        if (needDebugInfo) {
            tokens.fill();

            System.out.println("\n[TOKENS]");

            for (Token t : tokens.getTokens()) {

                String symbolicName = tsLexer.VOCABULARY.getSymbolicName(t.getType());
                String literalName = tsLexer.VOCABULARY.getLiteralName(t.getType());

                System.out.printf("  %-20s '%s'\n",
                        symbolicName == null ? literalName : symbolicName,
                        t.getText().replace("\r", "\r").replace("\n", "\n").replace("\t", "\t"));
            }

            System.out.println("\n[PARSE-TREE]");
        }

        tsParser parser = new tsParser(tokens);

        // https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4/18137301#18137301
        parser.removeErrorListeners();
        parser.addErrorListener(DescriptiveErrorListener.INSTANCE);

        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        TSCustomListener listener = new TSCustomListener();
        walker.walk(listener, tree);
        return  listener;
    }

    public static TSCustomListener setupTsListener(String sample) {
        return setupTsListener(sample, false);
    }
}

