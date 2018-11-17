package ru.unn.agile.mathstatistics.viewmodel;

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
        assertEquals("", viewModel.getOffsetText());
        assertEquals("", viewModel.getResultText());
        assertEquals(Status.WAITING, viewModel.getStatusMessageText());
    }

    @Test
    public void isStatusWaitingAtTheBeginning() {
        assertEquals(Status.WAITING, viewModel.getStatusMessageText());
    }

    @Test
    public void isAddToDistributionButtonEnabledAtTheBeginning() {
        assertTrue(viewModel.isAddToDistributionButtonEnabled());
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

    @Test
    public void isOrderTextDisabledWhenExpectedValueOperationIsSelected() {
        Operation expectedValueOperation = Operation.EXPECTED_VALUE;

        viewModel.setOperation(expectedValueOperation);

        assertFalse(viewModel.isOrderTextEnabled());
    }

    @Test
    public void isOrderTextDisabledWhenDispersionOperationIsSelected() {
        Operation dispersionOperation = Operation.DISPERSION;

        viewModel.setOperation(dispersionOperation);

        assertFalse(viewModel.isOrderTextEnabled());
    }

    @Test
    public void isOrderTextEnabledWhenInitialMomentOperationIsSelected() {
        Operation initialMomentOperation = Operation.INITIAL_MOMENT;

        viewModel.setOperation(initialMomentOperation);

        assertTrue(viewModel.isOrderTextEnabled());
    }

    @Test
    public void isOrderTextEnabledWhenCentralMomentOperationIsSelected() {
        Operation centralMomentOperation = Operation.CENTRAL_MOMENT;

        viewModel.setOperation(centralMomentOperation);

        assertTrue(viewModel.isOrderTextEnabled());
    }

    @Test
    public void isOffsetTextDisabledWhenExpectedValueOperationIsSelected() {
        Operation expectedValueOperation = Operation.EXPECTED_VALUE;

        viewModel.setOperation(expectedValueOperation);

        assertFalse(viewModel.isOffsetTextEnabled());
    }

    @Test
    public void isOffsetTextDisabledWhenDispersionOperationIsSelected() {
        Operation dispersionOperation = Operation.DISPERSION;

        viewModel.setOperation(dispersionOperation);

        assertFalse(viewModel.isOffsetTextEnabled());
    }

    @Test
    public void isOffsetTextDisabledWhenInitialMomentOperationIsSelected() {
        Operation initialMomentOperation = Operation.INITIAL_MOMENT;

        viewModel.setOperation(initialMomentOperation);

        assertFalse(viewModel.isOffsetTextEnabled());
    }

    @Test
    public void isOffsetTextEnabledWhenCentralMomentOperationIsSelected() {
        Operation centralMomentOperation = Operation.CENTRAL_MOMENT;

        viewModel.setOperation(centralMomentOperation);

        assertTrue(viewModel.isOffsetTextEnabled());
    }

    @Test
    public void canDetectCorrectDistributionUnit() {
        viewModel.setValueText("1");
        viewModel.setProbabilityText("1");

        assertTrue(viewModel.checkDistributionUnit());
        assertTrue(viewModel.isAddToDistributionButtonEnabled());
    }

    @Test
    public void canDetectEmptyValueOfDistributionUnit() {
        viewModel.setValueText("");
        viewModel.setProbabilityText("1");

        assertFalse(viewModel.checkDistributionUnit());
        assertFalse(viewModel.isAddToDistributionButtonEnabled());
        assertEquals(Status.BAD_INPUT_FORMAT, viewModel.getStatusMessageText());
    }

    @Test
    public void canDetectEmptyProbabilityOfDistributionUnit() {
        viewModel.setValueText("1");
        viewModel.setProbabilityText("");

        assertFalse(viewModel.checkDistributionUnit());
        assertFalse(viewModel.isAddToDistributionButtonEnabled());
        assertEquals(Status.BAD_INPUT_FORMAT, viewModel.getStatusMessageText());
    }

    @Test
    public void canDetectIncorrectValueFormatOfDistributionUnit() {
        viewModel.setValueText("abc");
        viewModel.setProbabilityText("1");

        assertFalse(viewModel.checkDistributionUnit());
        assertFalse(viewModel.isAddToDistributionButtonEnabled());
        assertEquals(Status.BAD_INPUT_FORMAT, viewModel.getStatusMessageText());
    }

    @Test
    public void canDetectIncorrectProbabilityFormatOfDistributionUnit() {
        viewModel.setValueText("1");
        viewModel.setProbabilityText("abc");

        assertFalse(viewModel.checkDistributionUnit());
        assertFalse(viewModel.isAddToDistributionButtonEnabled());
        assertEquals(Status.BAD_INPUT_FORMAT, viewModel.getStatusMessageText());
    }

    @Test
    public void canDetectBadProbabilityByAddToDistributionProcess() {
        viewModel.setValueText("1");
        viewModel.setProbabilityText("-1");

        viewModel.addToDistributionProcess();

        assertEquals(Status.BAD_PROBABILITY_VALUE, viewModel.getStatusMessageText());
    }
}
