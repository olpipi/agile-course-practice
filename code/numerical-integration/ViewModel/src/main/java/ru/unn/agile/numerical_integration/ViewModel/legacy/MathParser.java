package ru.unn.agile.numerical_integration.ViewModel.legacy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathParser {
    private static final String VARIABLE_NAME = "x";

    private String expression;
    private String error;
    private double result;
    private ScriptEngine engine;

    public MathParser(final String expression) {
        this.expression = expression;
        checkExpression();
        if (hasError()) {
            return;
        }
        prepareExpression();

        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
    }

    public boolean eval(final double variable) {
        if (hasError()) {
            return false;
        }

        try {
            engine.put(VARIABLE_NAME, variable);
            result = (double) engine.eval(expression);
        } catch (ScriptException e) {
            error = "Failed to compute expression";
        }

        return !hasError();
    }

    public String getError() {
        return error;
    }

    public double getResult() {
        return result;
    }

    private boolean hasError() {
        return !error.isEmpty();
    }

    private void checkExpression() {
        error = "";

        if (!expression.matches("[\\s\\d" + VARIABLE_NAME + "+\\-*/.()]*")) {
            error = "Unexpected symbols in expression";
        }
    }

    private void prepareExpression() {
        // Remove all whitespaces to check if the expression is empty
        expression = expression.replace(" ", "");
        if (expression.isEmpty()) {
            // Insert 0.0 empty expr to eval to 0
            expression = "0.0";
        } else {
            // Insert 0.0 to non empty expr to cast the result to double
            expression = "0.0+" + expression;
        }
    }
}
