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

        throw new CurrencyConverterException("Can't convert currency");
    }


    public void addCurrencyPair(final String srcCode, final String tgtCode, final double rate) {
        CurrencyPair existedCurrencyPair = getCurrencyPairByCodes(srcCode, tgtCode);
        if (existedCurrencyPair != null) {
            updatePair(srcCode, tgtCode, rate);
        }

        CurrencyPair existedInversePair = getCurrencyPairByCodes(tgtCode, srcCode);
        if (existedInversePair != null) {
            updatePair(tgtCode, srcCode, rate);
        }

        CurrencyPair newCurrencyPair = new CurrencyPair(srcCode, tgtCode, rate);
        this.currencyPairs.add(newCurrencyPair);
    }

    private void updatePair(final String sourceCode, final String targetCode, final double rate) {
        CurrencyPair foundPair = getCurrencyPairByCodes(sourceCode, targetCode);
        if (foundPair != null) {
            int existedCurrencyPairIndex = currencyPairs.indexOf(foundPair);
            CurrencyPair newCurrencyPair = new CurrencyPair(sourceCode, targetCode, rate);
            this.currencyPairs.set(existedCurrencyPairIndex, newCurrencyPair);
        }
    }

    private CurrencyPair getCurrencyPairByCodes(final String sourceCode, final String targetCode) {
        return currencyPairs.stream()
                .filter(currencyPair -> currencyPair.getBaseCurrency().equals(sourceCode))
                .filter(currencyPair -> currencyPair.getQuoteCurrency().equals(targetCode))
                .findFirst().orElse(null);
    }

    private void validateAmount(final double amount) {
        if (amount < 0) {
            throw new CurrencyConverterException("Can't covert negative number");
        }
    }

    class CurrencyPair {
        private String baseCurrency;
        private String quoteCurrency;
        private double rate;

        private static final String CURRENCY_CODE_PATTERN = "[A-Z]{3}";

        CurrencyPair(final String baseCurrency, final String quoteCurrency, final double rate) {
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
