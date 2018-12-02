package ru.unn.agile.vector3d.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel(new FakeLogger());
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    protected void setExternalViewModel(final ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Test
    public void canSetInitialVectorValues() {
        // Arrange
        String emptyString = "";

        // Act
        StringProperty initialX = viewModel.vectorXProperty();
        StringProperty initialY = viewModel.vectorYProperty();
        StringProperty initialZ = viewModel.vectorZProperty();

        // Assert
        assertEquals(emptyString, initialX.get());
        assertEquals(emptyString, initialY.get());
        assertEquals(emptyString, initialZ.get());
    }

    @Test
    public void canSetInitialOtherVectorValues() {
        // Arrange
        String emptyString = "";

        // Act
        StringProperty initialOtherX = viewModel.otherVectorXProperty();
        StringProperty initialOtherY = viewModel.otherVectorYProperty();
        StringProperty initialOtherZ = viewModel.otherVectorZProperty();

        // Assert
        assertEquals(emptyString, initialOtherX.get());
        assertEquals(emptyString, initialOtherY.get());
        assertEquals(emptyString, initialOtherZ.get());
    }

    @Test
    public void canSetDefaultMultiplicationCoeffAndResult() {
        // Arrange
        String emptyString = "";

        // Act
        String defaultMultCoeff = viewModel.getMultiplicationCoeff();
        String defaultResult = viewModel.getResult();

        // Assert
        assertEquals(emptyString, defaultMultCoeff);
        assertEquals(emptyString, defaultResult);
    }


    @Test
    public void canSetDefaultOperationAndStatus() {
        // Arrange & Act
        ObjectProperty<Operation> defaultOperation = viewModel.operationProperty();
        StringProperty defaultStatus = viewModel.statusProperty();

        // Assert
        assertEquals(Operation.ADD, defaultOperation.get());
        assertEquals(ViewModel.Status.WAITING.toString(), defaultStatus.get());
        assertNotNull(viewModel.getOperations());
    }

    @Test
    public void statusIsWaitingWhenCalculateWithEmptyFields() {
        // Arrange & Act
        viewModel.calculate();

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.WAITING.toString(), expectedStatus.get());
    }

    @Test
    public void buttonIsDisabledWhenCalculateWithEmptyFields() {
        // Arrange & Act
        viewModel.calculate();

        // Assert
        BooleanProperty expectedButtonState = viewModel.calculationDisabledProperty();
        assertTrue(expectedButtonState.get());
    }

    @Test
    public void statusIsReadyWhenCalculateWithEmptyFields() {
        // Arrange & Act
        setInputData();

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.READY.toString(), expectedStatus.get());
    }

    @Test
    public void canReportBadFormat() {
        // Arrange & Act
        setInputData();
        viewModel.vectorYProperty().set("aa");

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.BAD_FORMAT.toString(), expectedStatus.get());
    }

    @Test
    public void calculateButtonIsDisabledWhenFormatIsBad() {
        // Arrange & Act
        setInputData();
        viewModel.vectorXProperty().set("trash");

        // Assert
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsEnabledWithCorrectInput() {
        // Arrange & Act
        setInputData();

        // Assert
        assertFalse(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWithIncompleteInput() {
        // Arrange & Act
        viewModel.vectorXProperty().set("1");

        // Assert
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void canSetAddOperation() {
        // Arrange & Act
        viewModel.operationProperty().set(Operation.ADD);

        // Assert
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
    }

    @Test
    public void addIsDefaultOperation() {
        // Arrange & Act & Assert
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
    }

    @Test
    public void operationAddHasCorrectResult() {
        // Arrange
        setInputData();

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("(4.1, -1.9, 9.3)", viewModel.resultProperty().get());
    }

    @Test
    public void operationSubtractHasCorrectResult() {
        // Arrange
        setInputData();
        viewModel.operationProperty().set(Operation.SUBTRACT);

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("(2.1, -5.9, 3.3)", viewModel.resultProperty().get());
    }

    @Test
    public void operationDotHasCorrectResult() {
        // Arrange
        setInputData();
        viewModel.operationProperty().set(Operation.DOT);

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("14.2", viewModel.resultProperty().get());
    }

    @Test
    public void canCheckBadFormatWhenOperationIsDot() {
        // Arrange
        setInputData();
        viewModel.operationProperty().set(Operation.DOT);

        // Act
        viewModel.otherVectorXProperty().set("aa");

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.BAD_FORMAT.toString(), expectedStatus.get());
    }

    @Test
    public void operationMultiplyHasCorrectResult() {
        // Arrange
        viewModel.vectorXProperty().set("4");
        viewModel.vectorYProperty().set("-3");
        viewModel.vectorZProperty().set("5");
        viewModel.multiplicationCoeffProperty().set("2");
        viewModel.operationProperty().set(Operation.MULTIPLY);

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("(8.0, -6.0, 10.0)", viewModel.resultProperty().get());
    }

    @Test
    public void canCheckBadFormatWhenOperationIsMultiply() {
        // Arrange
        viewModel.vectorXProperty().set("1");
        viewModel.vectorYProperty().set("-2");
        viewModel.vectorZProperty().set("3");
        viewModel.operationProperty().set(Operation.MULTIPLY);

        // Act
        viewModel.multiplicationCoeffProperty().set("aa");

        // Assert
        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(ViewModel.Status.BAD_FORMAT.toString(), expectedStatus.get());
    }

    @Test
    public void buttonIsActiveWhenOperationIsMultiply() {
        // Arrange
        viewModel.vectorXProperty().set("1");
        viewModel.vectorYProperty().set("-2");
        viewModel.vectorZProperty().set("3");
        viewModel.multiplicationCoeffProperty().set("2");

        // Act1
        viewModel.operationProperty().set(Operation.MULTIPLY);

        // Assert
        assertFalse(viewModel.isCalculationDisabled());
    }

    @Test
    public void operationMagnitudeHasCorrectResult() {
        // Arrange
        viewModel.vectorXProperty().set("1");
        viewModel.vectorYProperty().set("2");
        viewModel.vectorZProperty().set("3");
        viewModel.operationProperty().set(Operation.MAGNITUDE);

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("3.7416573867739413", viewModel.resultProperty().get());
    }

    @Test
    public void operationNormalizeHasCorrectResult() {
        // Arrange
        viewModel.vectorXProperty().set("-80");
        viewModel.vectorYProperty().set("0");
        viewModel.vectorZProperty().set("60");
        viewModel.operationProperty().set(Operation.NORMALIZE);

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("(-0.8, 0.0, 0.6)", viewModel.resultProperty().get());
    }

    @Test
    public void operationCrossHasCorrectResult() {
        // Arrange
        viewModel.vectorXProperty().set("-7");
        viewModel.vectorYProperty().set("-17");
        viewModel.vectorZProperty().set("1");

        viewModel.otherVectorXProperty().set("-2");
        viewModel.otherVectorYProperty().set("8");
        viewModel.otherVectorZProperty().set("9");
        viewModel.operationProperty().set(Operation.CROSS);

        // Act
        viewModel.calculate();

        // Assert
        assertEquals("(-161.0, 61.0, -90.0)", viewModel.resultProperty().get());
    }

    @Test
    public void buttonIsActiveWhenChangeOperationWithoutOtherVector() {
        // Arrange
        setInputData();
        viewModel.otherVectorXProperty().set("aaa");

        // Act1
        viewModel.operationProperty().set(Operation.NORMALIZE);

        // Assert
        assertFalse(viewModel.isCalculationDisabled());
    }

    @Test(expected = IllegalArgumentException.class)
    public void viewModelConstructorThrowsExceptionWithNullLogger() {
        // Act
        new ViewModel(null);
    }

    @Test
    public void logIsEmptyAfterInit() {
        // Arrange, Act
        List<String> log = viewModel.getLogList();

        // Assert
        assertTrue(log.isEmpty());
    }

    @Test
    public void logContainsOperationChangedMessage() {
        // Arrange, Act
        viewModel.operationProperty().setValue(Operation.NORMALIZE);

        // Assert
        String message = viewModel.getLogList().get(0);
        String expectedMessage = String.format(ViewModel.LogMessages.OPERATION_WAS_CHANGED,
                Operation.NORMALIZE);
        assertTrue(message.contains(expectedMessage));
    }

    @Test
    public void operationIsNotLoggedIfNotChanged() {
        // Arrange
        viewModel.operationProperty().setValue(Operation.NORMALIZE);

        // Act
        viewModel.operationProperty().setValue(Operation.NORMALIZE);

        // Assert
        assertEquals(1, viewModel.getLogList().size());
    }

    @Test
    public void logContainsMultCoefChangedMessage() {
        // Arrange, Act
        viewModel.multiplicationCoeffProperty().setValue("2.0");

        // Assert
        String message = viewModel.getLogList().get(0);
        String expectedMessage = String.format(ViewModel.LogMessages.MULT_COEF_WAS_CHANGED, "2.0");
        assertTrue(message.contains(expectedMessage));
    }

    @Test
    public void logContainsVectorsChangedMessageOnSingleFieldChange() {
        // Arrange, Act
        viewModel.vectorXProperty().setValue("1.0");

        // Assert
        String message = viewModel.getLogList().get(0);
        String expectedMessage = getExpectedVectorsChangedMessage();
        assertTrue(message.contains(expectedMessage));
    }

    @Test
    public void logContainsMultipleVectorChangedMessages() {
        // Arrange, Act
        setInputData();

        // Assert
        List<String> log = viewModel.getLogList();
        assertEquals(log.size(), 6);

        String message = viewModel.getLogList().get(5);
        String expectedMessage = getExpectedVectorsChangedMessage();
        assertTrue(message.contains(expectedMessage));
    }

    @Test
    public void logContainsCalculateMessage() {
        // Arrange
        setInputData();
        viewModel.operationProperty().setValue(Operation.DOT);

        // Act
        viewModel.calculate();

        // Assert
        String message = viewModel.getLogList().get(viewModel.getLogList().size() - 1);
        String expectedMessage = String.format(ViewModel.LogMessages.CALCULATE_WAS_PRESSED,
                viewModel.getVectorX(), viewModel.getVectorY(), viewModel.getVectorZ(),
                viewModel.getOtherVectorX(), viewModel.getOtherVectorY(),
                viewModel.getOtherVectorZ(), viewModel.getMultiplicationCoeff(),
                viewModel.getOperation());
        assertTrue(message.contains(expectedMessage));
    }

    @Test
    public void logPropertyIsEmptyAfterInit() {
        // Assert
        assertEquals("", viewModel.getLog());
        assertEquals("", viewModel.logProperty().get());
    }

    @Test
    public void logPropertyMirrorsLog() {
        // Arrange
        setInputData();
        viewModel.operationProperty().setValue(Operation.CROSS);

        // Act
        viewModel.calculate();

        // Assert
        List<String> log = viewModel.getLogList();
        StringBuilder expectedLog = new StringBuilder();
        for (String line : log) {
            expectedLog.append(line).append("\n");
        }
        assertTrue(viewModel.logProperty().get().contains(expectedLog.toString()));
    }

    @Test
    public void canCreateViewModelWithoutLogger() {
        // Arrange, Act
        ViewModel vm = new ViewModel();

        // Assert
        assertNotNull(vm);
    }

    @Test
    public void gettingStatusWithWrongNameReturnsNull() {
        // Arrange, Act
        ViewModel.Status status = ViewModel.Status.getByName("BAD NAME");

        // Assert
        assertNull(status);
    }

    @Test
    public void canCreateLogMessage() {
        // Arrange, Act
        ViewModel.LogMessages logMsg = new ViewModel.LogMessages();

        // Assert
        assertNotNull(logMsg);
    }

    private void setInputData() {
        viewModel.vectorXProperty().set("3.1");
        viewModel.vectorYProperty().set("-3.9");
        viewModel.vectorZProperty().set("6.3");

        viewModel.otherVectorXProperty().set("1");
        viewModel.otherVectorYProperty().set("2");
        viewModel.otherVectorZProperty().set("3");
    }

    private String getExpectedVectorsChangedMessage() {
        return String.format(ViewModel.LogMessages.VECTORS_WERE_CHANGED,
                viewModel.vectorXProperty().get(),
                viewModel.vectorYProperty().get(),
                viewModel.vectorZProperty().get(),
                viewModel.otherVectorXProperty().get(),
                viewModel.otherVectorYProperty().get(),
                viewModel.otherVectorZProperty().get());
    }
}
