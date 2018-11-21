package ru.unn.agile.stringcalculator.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.stringcalculator.model.errorhandling.NotANumberException;

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

    @Test
    public void canSetInitialInputData() {

        StringProperty initialInputData = viewModel.inputDataProperty();

        assertEquals("", initialInputData.get());
    }

    @Test
    public void canSetAddOperation() {
        viewModel.operationProperty().set(Operation.ADD);

        assertEquals(Operation.ADD, viewModel.operationProperty().get());
    }


    @Test
    public void hasAddOperationCorrectResultWhenInputDataIsCorrect() {
        viewModel.inputDataProperty().set("31,8");
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.calculate();

        assertEquals("39", viewModel.resultProperty().get());
    }

    @Test
    public void statusIsWaitingWhenInputFieldIsEmpty() {
        viewModel.operationProperty().set(Operation.ADD);

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.WAITING.toString(), expectedStatus.get());
    }

    @Test
    public void statusIsBadFormatWhenInputDataIsNotCorrect() {
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.inputDataProperty().set("31.8,5");

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.BAD_FORMAT.toString(), expectedStatus.get());
    }

    @Test
    public void statusIsReadyWhenInputDataIsCorrect() {
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.inputDataProperty().set("31,8");

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.READY.toString(), expectedStatus.get());
    }

    @Test
    public void statusIsSuccesWhenCalculationPerformedSuccessfully() {
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.calculate();

        StringProperty expectedStatus = viewModel.statusProperty();
        assertEquals(Status.SUCCESS.toString(), expectedStatus.get());
    }

}
