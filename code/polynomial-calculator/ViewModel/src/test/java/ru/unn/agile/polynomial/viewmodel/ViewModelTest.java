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

    @Test
    public void canAddPolynomial() {
        ViewModel viewModel = new ViewModel();
        final String resultPolynomialStr
                = viewModel.add("1.0x^3-2.0x^2+3.0x-4.0", "-1.0x^3-2.0x^2+3.0x-4.0");
        assertEquals("-4.0x^2 + 6.0x - 8.0", resultPolynomialStr);
    }

    @Test
    public void canMultiplyByNumber() {
        ViewModel viewModel = new ViewModel();
        final String resultPolynomialStr
                = viewModel.multiply("1.0x^3-2.0x^2+3.0x-4.0", "5.0");
        assertEquals("5.0x^3 - 10.0x^2 + 15.0x - 20.0", resultPolynomialStr);
    }

    @Test
    public void canSubtractPolynomial() {
        ViewModel viewModel = new ViewModel();
        final String resultPolynomialStr
                = viewModel.subtract("1.0x^2+2.0x+4.0", "1.0x^2-2.0x+3.0");
        assertEquals("4.0x + 1.0", resultPolynomialStr);
    }

    //For parser2
    @Test
    public void canParseFirstDegreeWithoutFreeCoeff() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial2("1.0x");
        assertEquals("1.0x", polynomial.toString());
    }

    @Test
    public void canParseFirstDegreeWithFreeCoeffPlus() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial2("1.0x+1.0");
        assertEquals("1.0x + 1.0", polynomial.toString());
    }

    @Test
    public void canParseFirstDegreeWithFreeCoeffMinus() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial2("1.0x-1.0");
        assertEquals("1.0x - 1.0", polynomial.toString());
    }

    @Test
    public void canParseSecondDegreeWithoutFreeCoeff() {
        ViewModel viewModel = new ViewModel();
        Polynomial polynomial = viewModel.parsePolynomial2("1.0x^2");
        assertEquals("1.0x^2", polynomial.toString());
    }
}
