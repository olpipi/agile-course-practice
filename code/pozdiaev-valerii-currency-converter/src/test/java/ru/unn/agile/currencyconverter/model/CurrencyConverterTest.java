package ru.unn.agile.currencyconverter.model;

import org.junit.Test;
import ru.unn.agile.currencyconverter.model.errorhandling.CurrencyConverterException;

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
        currencyConverter.addCurrencyPair(RUB_CODE, USD_CODE, RUB_TO_USD_RATE);

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
        currencyConverter.addCurrencyPair(RUB_CODE, EURO_CODE, RUB_TO_EUR_RATE);

        // Act
        double euroAmount = currencyConverter.convert(RUB_CODE, EURO_CODE, rublesAmount);

        // Assert
        double expectedEuroAmount = 1.3;
        assertEquals(expectedEuroAmount, euroAmount, delta);
    }

    @Test
    public void canConvertByInversePair() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double euroAmount = 1.3;
        currencyConverter.addCurrencyPair(RUB_CODE, EURO_CODE, RUB_TO_EUR_RATE);

        // Act
        double rublesAmount = currencyConverter.convert(EURO_CODE, RUB_CODE, euroAmount);

        // Assert
        double expectedRublesAmount = 100;
        assertEquals(expectedRublesAmount, rublesAmount, delta);
    }

    @Test
    public void canUpdateExistedCurrencyPairInConverter() {
        // Arrange
        double rublesAmount = 100;
        double oldRubToUsdRate = 0.013;
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.addCurrencyPair(RUB_CODE, USD_CODE, oldRubToUsdRate);
        double newRubToUsdRate = 0.014;

        // Act
        currencyConverter.addCurrencyPair(RUB_CODE, USD_CODE, newRubToUsdRate);

        // Assert
        double dollarsAmount = currencyConverter.convert(RUB_CODE, USD_CODE, rublesAmount);
        double expectedDollarsAmount = 1.4;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }

    @Test
    public void canUpdateExistedCurrencyPairWithInversePair() {
        // Arrange
        double rublesAmount = 100;
        double oldRubToUsdRate = 0.013;
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.addCurrencyPair(RUB_CODE, USD_CODE, oldRubToUsdRate);
        double newRubToUsdRate = 0.014;

        // Act
        currencyConverter.addCurrencyPair(USD_CODE, RUB_CODE, newRubToUsdRate);

        // Assert
        double dollarsAmount = currencyConverter.convert(RUB_CODE, USD_CODE, rublesAmount);
        double expectedDollarsAmount = 1.4;
        assertEquals(expectedDollarsAmount, dollarsAmount, delta);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotConvertNegativeAmount() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.addCurrencyPair(RUB_CODE, USD_CODE, RUB_TO_USD_RATE);
        double negativeAmount = -100;

        // Act & Assert
        currencyConverter.convert(RUB_CODE, USD_CODE, negativeAmount);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotCovertWithoutCurrencyPair() {
        // Arrange
        CurrencyConverter currencyConverter = new CurrencyConverter();
        double rublesAmount = 1000;

        // Act & Assert
        currencyConverter.convert(RUB_CODE, USD_CODE, rublesAmount);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotCreatePairWithNegativeRate() {
        // Arrange
        double negativeRate = -20.2;
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act & Assert
        currencyConverter.addCurrencyPair(RUB_CODE, USD_CODE, negativeRate);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotCreatePairWithIncorrectCode() {
        // Arrange
        String incorrectCode = "asdadasd";
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act & Assert
        currencyConverter.addCurrencyPair(RUB_CODE, incorrectCode, RUB_TO_USD_RATE);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotCreatePairWithNullCode() {
        // Arrange
        String incorrectCode = null;
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act & Assert
        currencyConverter.addCurrencyPair(RUB_CODE, incorrectCode, RUB_TO_USD_RATE);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotConvertWithIncorrectCode() {
        // Arrange
        String incorrectCode = "asdadasd";
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act & Assert
        currencyConverter.convert(RUB_CODE, incorrectCode, RUB_TO_USD_RATE);
    }

    @Test(expected = CurrencyConverterException.class)
    public void cannotConvertWithNullCode() {
        // Arrange
        String incorrectCode = null;
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // Act & Assert
        currencyConverter.convert(RUB_CODE, incorrectCode, RUB_TO_USD_RATE);
    }
}
