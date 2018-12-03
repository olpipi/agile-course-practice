package ru.unn.agile.matrix.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    private void enterOnlyOneInputField() {
        viewModel.matrixAProperty().setValue("[1]");
        viewModel.matrixBProperty().setValue("");
    }

    private void enterBadFormatInputData() {
        viewModel.matrixAProperty().setValue("[1][0 1]");
        viewModel.matrixBProperty().setValue("[0][0");
    }

    private void enterIncompatibleSizeMatrices() {
        viewModel.matrixAProperty().setValue("[1 2]");
        viewModel.matrixBProperty().setValue("[3]");
    }

    private void enterSameSizedMatrices() {
        viewModel.matrixAProperty().setValue("[1 0][0 1]");
        viewModel.matrixBProperty().setValue("[1 0][0 1]");
    }

    private String setupMatrixAdditionAndGetResult() {
        viewModel.operationProperty().setValue(Operation.ADD);
        viewModel.matrixAProperty().setValue("[1 0][0 1]");
        viewModel.matrixBProperty().setValue("[-1 0][0 -1]");

        return "[0.0 0.0][0.0 0.0]";
    }

    private String setupMatrixSubtractionAndGetResult() {
        String matrix = "[1 0][0 1]";
        viewModel.operationProperty().setValue(Operation.SUBTRACT);
        viewModel.matrixAProperty().setValue(matrix);
        viewModel.matrixBProperty().setValue(matrix);

        return "[0.0 0.0][0.0 0.0]";
    }

    private String setupMatrixMultiplicationAndGetResult() {
        String matrix = "[1.0 0.0][0.0 1.0]";
        viewModel.operationProperty().setValue(Operation.MULTIPLY);
        viewModel.matrixAProperty().setValue(matrix);
        viewModel.matrixBProperty().setValue(matrix);

        return matrix;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("[1 2][3 4]", viewModel.matrixAProperty().get());
        assertEquals("[4 3][2 1]", viewModel.matrixBProperty().get());
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
        assertEquals(false, viewModel.calculateButtonDisabledProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingIfNotEnoughDataIsEntered() {
        enterOnlyOneInputField();

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormat() {
        enterBadFormatInputData();

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportIncompatibleSizeForAddition() {
        viewModel.operationProperty().setValue(Operation.ADD);
        enterIncompatibleSizeMatrices();

        assertEquals(Status.INCOMPATIBLE_SIZE.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportIncompatibleSizeForSubtraction() {
        viewModel.operationProperty().setValue(Operation.SUBTRACT);
        enterIncompatibleSizeMatrices();

        assertEquals(Status.INCOMPATIBLE_SIZE.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportIncompatibleSizeForMultiplication() {
        viewModel.operationProperty().setValue(Operation.MULTIPLY);
        enterIncompatibleSizeMatrices();

        assertEquals(Status.INCOMPATIBLE_SIZE.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenInputIsValid() {
        enterSameSizedMatrices();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void convertButtonIsDisabledIfNotEnoughDataIsEntered() {
        enterOnlyOneInputField();

        assertTrue(viewModel.calculateButtonDisabledProperty().get());
    }

    @Test
    public void convertButtonIsDisabledWhenFormatIsBad() {
        enterBadFormatInputData();

        assertTrue(viewModel.calculateButtonDisabledProperty().get());
    }

    @Test
    public void convertButtonIsDisabledWhenIncompatibleSizeMatricesAreEntered() {
        viewModel.operationProperty().setValue(Operation.ADD);
        enterIncompatibleSizeMatrices();

        assertTrue(viewModel.calculateButtonDisabledProperty().get());
    }

    @Test
    public void convertButtonIsEnabledWithCorrectInput() {
        enterSameSizedMatrices();

        assertFalse(viewModel.calculateButtonDisabledProperty().get());
    }

    @Test
    public void canGetSuccessMessage() {
        enterSameSizedMatrices();

        viewModel.calculate();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canAddMatrices() {
        String expectedResult = setupMatrixAdditionAndGetResult();

        viewModel.calculate();

        assertEquals(expectedResult, viewModel.resultProperty().get());
    }

    @Test
    public void canSubtractMatrices() {
        String expectedResult = setupMatrixSubtractionAndGetResult();

        viewModel.calculate();

        assertEquals(expectedResult, viewModel.resultProperty().get());
    }

    @Test
    public void canMultiplyMatrices() {
        String expectedResult = setupMatrixMultiplicationAndGetResult();

        viewModel.calculate();

        assertEquals(expectedResult, viewModel.resultProperty().get());
    }

    @Test
    public void statusUpdatesWhenOperationIsChanged() {
        viewModel.operationProperty().setValue(Operation.MULTIPLY);
        viewModel.matrixAProperty().setValue("[1 2]");
        viewModel.matrixBProperty().setValue("[3][4]");

        viewModel.operationProperty().setValue(Operation.ADD);

        assertEquals(Status.INCOMPATIBLE_SIZE.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void calculateButtonAvailabilityUpdatesWhenOperationIsChanged() {
        viewModel.operationProperty().setValue(Operation.MULTIPLY);
        viewModel.matrixAProperty().setValue("[1 2]");
        viewModel.matrixBProperty().setValue("[3][4]");

        viewModel.operationProperty().setValue(Operation.ADD);

        assertTrue(viewModel.calculateButtonDisabledProperty().get());
    }
}

