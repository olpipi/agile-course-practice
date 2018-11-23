package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ViewModelTest {
    private ViewModel viewModel;

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
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
    }

    @Test
    public void hasAddOperationCorrectResultWhenInputDataIsCorrect() {
        setInputData("31,8");

        viewModel.calculate();

        assertEquals("39", viewModel.resultProperty().get());
    }

    @Test
    public void isItImpossibleToCalculateWhenButtonInActive() {
        setInputData("21.8");

        viewModel.calculate();

        assertNull(viewModel.resultProperty().get());
    }

    @Test
    public void operationsListContainsOnlyAddOperation() {
        ObservableList operationsList = viewModel.getOperations();

        assertEquals(Operation.ADD, operationsList.get(0));
    }

    @Test
    public void statusIsWaitingWhenInputFieldIsEmpty() {
        StringProperty expectedStatus = viewModel.statusProperty();

        assertEquals(Status.WAITING.toString(), expectedStatus.get());
    }

    @Test
    public void statusIsBadFormatWhenInputDataIsNotCorrect() {
        setInputData("31.8,5");

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.BAD_FORMAT.toString(), expectedStatus.get());
    }

    @Test
    public void statusIsReadyWhenInputDataIsCorrect() {
        setInputData("66,8");

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.READY.toString(), expectedStatus.get());
    }

    @Test
    public void statusIsSuccessWhenCalculationPerformedSuccessfully() {
        setInputData("71,8");

        viewModel.calculate();

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.SUCCESS.toString(), expectedStatus.get());
    }

    @Test
    public void isCalculateButtonNotActiveWhenStatusIsWaiting() {
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void isCalculateButtonNotActiveWhenStatusIsBadFormat() {
        setInputData("31.8,5");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void isCalculateButtonActiveWhenStatusIsReady() {
        setInputData("31,8");

        assertFalse(viewModel.calculationDisabledProperty().get());
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
        String message = viewModel.getLog().get(0);

        assertTrue(message.matches(LogMessages.CALCULATE_WAS_PRESSED + ".*"));
    }

    @Test
    public void logContainsInputStringAfterCalculation() {
        setInputData("25");

        viewModel.calculate();

        String message = viewModel.getLog().get(0);
        assertTrue(message.matches(".*" + viewModel.inputDataProperty().get()));
    }

    @Test
    public void stringInputIsProperlyFormatted() {
        setInputData("12,1");

        viewModel.calculate();

        String message = viewModel.getLog().get(0);
        assertTrue(message.matches(".*String: " + viewModel.inputDataProperty().get() + ".*"));
    }

    @Test
    public void typeDefaultOperationIsCorrectlyMentionedInLog() {
        setInputData("13");

        viewModel.calculate();

        String message = viewModel.getLog().get(0);
        assertTrue(message.matches(".*ADD.*"));
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

    private void setInputData(final String str) {
        viewModel.inputDataProperty().set(str);
    }
}
