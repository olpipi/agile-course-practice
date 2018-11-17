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
        assertEquals("", viewModel.getAddSrcCodeStr().get());
        assertEquals("", viewModel.getAddTgtCodeStr().get());
        assertEquals("", viewModel.getAddRateStr().get());
        assertEquals("", viewModel.getConvSrcCodeStr().get());
        assertEquals("", viewModel.getConvTgtCodeStr().get());
        assertEquals("", viewModel.getConvAmountStr().get());
        assertEquals("", viewModel.getCurrPairsStr().get());
        assertEquals("", viewModel.getResultSrt().get());
    }

    @Test
    public void canAddCurrencyPair() {
        setAddCurrencyInput("RUB", "USD", "30");
        viewModel.addCurrencyPair();

        assertEquals("RUB/USD\n", viewModel.getCurrPairsStr().get());
        assertEquals("", viewModel.getResultSrt().get());
    }

    @Test
    public void canAddMultipleCurrencyPairs() {
        setAddCurrencyInput("RUB", "USD", "30");
        viewModel.addCurrencyPair();

        setAddCurrencyInput("RUB", "EUR", "40");
        viewModel.addCurrencyPair();

        String[] pairs = viewModel.getCurrPairsStr().get().split("\\r?\\n");
        assertEquals(3, pairs.length);
        assertTrue(Arrays.asList(pairs).contains("RUB/USD"));
        assertTrue(Arrays.asList(pairs).contains("RUB/EUR"));
        assertEquals("", viewModel.getResultSrt().get());
    }

    @Test
    public void canPrintDoubleConverterError() {
        setAddCurrencyInput("RUB", "USB", "40.B");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: \"40.B\"", viewModel.getResultSrt().get());
    }

    @Test
    public void canPrintDoubleConverterErrorWithEmptyField() {
        setAddCurrencyInput("RUB", "USB", "");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: \"\"", viewModel.getResultSrt().get());
    }

    @Test
    public void canPrintWrongPairError() {
        setAddCurrencyInput("RB", "USB", "40");
        viewModel.addCurrencyPair();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultSrt().get());
    }

    @Test
    public void canPrintWrongPairErrorWithEmptyField() {
        setAddCurrencyInput("RUB", "", "40");
        viewModel.addCurrencyPair();

        assertEquals("Ошибка: Currency Codes don't meet the pattern", viewModel.getResultSrt().get());
    }

    private void setAddCurrencyInput(String srcCodeStr, String tgtCodeStr, String rateStr) {
        viewModel.getAddSrcCodeStr().set(srcCodeStr);
        viewModel.getAddTgtCodeStr().set(tgtCodeStr);
        viewModel.getAddRateStr().set(rateStr);
    }
}
