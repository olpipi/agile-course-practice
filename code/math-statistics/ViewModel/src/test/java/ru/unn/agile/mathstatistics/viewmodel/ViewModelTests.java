package ru.unn.agile.mathstatistics.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import ru.unn.agile.mathstatistics.viewmodel.ViewModel.Operation;
import ru.unn.agile.mathstatistics.viewmodel.ViewModel.Status;

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
        assertEquals("", viewModel.getValueText());
        assertEquals("", viewModel.getProbabilityText());
        assertEquals(Operation.EXPECTED_VALUE, viewModel.getOperation());
        assertEquals("", viewModel.getOrderText());
        assertEquals("", viewModel.getResultText());
        assertEquals(Status.WAITING, viewModel.getStatusMessageText());
    }
}
