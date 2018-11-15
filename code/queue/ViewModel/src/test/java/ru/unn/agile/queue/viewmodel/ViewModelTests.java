package ru.unn.agile.queue.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import ru.unn.agile.queue.viewmodel.ViewModel.*;

public class ViewModelTests {
    private ViewModel viewModel;
    private final int ANY_KEY = 1;

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
        assertEquals("", viewModel.getNewElem());
        assertEquals("", viewModel.getOutputQueue());
        assertEquals(State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

    @Test
    public void canAddOneElemToQueue() {
        viewModel.setNewElem("5.43");
        viewModel.Add();

        assertEquals("[5.43]", viewModel.getOutputQueue());
    }

    @Test
    public void canAddToQueue() {
        viewModel.setNewElem("1.6");
        viewModel.Add();
        viewModel.setNewElem("-6.3");
        viewModel.Add();
        viewModel.setNewElem("0.0");
        viewModel.Add();
        viewModel.setNewElem("-4.9");
        viewModel.Add();
        viewModel.setNewElem("8");
        viewModel.Add();
        viewModel.setNewElem("92");
        viewModel.Add();

        assertEquals("[1.6, -6.3, 0.0, -4.9, 8.0, 92.0]", viewModel.getOutputQueue());
    }

    @Test
    public void canRemoveQueueHead() {
        viewModel.setNewElem("53");
        viewModel.Add();
        viewModel.setNewElem("63.2");
        viewModel.Add();
        viewModel.setNewElem("-4.2");
        viewModel.Add();

        viewModel.Remove();

        assertEquals("[63.2, -4.2]", viewModel.getOutputQueue());
    }

    @Test
    public void canClearQueue() {
        viewModel.setNewElem("33");
        viewModel.Add();
        viewModel.setNewElem("11.3");
        viewModel.Add();
        viewModel.setNewElem("2.5");
        viewModel.Add();
        viewModel.setNewElem("6.2");
        viewModel.Add();

        viewModel.Clear();

        assertEquals("[]", viewModel.getOutputQueue());
    }

    @Test
    public void isWaitingStateWhenAddElemFieldIsEmpty() {
        viewModel.setNewElem("");

        viewModel.processingAddField(ANY_KEY);

        assertEquals(State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

    @Test
    public void isReadyStateWhenAddElemFieldIsFill() {
        viewModel.setNewElem("6.1");

        viewModel.processingAddField(ANY_KEY);

        assertEquals(State.READY_TO_ADD, viewModel.getCurrentState());
    }

    @Test
    public void canDetectBadFormat() {
        viewModel.setNewElem("Hello");

        viewModel.processingAddField(ANY_KEY);

        assertEquals(State.INVALID_FORMAT, viewModel.getCurrentState());
    }

    @Test
    public void canSwitchStateIfAddFieldIsCorrect() {
        viewModel.setNewElem("hi");
        viewModel.processingAddField(ANY_KEY);
        viewModel.setNewElem("33");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(State.READY_TO_ADD, viewModel.getCurrentState());
    }

    @Test
    public void canSwitchStateIfAddFieldIsInvalid() {
        viewModel.setNewElem("33");
        viewModel.processingAddField(ANY_KEY);
        viewModel.setNewElem("hi");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(State.INVALID_FORMAT, viewModel.getCurrentState());
    }

    @Test
    public void canSwitchStateIfAddFieldIsEmpty() {
        viewModel.setNewElem("33");
        viewModel.processingAddField(ANY_KEY);
        viewModel.setNewElem("");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

    @Test
    public void isWaitingStateWhenStartup() {
        assertEquals(State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

    @Test
    public void isAddButtonDisabledWhenStartup() {
        assertEquals(false, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isRemoveButtonDisabledWhenStartup() {
        assertEquals(false, viewModel.isRemoveButtonEnabled());
    }

    @Test
    public void isClearButtonDisabledWhenStartup() {
        assertEquals(false, viewModel.isClearButtonEnabled());
    }

    @Test
    public void isAddButtonEnabledWhenAddFieldIsCorrect() {
        viewModel.setNewElem("37.3");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(true, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isAddButtonDisabledWhenAddFieldIsInvalid() {
        viewModel.setNewElem("kdbsj");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(false, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isAddButtonDisabledWhenAddFieldIsEmpty() {
        viewModel.setNewElem("");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(false, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isClearButtonEnabledWhenQueueIsNotEmpty() {
        viewModel.setNewElem("5");
        viewModel.Add();
        viewModel.setNewElem("8");
        viewModel.Add();

        assertEquals(true, viewModel.isClearButtonEnabled());
    }

    @Test
    public void isRemoveButtonEnabledWhenQueueIsNotEmpty() {
        viewModel.setNewElem("4");
        viewModel.Add();
        viewModel.setNewElem("1");
        viewModel.Add();

        assertEquals(true, viewModel.isRemoveButtonEnabled());
    }

    @Test
    public void canClearDisableClearButton() {
        viewModel.setNewElem("6");
        viewModel.Add();
        viewModel.setNewElem("2");
        viewModel.Add();
        viewModel.setNewElem("8");
        viewModel.Add();
        viewModel.setNewElem("11");
        viewModel.Add();

        viewModel.Clear();

        assertEquals(false, viewModel.isClearButtonEnabled());
    }

    @Test
    public void canClearDisableRemoveButton() {
        viewModel.setNewElem("23");
        viewModel.Add();
        viewModel.setNewElem("1");
        viewModel.Add();
        viewModel.setNewElem("5");
        viewModel.Add();
        viewModel.setNewElem("3");
        viewModel.Add();

        viewModel.Clear();

        assertEquals(false, viewModel.isRemoveButtonEnabled());
    }

    @Test
    public void canRemoveDisableClearButton() {
        viewModel.setNewElem("20");
        viewModel.Add();

        viewModel.Remove();

        assertEquals(false, viewModel.isClearButtonEnabled());
    }

    @Test
    public void canRemoveDisableRemoveButton() {
        viewModel.setNewElem("13");
        viewModel.Add();

        viewModel.Remove();

        assertEquals(false, viewModel.isRemoveButtonEnabled());
    }

}
