package ru.unn.agile.currencyconverter.model;

import org.junit.Test;
import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CurrencyConverterTest {
    private final double delta = 0.001;

    private static final String RUB_CODE = "RUB";
    private static final String USD_CODE = "USD";
    private static final String EURO_CODE = "EUR";

    private static final double RUB_TO_USD_RATE = 0.015;
    private static final double RUB_TO_EUR_RATE = 0.013;

    @Test
    public void canConvertRubToUsd() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 100;
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, USD_CODE, RUB_TO_USD_RATE));

        // Act
        double dollarsAmount = currencyConverter.convert(RUB_CODE, USD_CODE, rublesAmount);

        // Assert
        double expectedDollarsAmount = 1.5;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }

    @Test
    public void canConvertRubToEuro() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 100;
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, EURO_CODE, RUB_TO_EUR_RATE));

        // Act
        double euroAmount = currencyConverter.convert(RUB_CODE, EURO_CODE, rublesAmount);

        // Assert
        double expectedEuroAmount = 1.3;
        assertEquals(expectedEuroAmount, euroAmount, delta);
    }

    @Test
    public void canCreateCurrencyPair() {
        // Arrange
        double rubToUsdRate = 0.013;

        // Act
        CurrencyPair currencyPair = new CurrencyPair(RUB_CODE, USD_CODE, rubToUsdRate);

        // Assert
        assertEquals(rubToUsdRate, currencyPair.getRate(), delta);
    }

    @Test
    public void canAddCurrencyPairToConverter() {
        // Arrange
        double rubToUsdRate = 0.013;
        CurrencyPair currencyPair = new CurrencyPair(RUB_CODE, USD_CODE, rubToUsdRate);
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act
        currencyConverter.addCurrencyPair(currencyPair);

        // Assert
        List<CurrencyPair> currencyPairs = currencyConverter.getCurrencyPairs();
        int expectedSize = 1;
        assertEquals(expectedSize, currencyPairs.size());
    }

    @Test
    public void canConvertByInversePair() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double euroAmount = 1.3;
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, EURO_CODE, RUB_TO_EUR_RATE));

        // Act
        double rublesAmount = currencyConverter.convert(EURO_CODE, RUB_CODE, euroAmount);

        // Assert
        double expectedRublesAmount = 100;
        assertEquals(expectedRublesAmount, rublesAmount, delta);
    }

    @Test
    public void canUpdateExistedCurrencyPairInConverter() {
        // Arrange
        double oldRubToUsdRate = 0.013;
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, USD_CODE, oldRubToUsdRate));
        double newRubToUsdRate = 0.014;

        // Act
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, USD_CODE, newRubToUsdRate));

        // Assert
        List<CurrencyPair> currencyPairs = currencyConverter.getCurrencyPairs();
        int expectedSize = 1;
        assertEquals(expectedSize, currencyPairs.size());
    }

    @Test
    public void canUpdateExistedCurrencyPairWithInversePair() {
        // Arrange
        double oldRubToUsdRate = 0.013;
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, USD_CODE, oldRubToUsdRate));
        double newRubToUsdRate = 0.014;

        // Act
        currencyConverter.addCurrencyPair(new CurrencyPair(USD_CODE, RUB_CODE, newRubToUsdRate));

        // Assert
        List<CurrencyPair> currencyPairs = currencyConverter.getCurrencyPairs();
        int expectedSize = 1;
        assertEquals(expectedSize, currencyPairs.size());
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotConvertNegativeAmount() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, USD_CODE, RUB_TO_USD_RATE));
        double negativeAmount = -100;

        // Act & Assert
        currencyConverter.convert(RUB_CODE, USD_CODE, negativeAmount);
    }

    @Test
    public void canCovertZeroAmount() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 0;
        currencyConverter.addCurrencyPair(new CurrencyPair(RUB_CODE, USD_CODE, RUB_TO_USD_RATE));

        // Act
        double dollarsAmount = currencyConverter.convert(RUB_CODE, USD_CODE, rublesAmount);

        // Assert
        double expectedDollarsAmount = 0;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }
}
