package ru.unn.agile.currencyconverter.model.errorhandling;

public class CurrencyConverterException extends RuntimeException {
    public CurrencyConverterException(String message) {
        super(message);
    }
}
