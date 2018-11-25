package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.property.StringProperty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ViewModelTest {
    private ViewModel viewModel;

    public void setExternalViewModel(final ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Before
    public void setUp() {
        if (viewModel == null) {
            viewModel = new ViewModel(new FakeLogger());
        }
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetInitialInputData() {
        StringProperty initialInputData = viewModel.inputDataProperty();

        assertEquals("", initialInputData.get());
    }

    @Test
    public void canSetAddOperation() {
        assertEquals(Operation.ADD, viewModel.getOperation());
    }

    @Test
    public void hasAddOperationCorrectResultWhenInputDataIsCorrect() {
        setInputData("31,8");

        viewModel.calculate();

        assertEquals("39", viewModel.getResult());
    }

    @Test
    public void isItImpossibleToCalculateWhenButtonInActive() {
        setInputData("21.8");

        viewModel.calculate();

        assertNull(viewModel.resultProperty().get());
    }

    @Test
    public void operationsListIsNotNull() {
        assertNotNull(viewModel.operationProperty());
    }

    @Test
    public void operationsListContainsOnlyAddOperation() {
        assertEquals(Operation.ADD, viewModel.getOperations().get(0));
    }

    @Test
    public void statusIsWaitingWhenInputFieldIsEmpty() {
        assertEquals(Status.WAITING.toString(), viewModel.getStatus());
    }

    @Test
    public void statusIsBadFormatWhenInputDataIsNotCorrect() {
        setInputData("31.8,5");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenInputDataIsCorrect() {
        setInputData("66,8");

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsSuccessWhenCalculationPerformedSuccessfully() {
        setInputData("71,8");

        viewModel.calculate();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isCalculateButtonNotActiveWhenStatusIsWaiting() {
        assertTrue(viewModel.isCalculationDisabled());
    }

    @Test
    public void isCalculateButtonNotActiveWhenStatusIsBadFormat() {
        setInputData("31.8,5");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void isCalculateButtonActiveWhenStatusIsReady() {
        setInputData("31,8");

        assertFalse(viewModel.isCalculationDisabled());
    }

    @Test(expected = IllegalArgumentException.class)
    public void viewModelConstructorThrowsExceptionWithNullLogger() {
        new ViewModel(null);
    }

    @Test
    public void logIsEmptyInTheBeginning() {
        List<String> log = viewModel.getLog();

        assertTrue(log.isEmpty());
    }

    @Test
    public void logContainsProperMessageAfterCalculation() {
        setInputData("2,1");
        viewModel.calculate();
        String logMsg = viewModel.getLog().get(0);

        assertTrue(logMsg.matches(".*" + LogMessages.CALCULATE_WAS_PRESSED.toString() + ".*"));
    }

    @Test
    public void logContainsInputStringAfterCalculation() {
        setInputData("25");

        viewModel.calculate();

        String logMsg = viewModel.getLog().get(0);
        assertTrue(logMsg.matches(".*" + viewModel.inputDataProperty().get()));
    }

    @Test
    public void stringInputIsProperlyFormatted() {
        setInputData("12,1");

        viewModel.calculate();

        String logMsg = viewModel.getLog().get(0);
        assertTrue(logMsg.matches(".*String: " + viewModel.inputDataProperty().get() + ".*"));
    }

    @Test
    public void typeDefaultOperationIsCorrectlyMentionedInLog() {
        setInputData("13");

        viewModel.calculate();

        String logMsg = viewModel.getLog().get(0);
        assertTrue(logMsg.matches(".*ADD.*"));
    }

    @Test
    public void canPutSeveralLogMessages() {
        setInputData("33");
        viewModel.calculate();

        setInputData("88");
        viewModel.calculate();

        setInputData("4");
        viewModel.calculate();

        assertEquals(3, viewModel.getLog().size());
    }

    @Test
    public void loggingDoesNotOccurWhenButtonIsDisabled() {
        viewModel.calculate();

        assertTrue(viewModel.getLog().isEmpty());
    }

    @Test
    public void areaLogIsEmptyWhenButtonIsDisabled() {
        viewModel.calculate();

        assertNull(viewModel.areaLogProperty().get());
    }

    @Test
    public void argumentsAreCorrectlyLogged() {
        setInputData("6,3");

        viewModel.subsChanged(Boolean.TRUE, Boolean.FALSE);

        String logMsg = viewModel.getLog().get(0);
        assertTrue(logMsg.matches(".*" + LogMessages.EDITING_FINISHED
                + "Input string: \\[ " + viewModel.inputDataProperty().get() + " \\]"));
    }

    @Test
    public void areaLogContainsLogMessagesAfterCalculation() {
        setInputData("3,3");

        viewModel.calculate();

        assertFalse(viewModel.getAreaLog().isEmpty());
    }

    @Test
    public void areaLogMessageIsEqualsLogMessage() {
        setInputData("5,6");

        viewModel.calculate();

        assertEquals(viewModel.getLog().get(0) + "\n", viewModel.getAreaLog());
    }

    @Test
    public void doNotLogSameParametersTwice() {
        setInputData("12");
        viewModel.subsChanged(Boolean.TRUE, Boolean.FALSE);
        setInputData("12");
        viewModel.subsChanged(Boolean.TRUE, Boolean.FALSE);

        assertEquals(1, viewModel.getLog().size());
    }

    private void setInputData(final String str) {
        viewModel.inputDataProperty().set(str);
    }
}
