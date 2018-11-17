package ru.unn.agile.currencyconverter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void initViewModelWithDefaultFields() {
        assertEquals("", viewModel.getAddSrcCodeProp().get());
        assertEquals("", viewModel.getAddTgtCodeProp().get());
        assertEquals("", viewModel.getAddRateStrProp().get());
        assertEquals("", viewModel.getConvSrcCodeProp().get());
        assertEquals("", viewModel.getConvTgtCodeProp().get());
        assertEquals("", viewModel.getConvAmountProp().get());
        assertEquals("", viewModel.getCurrPairsStr());
        assertEquals("", viewModel.getResultStr());
    }

    @Test
    public void canAddCurrencyPair() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        assertEquals("USD/RUB\n", viewModel.getCurrPairsStr());
        assertEquals("", viewModel.getResultStr());
    }

    @Test
    public void canAddMultipleCurrencyPairs() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setAddCurrencyInput("EUR", "RUB", "40");
        viewModel.addCurrencyPair();

        String[] pairs = viewModel.getCurrPairsStr().split("\\r?\\n");
        assertEquals(3, pairs.length);
        assertTrue(Arrays.asList(pairs).contains("USD/RUB"));
        assertTrue(Arrays.asList(pairs).contains("EUR/RUB"));
        assertEquals("", viewModel.getResultStr());
    }

    @Test
    public void canPrintDoubleConverterErrorOnAdd() {
        setAddCurrencyInput("USD", "RUB", "40.B");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: \"40.B\"", viewModel.getResultStr());
    }

    @Test
    public void canPrintDoubleConverterErrorWithEmptyFieldOnAdd() {
        setAddCurrencyInput("USD", "RUB", "");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: \"\"", viewModel.getResultStr());
    }

    @Test
    public void canPrintWrongPairErrorOnAdd() {
        setAddCurrencyInput("USD", "RB", "40");
        viewModel.addCurrencyPair();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultStr());
    }

    @Test
    public void canPrintWrongPairErrorWithEmptyFieldOnAdd() {
        setAddCurrencyInput("", "RUB", "40");
        viewModel.addCurrencyPair();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultStr());
    }

    @Test
    public void canConvertExistingPair() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setConvertCurrencyInput("USD", "RUB", "2");
        viewModel.convertCurrency();

        assertEquals("2.0 USD = 60.0 RUB", viewModel.getResultStr());
    }

    @Test
    public void canConvertInverseExistingPair() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setConvertCurrencyInput("RUB", "USD", "180");
        viewModel.convertCurrency();

        assertEquals("180.0 RUB = 6.0 USD", viewModel.getResultStr());
    }

    @Test
    public void canPrintDoubleConverterErrorOnConvert() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setConvertCurrencyInput("RUB", "USD", "abc");
        viewModel.convertCurrency();

        assertEquals("Не удалось распознать число: \"abc\"", viewModel.getResultStr());
    }

    @Test
    public void canPrintDoubleConverterErrorWithEmptyFieldOnConvert() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setConvertCurrencyInput("RUB", "USD", "");
        viewModel.convertCurrency();

        assertEquals("Не удалось распознать число: \"\"", viewModel.getResultStr());
    }

    @Test
    public void canPrintWrongPairErrorOnConvert() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setConvertCurrencyInput("RUB", "UD", "2");
        viewModel.convertCurrency();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultStr());
    }

    @Test
    public void canPrintWrongPairErrorWithEmptyFieldOnConvert() {
        setAddCurrencyInput("USD", "RUB", "30");
        viewModel.addCurrencyPair();

        setConvertCurrencyInput("", "USD", "2");
        viewModel.convertCurrency();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultStr());
    }

    @Test
    public void canPrintNonExistentPairErrorOnConvert() {
        setConvertCurrencyInput("RUB", "USD", "2");
        viewModel.convertCurrency();

        assertEquals("Ошибка: Can't convert currency. Rate is not found", viewModel.getResultStr());
    }

    private void setAddCurrencyInput(String srcCodeStr, String tgtCodeStr, String rateStr) {
        viewModel.getAddSrcCodeProp().set(srcCodeStr);
        viewModel.getAddTgtCodeProp().set(tgtCodeStr);
        viewModel.getAddRateStrProp().set(rateStr);
    }

    private void setConvertCurrencyInput(String srcCodeStr, String tgtCodeStr, String amountStr) {
        viewModel.getConvSrcCodeProp().set(srcCodeStr);
        viewModel.getConvTgtCodeProp().set(tgtCodeStr);
        viewModel.getConvAmountProp().set(amountStr);
    }
}
