package cz.java_webapp.godfather_quotes;

import org.springframework.core.io.*;

public class Statement {

    private int id;
    private String quote;
    private Boolean trueOrFalse;

    private TypeOfStatement type;

    ////////////////////////////////////////////////////////////

    public static enum TypeOfStatement {
        TRUE_STATEMENT, FALSE_STATEMENT
    }

    ////////////////////////////////////////////////////////////

    public TypeOfStatement getType() {
        return type;
    }

    public String getQuote() {
        return quote;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public int getId() {
        return id;
    }

    ////////////////////////////////////////////////////

    public Statement(int id, String quote, Boolean trueOrFalse) {

        this.id = id;
        this.quote = quote;

        if (trueOrFalse.equals(false)) {
            this.type = TypeOfStatement.FALSE_STATEMENT;
        } else if (trueOrFalse.equals(true)) {
            this.type = TypeOfStatement.TRUE_STATEMENT;
        } else {
            throw new IllegalStateException("Illegal name of file");
        }

    }

    @Override
    public String toString() {
        return quote;
    }

}
