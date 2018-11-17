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
        setAddCurrencyInput("RUB", "USD", "30");
        viewModel.addCurrencyPair();

        assertEquals("RUB/USD\n", viewModel.getCurrPairsStr());
        assertEquals("", viewModel.getResultStr());
    }

    @Test
    public void canAddMultipleCurrencyPairs() {
        setAddCurrencyInput("RUB", "USD", "30");
        viewModel.addCurrencyPair();

        setAddCurrencyInput("RUB", "EUR", "40");
        viewModel.addCurrencyPair();

        String[] pairs = viewModel.getCurrPairsStr().split("\\r?\\n");
        assertEquals(3, pairs.length);
        assertTrue(Arrays.asList(pairs).contains("RUB/USD"));
        assertTrue(Arrays.asList(pairs).contains("RUB/EUR"));
        assertEquals("", viewModel.getResultStr());
    }

    @Test
    public void canPrintDoubleConverterError() {
        setAddCurrencyInput("RUB", "USB", "40.B");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: \"40.B\"", viewModel.getResultStr());
    }

    @Test
    public void canPrintDoubleConverterErrorWithEmptyField() {
        setAddCurrencyInput("RUB", "USB", "");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: \"\"", viewModel.getResultStr());
    }

    @Test
    public void canPrintWrongPairError() {
        setAddCurrencyInput("RB", "USB", "40");
        viewModel.addCurrencyPair();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultStr());
    }

    @Test
    public void canPrintWrongPairErrorWithEmptyField() {
        setAddCurrencyInput("RUB", "", "40");
        viewModel.addCurrencyPair();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultStr());
    }

    private void setAddCurrencyInput(String srcCodeStr, String tgtCodeStr, String rateStr) {
        viewModel.getAddSrcCodeProp().set(srcCodeStr);
        viewModel.getAddTgtCodeProp().set(tgtCodeStr);
        viewModel.getAddRateStrProp().set(rateStr);
    }
}
