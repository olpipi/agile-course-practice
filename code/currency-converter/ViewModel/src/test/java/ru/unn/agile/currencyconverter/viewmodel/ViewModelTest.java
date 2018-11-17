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
        setAddCurrencyInput(viewModel);
        viewModel.addCurrencyPair();

        assertEquals("RUB/USD\n", viewModel.getCurrPairsStr().get());
        assertEquals("", viewModel.getResultSrt().get());
    }

    @Test
    public void canAddMultipleCurrencyPairs() {
        setAddCurrencyInput(viewModel);
        viewModel.addCurrencyPair();

        viewModel.getAddSrcCodeStr().set("RUB");
        viewModel.getAddTgtCodeStr().set("EUR");
        viewModel.getAddRateStr().set("40");
        viewModel.addCurrencyPair();

        String[] pairs = viewModel.getCurrPairsStr().get().split("\\r?\\n");
        assertEquals(3, pairs.length);
        assertTrue(Arrays.asList(pairs).contains("RUB/USD"));
        assertTrue(Arrays.asList(pairs).contains("RUB/EUR"));
        assertEquals("", viewModel.getResultSrt().get());
    }

    @Test
    public void canPrintDoubleConverterError() {
        viewModel.getAddSrcCodeStr().set("RUB");
        viewModel.getAddTgtCodeStr().set("USD");
        viewModel.getAddRateStr().set("40.B");
        viewModel.addCurrencyPair();

        assertEquals("Не удалось распознать число: 40.B", viewModel.getResultSrt().get());
    }

    private void setAddCurrencyInput(ViewModel viewModel) {
        viewModel.getAddSrcCodeStr().set("RUB");
        viewModel.getAddTgtCodeStr().set("USD");
        viewModel.getAddRateStr().set("30");
    }
}
