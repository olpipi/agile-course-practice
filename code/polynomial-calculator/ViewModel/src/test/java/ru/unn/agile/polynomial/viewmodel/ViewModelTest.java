package ru.unn.agile.polynomial.viewmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    @Test
    public void createViewModelWithDefaultFields() {
        ViewModel viewModel = new ViewModel();
        assertEquals("", viewModel.getFirstPolynomialStr().get());
        assertEquals("", viewModel.getSecondPolynomialStr().get());
        assertEquals("", viewModel.getResultSrt().get());
    }
}