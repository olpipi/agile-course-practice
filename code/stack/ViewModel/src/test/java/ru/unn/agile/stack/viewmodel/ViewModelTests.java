package ru.unn.agile.stack.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Stack is empty", viewModel.getStackIsEmptyStatus());
        assertEquals("0", viewModel.getStackSize());
        assertEquals("None", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("", viewModel.getAddingElement());
    }

    @Test
    public void isPopButtonNotVisibleWhenStart() {
        assertEquals(false, viewModel.isPopButtonVisible());
    }

    @Test
    public void isWaitingStatusWhenStart() {
        assertEquals(ViewModel.Status.WAITING_FOR_INPUT, viewModel.getStatusMessage());
    }

    @Test
    public void canAddNewElement() {
        viewModel.addElement("1");

        assertEquals("Stack is not empty", viewModel.getStackIsEmptyStatus());
        assertEquals("1", viewModel.getStackSize());
        assertEquals("1.0", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("1", viewModel.getAddingElement());
    }

    @Test
    public void isReadyToAddStatusWhenAddNewElement() {
        viewModel.addElement("11");
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void isPopButtonIsVisibleAfterAddingElement() {
        viewModel.addElement("105");
        assertEquals(true, viewModel.isPopButtonVisible());
    }

    @Test
    public void doNotAddNonValidElement() {
        viewModel.addElement("abc");

        assertEquals("Stack is empty", viewModel.getStackIsEmptyStatus());
        assertEquals("0", viewModel.getStackSize());
        assertEquals("None", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("", viewModel.getAddingElement());
    }

    @Test
    public void isInvalidFormatStatusWhenAddInvalidElement() {
        viewModel.addElement("abc");
        assertEquals(ViewModel.Status.INVALID_FORMAT, viewModel.getStatusMessage());
    }

    @Test
    public void isPopIsNotVisibleWhenAddInvalidElement() {
        viewModel.addElement("abc");
        assertEquals(false, viewModel.isPopButtonVisible());
    }

    @Test
    public void canAddFewElements() {
        viewModel.addElement("1");
        viewModel.addElement("2");
        viewModel.addElement("3.7");
        viewModel.addElement("-4.9");
        viewModel.addElement("5.95");

        assertEquals("Stack is not empty", viewModel.getStackIsEmptyStatus());
        assertEquals("5", viewModel.getStackSize());
        assertEquals("5.95", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("5.95", viewModel.getAddingElement());
    }

    @Test
    public void isReadyToAddStatusWhenAddFewElement() {
        viewModel.addElement("-18");
        viewModel.addElement("82.9");
        viewModel.addElement("65.07");
        viewModel.addElement("-14.09");
        viewModel.addElement("-11.95");
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void isPopButtonIsVisibleAfterAddingFewElement() {
        viewModel.addElement("-61");
        viewModel.addElement("52");
        viewModel.addElement("36.7");
        viewModel.addElement("-3.96");
        viewModel.addElement("5.9511");
        assertEquals(true, viewModel.isPopButtonVisible());
    }

    @Test
    public void canAddAndPopElement() {
        viewModel.addElement("1");
        viewModel.popElement();

        assertEquals("Stack is empty", viewModel.getStackIsEmptyStatus());
        assertEquals("0", viewModel.getStackSize());
        assertEquals("None", viewModel.getStackTopElement());
        assertEquals("1.0", viewModel.getStackPopElement());
        assertEquals("1", viewModel.getAddingElement());
    }

    @Test
    public void isPopButtonIsNotVisibleAfterAddAndPopElement() {
        viewModel.addElement("-1");
        viewModel.popElement();
        assertEquals(false, viewModel.isPopButtonVisible());
    }

    @Test
    public void isReadyToAddStatusAfterAddAndPopElement() {
        viewModel.addElement("11");
        viewModel.popElement();
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void canAddAndPopElementFewTimes() {
        viewModel.addElement("1");
        viewModel.popElement();
        viewModel.addElement("-53.7");
        viewModel.addElement("11");
        viewModel.addElement("65.8");
        viewModel.addElement("100");
        viewModel.popElement();
        viewModel.popElement();

        assertEquals("Stack is not empty", viewModel.getStackIsEmptyStatus());
        assertEquals("2", viewModel.getStackSize());
        assertEquals("11.0", viewModel.getStackTopElement());
        assertEquals("65.8", viewModel.getStackPopElement());
        assertEquals("100", viewModel.getAddingElement());
    }

    @Test
    public void isPopButtonIsVisibleAfterAddAndPopElementFewTimes() {
        viewModel.addElement("231");
        viewModel.popElement();
        viewModel.addElement("-763.7");
        viewModel.addElement("134");
        assertEquals(true, viewModel.isPopButtonVisible());
    }

    @Test
    public void isReadyToAddStatusAfterAddAndPopElementFewTimes() {
        viewModel.addElement("11");
        viewModel.popElement();
        viewModel.addElement("-554.7");
        viewModel.addElement("1");
        viewModel.addElement("835.8");
        viewModel.addElement("1420");
        viewModel.popElement();
        viewModel.popElement();
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void canNotPopFromEmptyStack() {
        viewModel.popElement();

        assertEquals("Stack is empty", viewModel.getStackIsEmptyStatus());
        assertEquals("0", viewModel.getStackSize());
        assertEquals("None", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("", viewModel.getAddingElement());
    }

    @Test
    public void isWaitingStatusWhenCanNotPopFromEmptyStack() {
        viewModel.popElement();
        assertEquals(ViewModel.Status.WAITING_FOR_INPUT, viewModel.getStatusMessage());
    }

    @Test
    public void isPopButtonIsNotVisibleWhenCanNotPopFromEmptyStack() {
        viewModel.popElement();
        assertEquals(false, viewModel.isPopButtonVisible());
    }
}

