package ru.unn.agile.binarytree.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.binarytree.model.BinarySearchTree.Operation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        assertEquals("", viewModel.keyProperty().get());
        assertEquals("", viewModel.valueProperty().get());
        assertEquals(Operation.ADD, viewModel.operationProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void getAllOperationList() {

        List<Operation> list = new ArrayList<Operation>();
        list.add(Operation.ADD);
        list.add(Operation.DELETE);

        assertEquals(list, viewModel.operationsProperty().get());
    }

    @Test
    public void executeButtonIsDisabledInitially() {
        assertTrue(viewModel.executionDisabledProperty().get());
    }

    @Test
    public void executeButtonIsDisabledWhenFormatIsBad() {
        viewModel.keyProperty().set("qwe");
        viewModel.valueProperty().set("qwe");
        assertTrue(viewModel.executionDisabledProperty().get());
    }

    @Test
    public void statusIsWaitingWhenExecuteWithEmptyFields() {
        viewModel.execute();

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsBadFormatWhenValueIsNotDouble() {
        viewModel.keyProperty().set("qwe");
        viewModel.valueProperty().set("qwe");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenParamsAreCorrect() {
        viewModel.valueProperty().set("1.4");
        viewModel.keyProperty().set("qwe");

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void addCommandIsCorrect() {
        viewModel.valueProperty().set("1.4");
        viewModel.keyProperty().set("qwe");
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.execute();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void doubleAddCommandIsIncorrect() {
        viewModel.valueProperty().set("1.4");
        viewModel.keyProperty().set("qwe");
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.execute();
        viewModel.execute();

        assertEquals(Status.UNSUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void delCommandIsCorrectAfterAdd() {
        viewModel.valueProperty().set("1.4");
        viewModel.keyProperty().set("qwe");
        viewModel.operationProperty().set(Operation.ADD);
        viewModel.execute();

        viewModel.operationProperty().set(Operation.DELETE);
        viewModel.execute();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void delCommandIsIncorrectWithoutAdd() {
        viewModel.valueProperty().set("1.4");
        viewModel.keyProperty().set("qwe");

        viewModel.operationProperty().set(Operation.DELETE);
        viewModel.execute();

        assertEquals(Status.UNSUCCESS.toString(), viewModel.statusProperty().get());
    }


}
