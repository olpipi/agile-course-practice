package ru.unn.agile.currencyconverter.viewmodel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    @Test
    public void initViewModelWithDefaultFields() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getAddSrcCodeStr().get());
        assertEquals("", viewModel.getAddTgtCodeStr().get());
        assertEquals("", viewModel.getAddRateStr().get());
        assertEquals("", viewModel.getConvSrcCodeStr().get());
        assertEquals("", viewModel.getConvTgtCodeStr().get());
        assertEquals("", viewModel.getConvAmountStr().get());
        assertEquals("", viewModel.getCurrPairsSrt().get());
        assertEquals("", viewModel.getResultSrt().get());
    }
}
