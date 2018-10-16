package ru.unn.agile.currencyconverter.model;

import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

public class CurrencyPair {
    private String baseCurrency;
    private String quoteCurrency;
    private double rate;

    private static final String CURRENCY_CODE_PATTERN = "[A-Z]{3}";

    public CurrencyPair(final String baseCurrency, final String quoteCurrency, final double rate) {
        validateRate(rate);
        validateCodes(baseCurrency, quoteCurrency);

        this.baseCurrency = baseCurrency;
        this.quoteCurrency = quoteCurrency;
        this.rate = rate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public double getRate() {
        return rate;
    }

    private void validateRate(final double rate) {
        if (rate <= 0) {
            throw new CurrencyConverterException("Currency Rate should be positive");
        }
    }

    private void validateCodes(final String baseCurrency, final String quoteCurrency) {
        if (!baseCurrency.matches(CURRENCY_CODE_PATTERN)
                || !quoteCurrency.matches(CURRENCY_CODE_PATTERN)) {
            throw new CurrencyConverterException("Currency Codes don't meet the pattern");
        }
    }
}
