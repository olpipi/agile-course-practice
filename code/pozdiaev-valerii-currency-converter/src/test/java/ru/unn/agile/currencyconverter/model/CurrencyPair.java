package ru.unn.agile.currencyconverter.model;

public class CurrencyPair {
    private String baseCurrency;
    private String quoteCurrency;
    private double rate;

    public CurrencyPair(String baseCurrency, String quoteCurrency, double rate) {
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
}
