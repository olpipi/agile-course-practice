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
        Polynomial polynomial = viewModel.parsePolynomial("2.0x^3+4.0x^2+5.0x-42.0");
        assertEquals("2.0x^3 + 4.0x^2 + 5.0x - 42.0", polynomial.toString());
    }

    @Test
    public void canParsePolynomialWithZero() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial("2.0x^3+5.0x-42.0");
        assertEquals("2.0x^3 + 5.0x - 42.0", polynomial.toString());
    }

    @Test
    public void canParsePolynomialForZeroCoefficient() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial("1.0x^3-2.0x^2+3.0x");
        assertEquals("1.0x^3 - 2.0x^2 + 3.0x", polynomial.toString());
    }

    @Test
    public void canParseNumberWithZeroPolynomial() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial("3.0");
        assertEquals("3.0", polynomial.toString());
    }

    @Test
    public void canParseZeroPolynomial() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial("");
        assertEquals(null, polynomial);
    }

}
