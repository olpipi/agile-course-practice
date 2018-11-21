package ru.unn.agile.calculator.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.calculator.model.Calculator;
import ru.unn.agile.calculator.model.NumberSystem;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maria Pronina.
 */
public class ViewModelTests {
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
    public void canSetDefaultValues() {
        assertEquals(NumberSystem.BINARY, viewModel.getInputNumberSystem());
        assertEquals(NumberSystem.BINARY, viewModel.getOutputNumberSystem());
        assertEquals("", viewModel.getResult());
        assertEquals("", viewModel.getUserMessage());
        assertEquals(true, viewModel.isCalculationDisabled());
        assertEquals("", viewModel.number1Property().get());
        assertEquals("", viewModel.number2Property().get());
    }

    @Test
    public void testDefaultCalculate() {
        String a = "b11";
        String b = "b10";

        viewModel.number1Property().setValue(a);
        viewModel.number2Property().setValue(b);
        viewModel.calculate();

        String expectedResult = "Sum: a+b = " + Calculator.add(a,b, NumberSystem.BINARY) + "\n"
                + "Mult: a*b = " + Calculator.multiply(a,b, NumberSystem.BINARY) + "\n"
                + "Minus: -a = " + Calculator.unaryMinus(a, NumberSystem.BINARY)
                + ", -b = " + Calculator.unaryMinus(b, NumberSystem.BINARY) + "\n";

        assertEquals(expectedResult, viewModel.getResult());
    }
}
