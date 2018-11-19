package ru.unn.agile.triangle.viewmodel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    @Test
    public void initViewModelWithDefaultFields() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getAStr().get());
        assertEquals("", viewModel.getBStr().get());
        assertEquals("", viewModel.getCStr().get());
        assertEquals("", viewModel.getResultSrt().get());
    }
}
