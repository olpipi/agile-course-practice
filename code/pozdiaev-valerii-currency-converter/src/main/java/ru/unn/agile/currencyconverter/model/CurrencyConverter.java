package ru.unn.agile.currencyconverter.model;

public class CurrencyConverter {
    private static final double RUB_TO_USD_RATE = 0.015;
    private static final double RUB_TO_EUR_RATE = 0.013;

    public double convert(String sourceCurrencyCode, String targetCurrencyCode, double amount) {
        if (sourceCurrencyCode == "RUB" && targetCurrencyCode == "EUR") {
            return amount * RUB_TO_EUR_RATE;
        } else if (sourceCurrencyCode == "RUB" && targetCurrencyCode == "USD") {
            return amount * RUB_TO_USD_RATE;
        }
        return 0;
    }
}
