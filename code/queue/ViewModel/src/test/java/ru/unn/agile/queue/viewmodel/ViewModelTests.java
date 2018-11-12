package ru.unn.agile.queue.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void isWaitingStateInBeginning() {
        assertEquals(ViewModel.State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

    @Test
    public void isWaitingStateWhenAddElemFieldIsEmpty() {
        viewModel.setNewElem("");

        viewModel.processingAddField(ANY_KEY);

        assertEquals(ViewModel.State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

    @Test
    public void isReadyStateWhenAddElemFieldIsFill() {
        viewModel.setNewElem("6.1");

        viewModel.processingAddField(ANY_KEY);

        assertEquals(ViewModel.State.READY_TO_ADD, viewModel.getCurrentState());
    }

    @Test
    public void canDetectBadFormat() {
        viewModel.setNewElem("Hello");

        viewModel.processingAddField(ANY_KEY);

        assertEquals(ViewModel.State.INVALID_FORMAT, viewModel.getCurrentState());
    }

    @Test
    public void canSwitchStateIfAddFieldIsCorrect() {
        viewModel.setNewElem("hi");
        viewModel.processingAddField(ANY_KEY);
        viewModel.setNewElem("33");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(ViewModel.State.READY_TO_ADD, viewModel.getCurrentState());
    }

    @Test
    public void canSwitchStateIfAddFieldIsInvalid() {
        viewModel.setNewElem("33");
        viewModel.processingAddField(ANY_KEY);
        viewModel.setNewElem("hi");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(ViewModel.State.INVALID_FORMAT, viewModel.getCurrentState());
    }

    @Test
    public void canSwitchStateIfAddFieldIsEmpty() {
        viewModel.setNewElem("33");
        viewModel.processingAddField(ANY_KEY);
        viewModel.setNewElem("");
        viewModel.processingAddField(ANY_KEY);

        assertEquals(ViewModel.State.WAITING_FOR_INPUT, viewModel.getCurrentState());
    }

}
