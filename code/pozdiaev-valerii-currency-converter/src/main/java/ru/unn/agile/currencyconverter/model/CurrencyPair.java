package ru.unn.agile.currencyconverter.model;

import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

public class CurrencyPair {
    private String baseCurrency;
    private String quoteCurrency;
    private double rate;

    public CurrencyPair(final String baseCurrency, final String quoteCurrency, final double rate) {
        validateRate(rate);

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

    private void validateRate(double rate) {
        if (rate <= 0) {
            throw new CurrencyConverterException("Currency Rate should be positive");
        }
    }
}
