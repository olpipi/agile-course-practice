package ru.unn.agile.currencyconverter.model;

import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    private List<CurrencyPair> currencyPairs;

    public CurrencyConverter() {
        this.currencyPairs = new ArrayList<>();
    }

    public double convert(final String sourceCode, final String targetCode, final double amount) {
        validateAmount(amount);

        CurrencyPair currencyPair = getCurrencyPairByCodes(sourceCode, targetCode);

        if (currencyPair != null) {
            return amount * currencyPair.getRate();
        }

        CurrencyPair inverseCurrencyPair = getCurrencyPairByCodes(targetCode, sourceCode);

        if (inverseCurrencyPair != null) {
            return amount / inverseCurrencyPair.getRate();
        }

        throw new CurrencyConverterException("Currency rate is not found");
    }


    public void addCurrencyPair(final String sourceCode, final String targetCode, final double rate) {
        CurrencyPair existedCurrencyPair = getCurrencyPairByCodes(sourceCode, targetCode);
        CurrencyPair newCurrencyPair = new CurrencyPair(sourceCode, targetCode, rate);

        if (existedCurrencyPair != null) {
            int existedCurrencyPairIndex = currencyPairs.indexOf(existedCurrencyPair);
            this.currencyPairs.set(existedCurrencyPairIndex, newCurrencyPair);
            return;
        }

        existedCurrencyPair = getCurrencyPairByCodes(targetCode, sourceCode);

        if (existedCurrencyPair != null) {
            int existedCurrencyPairIndex = currencyPairs.indexOf(existedCurrencyPair);
            CurrencyPair newInverseCurrencyPair = new CurrencyPair(targetCode, sourceCode, rate);
            this.currencyPairs.set(existedCurrencyPairIndex, newInverseCurrencyPair);
            return;
        }

        this.currencyPairs.add(newCurrencyPair);
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

    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new CurrencyConverterException("Can't covert negative number");
        }
    }

    class CurrencyPair {
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
            if (baseCurrency == null
                    || quoteCurrency == null) {
                throw new CurrencyConverterException("Currency Codes can't be null");
            }

            if (!baseCurrency.matches(CURRENCY_CODE_PATTERN)
                    || !quoteCurrency.matches(CURRENCY_CODE_PATTERN)) {
                throw new CurrencyConverterException("Currency Codes don't meet the pattern");
            }
        }
    }
}
