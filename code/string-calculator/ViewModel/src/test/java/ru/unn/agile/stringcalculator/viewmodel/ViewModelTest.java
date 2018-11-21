package ru.unn.agile.stringcalculator.viewmodel;

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

    @Test(expected = NotANumberException.class)
    public void hasAddOperationCorrectResultWhenInputDataIsNotCorrect() {
        viewModel.inputDataProperty().set("31.4,8");
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.calculate();

        assertEquals("39", viewModel.resultProperty().get());
    }

}
