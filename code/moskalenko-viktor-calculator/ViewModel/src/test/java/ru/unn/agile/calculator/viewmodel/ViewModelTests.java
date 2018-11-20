package ru.unn.agile.calculator.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        assertEquals(NumberSystem.BINARY, viewModel.getNumberSystem());
        assertEquals("", viewModel.getResult());
        assertEquals("", viewModel.getUserMessage());
        assertEquals(true, viewModel.isCalculationDisabled());
        assertEquals("", viewModel.number1Property().get());
        assertEquals("", viewModel.number2Property().get());



    }
}
