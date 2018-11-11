package ru.unn.agile.mathstatistics.viewmodel;

import ru.unn.agile.mathstatistics.model.MathStatistics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void isStatusWaitingAtTheBeginning() {
        assertEquals(Status.WAITING, viewModel.getStatusMessageText());
    }

    @Test
    public void isAddToSampleButtonEnabledAtTheBeginning() {
        assertTrue(viewModel.isAddToSampleButtonEnabled());
    }

    @Test
    public void isClearButtonDisabledAtTheBeginning() {
        assertFalse(viewModel.isClearButtonEnabled());
    }

    @Test
    public void isCalculateButtonDisabledAtTheBeginning() {
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void canSetExpectedValueOperation() {
        Operation expectedValueOperation = Operation.EXPECTED_VALUE;

        viewModel.setOperation(expectedValueOperation);

        assertEquals(expectedValueOperation, viewModel.getOperation());
    }

    @Test
    public void canSetDispersionOperation() {
        Operation dispersionOperation = Operation.DISPERSION;

        viewModel.setOperation(dispersionOperation);

        assertEquals(dispersionOperation, viewModel.getOperation());
    }

    @Test
    public void canSetInitialMomentOperation() {
        Operation initialMomentOperation = Operation.INITIAL_MOMENT;

        viewModel.setOperation(initialMomentOperation);

        assertEquals(initialMomentOperation, viewModel.getOperation());
    }

    @Test
    public void canSetCentralMomentOperation() {
        Operation centralMomentOperation = Operation.CENTRAL_MOMENT;

        viewModel.setOperation(centralMomentOperation);

        assertEquals(centralMomentOperation, viewModel.getOperation());
    }
}
