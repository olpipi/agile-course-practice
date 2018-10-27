package ru.unn.agile.stringcalculator.model.errorhandling;

public class StringCalculatorException extends RuntimeException {
    public StringCalculatorException(final String message) {
        super(message);
    }
}