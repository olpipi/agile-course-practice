package ru.unn.agile.MyAbstractSet.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.unn.agile.MyAbstractSet.viewmodel.ViewModel.Operation;

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
    public void canSetDefaultValues() {
        assertEquals("", viewModel.firstSetTextAreaProperty().get());
        assertEquals("", viewModel.secondSetTextAreaProperty().get());
        assertEquals("", viewModel.resultTextAreaProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
        assertEquals(Operation.UNITE, viewModel.operationProperty().get());
        assertTrue(viewModel.executeButtonDisabledProperty().get());
    }

    @Test
    public void statusIsWaitingWhenFirstFieldIsEmptyButSecondFieldFilled() {
        viewModel.firstSetTextAreaProperty().setValue("");
        viewModel.secondSetTextAreaProperty().setValue("3");

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenBothFieldsFilled() {
        viewModel.firstSetTextAreaProperty().setValue("4");
        viewModel.secondSetTextAreaProperty().setValue("3");

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsSuccessWhenOperationExecute() {
        viewModel.execute();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void executeButtonIsDisabledInitially() {
        assertTrue(viewModel.executeButtonDisabledProperty().get());
    }

    @Test
    public void executeButtonIsEnabledWhenCorrectInput() {
        viewModel.firstSetTextAreaProperty().setValue("3");
        viewModel.secondSetTextAreaProperty().setValue("4");

        assertFalse(viewModel.executeButtonDisabledProperty().get());
    }
}
