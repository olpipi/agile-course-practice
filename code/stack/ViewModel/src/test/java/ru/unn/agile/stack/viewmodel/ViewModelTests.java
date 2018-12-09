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
        viewModel.setAddingElem("1");
        viewModel.addElement();

        assertEquals("Stack is not empty", viewModel.getStackIsEmptyStatus());
        assertEquals("1", viewModel.getStackSize());
        assertEquals("1.0", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("1", viewModel.getAddingElement());
    }

    @Test
    public void isReadyToAddStatusWhenAddNewElement() {
        viewModel.setAddingElem("11");
        viewModel.addElement();
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void isPopButtonIsVisibleAfterAddingElement() {
        viewModel.setAddingElem("105");
        viewModel.addElement();
        assertEquals(true, viewModel.isPopButtonVisible());
    }

    @Test
    public void doNotAddNonValidElement() {
        viewModel.setAddingElem("abc");
        viewModel.addElement();

        assertEquals("Stack is empty", viewModel.getStackIsEmptyStatus());
        assertEquals("0", viewModel.getStackSize());
        assertEquals("None", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("abc", viewModel.getAddingElement());
    }

    @Test
    public void isInvalidFormatStatusWhenAddInvalidElement() {
        viewModel.setAddingElem("abc");
        viewModel.addElement();
        assertEquals(ViewModel.Status.INVALID_FORMAT, viewModel.getStatusMessage());
    }

    @Test
    public void isPopIsNotVisibleWhenAddInvalidElement() {
        viewModel.setAddingElem("dc");
        viewModel.addElement();
        assertEquals(false, viewModel.isPopButtonVisible());
    }

    @Test
    public void canAddFewElements() {
        viewModel.setAddingElem("1");
        viewModel.addElement();
        viewModel.setAddingElem("2");
        viewModel.addElement();
        viewModel.setAddingElem("3.7");
        viewModel.addElement();
        viewModel.setAddingElem("-4.9");
        viewModel.addElement();
        viewModel.setAddingElem("5.95");
        viewModel.addElement();

        assertEquals("Stack is not empty", viewModel.getStackIsEmptyStatus());
        assertEquals("5", viewModel.getStackSize());
        assertEquals("5.95", viewModel.getStackTopElement());
        assertEquals("None", viewModel.getStackPopElement());
        assertEquals("5.95", viewModel.getAddingElement());
    }

    @Test
    public void isReadyToAddStatusWhenAddFewElement() {
        viewModel.setAddingElem("-18");
        viewModel.addElement();
        viewModel.setAddingElem("38");
        viewModel.addElement();
        viewModel.setAddingElem("24.5");
        viewModel.addElement();
        viewModel.setAddingElem("-28.59");
        viewModel.addElement();
        viewModel.setAddingElem("21");
        viewModel.addElement();
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void isPopButtonIsVisibleAfterAddingFewElement() {
        viewModel.setAddingElem("-61");
        viewModel.addElement();
        viewModel.setAddingElem("41");
        viewModel.addElement();
        viewModel.setAddingElem("36.6");
        viewModel.addElement();
        viewModel.setAddingElem("-28.3");
        viewModel.addElement();
        viewModel.setAddingElem("28");
        viewModel.addElement();
        assertEquals(true, viewModel.isPopButtonVisible());
    }

    @Test
    public void canAddAndPopElement() {
        viewModel.setAddingElem("1");
        viewModel.addElement();
        viewModel.popElement();

        assertEquals("Stack is empty", viewModel.getStackIsEmptyStatus());
        assertEquals("0", viewModel.getStackSize());
        assertEquals("None", viewModel.getStackTopElement());
        assertEquals("1.0", viewModel.getStackPopElement());
        assertEquals("1", viewModel.getAddingElement());
    }

    @Test
    public void isPopButtonIsNotVisibleAfterAddAndPopElement() {
        viewModel.setAddingElem("-1");
        viewModel.addElement();
        viewModel.popElement();
        assertEquals(false, viewModel.isPopButtonVisible());
    }

    @Test
    public void isReadyToAddStatusAfterAddAndPopElement() {
        viewModel.setAddingElem("11");
        viewModel.addElement();
        viewModel.popElement();
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
    }

    @Test
    public void canAddAndPopElementFewTim() {
        viewModel.setAddingElem("1");
        viewModel.addElement();
        viewModel.popElement();
        viewModel.setAddingElem("-53.7");
        viewModel.addElement();
        viewModel.setAddingElem("11");
        viewModel.addElement();
        viewModel.setAddingElem("65.8");
        viewModel.addElement();
        viewModel.setAddingElem("100");
        viewModel.addElement();
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
        viewModel.setAddingElem("231");
        viewModel.addElement();
        viewModel.popElement();
        viewModel.setAddingElem("37");
        viewModel.addElement();
        viewModel.setAddingElem("1324");
        viewModel.addElement();
        assertEquals(true, viewModel.isPopButtonVisible());
    }

    @Test
    public void isReadyToAddStatusAfterAddAndPopElementFewTimes() {
        viewModel.setAddingElem("11");
        viewModel.addElement();
        viewModel.popElement();
        viewModel.setAddingElem("31");
        viewModel.addElement();
        viewModel.setAddingElem("1");
        viewModel.addElement();
        viewModel.setAddingElem("352");
        viewModel.addElement();
        viewModel.setAddingElem("452");
        viewModel.addElement();
        viewModel.popElement();
        viewModel.popElement();
        assertEquals(ViewModel.Status.READY_TO_ADD, viewModel.getStatusMessage());
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
