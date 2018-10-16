package ru.unn.agile.currencyconverter.model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    private List<CurrencyPair> currencyPairs;

    public CurrencyConverter() {
        this.currencyPairs = new ArrayList<>();
    }

    public double convert(final String sourceCode, final String targetCode, final double amount) {
        CurrencyPair currencyPair = getCurrencyPairByCodes(sourceCode, targetCode);

        if (currencyPair != null) {
            return amount * currencyPair.getRate();
        }

        CurrencyPair inverseCurrencyPair = getCurrencyPairByCodes(targetCode, sourceCode);

        if (inverseCurrencyPair != null) {
            return amount / inverseCurrencyPair.getRate();
        }

        return 0;
    }

    public void addCurrencyPair(final CurrencyPair currencyPair) {
        String sourceCode = currencyPair.getBaseCurrency();
        String targetCode = currencyPair.getQuoteCurrency();
        CurrencyPair existedCurrencyPair = findExistedPair(sourceCode, targetCode);

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

    private CurrencyPair findExistedPair(final String sourceCode, final String targetCode) {
        CurrencyPair foundPair = getCurrencyPairByCodes(sourceCode, targetCode);
        if (foundPair != null) {
            return foundPair;
        }

        CurrencyPair foundInversePair = getCurrencyPairByCodes(targetCode, sourceCode);
        if (foundInversePair != null) {
            return foundInversePair;
        }

        return null;
    }

    private CurrencyPair getCurrencyPairByCodes(final String sourceCode, final String targetCode) {
        return currencyPairs.stream()
                .filter(currencyPair -> currencyPair.getBaseCurrency().equals(sourceCode))
                .filter(currencyPair -> currencyPair.getQuoteCurrency().equals(targetCode))
                .findFirst().orElse(null);
    }
}
