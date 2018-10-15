package ru.unn.agile.currencyconverter.model;

public class CurrencyConverter {
    private static final double RUB_TO_USD_RATE = 0.015;
    private static final double RUB_TO_EUR_RATE = 0.013;

    private static final String RUB_CODE = "RUB";
    private static final String USD_CODE = "USD";
    private static final String EURO_CODE = "EUR";

    private CurrencyPair currencyPair;

    public double convert(final String sourceCurrencyCode, final String targetCurrencyCode,
                          final double amount) {
        if (RUB_CODE.equals(sourceCurrencyCode) && EURO_CODE.equals(targetCurrencyCode)) {
            return amount * RUB_TO_EUR_RATE;
        } else if (RUB_CODE.equals(sourceCurrencyCode) && USD_CODE.equals(targetCurrencyCode)) {
            return amount * RUB_TO_USD_RATE;
        }
        return 0;
    }

    public void addCurrencyPair(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public Object getCurrencyPair() {
        return currencyPair;
    }
}
