package ru.unn.agile.polynomial.viewmodel;

import org.junit.Test;
import ru.unn.agile.polynomial.model.Polynomial;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    @Test
    public void createViewModelWithDefaultFields() {
        ViewModel viewModel = new ViewModel();
        assertEquals("", viewModel.firstPolynomialStrProperty().get());
        assertEquals("", viewModel.secondPolynomialStrProperty().get());
        assertEquals("", viewModel.resultStrProperty().get());
    }

    @Test
    public void canParsePolynomial() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial("2x^3+4x^2+5x-42");
        assertEquals("2x^3+4x^2+5x-42", polynomial.toString());
    }
}