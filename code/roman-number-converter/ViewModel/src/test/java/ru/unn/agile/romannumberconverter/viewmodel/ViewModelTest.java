package ru.unn.agile.romannumberconverter.viewmodel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    @Test
    public void initViewModelWithDefaultValues() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getArabicValueStr());
        assertEquals("", viewModel.getRomanValueStr());
    }
}
