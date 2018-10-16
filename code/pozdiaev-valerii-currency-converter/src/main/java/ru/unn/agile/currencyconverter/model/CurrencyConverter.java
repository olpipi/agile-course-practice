package ru.unn.agile.currencyconverter.model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    private List<CurrencyPair> currencyPairs;

    public CurrencyConverter() {
        this.currencyPairs = new ArrayList<>();
    }

    public double convert(final String sourceCurrencyCode, final String targetCurrencyCode,
                          final double amount) {
        CurrencyPair currencyPair = getCurrencyPairByCodes(sourceCurrencyCode, targetCurrencyCode);

        if (currencyPair != null) {
            return amount * currencyPair.getRate();
        }

        CurrencyPair inverseCurrencyPair = getCurrencyPairByCodes(targetCurrencyCode, sourceCurrencyCode);

        if (inverseCurrencyPair != null) {
            return amount / inverseCurrencyPair.getRate();
        }

        return 0;
    }

    public void addCurrencyPair(final CurrencyPair currencyPair) {
        CurrencyPair existedCurrencyPair = getCurrencyPairByCodes(currencyPair.getBaseCurrency(), currencyPair.getQuoteCurrency());

        if (existedCurrencyPair != null) {
            int existedCurrencyPairIndex = currencyPairs.indexOf(existedCurrencyPair);
            this.currencyPairs.set(existedCurrencyPairIndex, currencyPair);
            return;
        }

        this.currencyPairs.add(currencyPair);
    }

    public List<CurrencyPair> getCurrencyPairs() {
        return currencyPairs;
    }

    private CurrencyPair getCurrencyPairByCodes(final String sourceCode, final String targetCode) {
        return currencyPairs.stream()
                .filter(currencyPair -> currencyPair.getBaseCurrency().equals(sourceCode))
                .filter(currencyPair -> currencyPair.getQuoteCurrency().equals(targetCode))
                .findFirst().orElse(null);
    }
}
