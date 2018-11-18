package ru.unn.agile.ArraySorter.viewmodel;

import ru.unn.agile.ArraySorter.viewmodel.ViewModel.Status;

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
        assertEquals("", viewModel.getElemArray());
        assertEquals("", viewModel.getOutputArray());
        assertEquals(Status.WAITING, viewModel.getCurrentState());
    }

    @Test
    public void canAddOneElementToArray() {
        viewModel.setElemArray("3.0");
        viewModel.Add();

        assertEquals("[3.0]", viewModel.getOutputArray());
    }

    @Test
    public void canAddSeveralElementsToArray() {
        viewModel.setElemArray("-5.0");
        viewModel.Add();
        viewModel.setElemArray("4.0");
        viewModel.Add();
        viewModel.setElemArray("2.75");
        viewModel.Add();
        viewModel.setElemArray("10.1");
        viewModel.Add();
        viewModel.setElemArray("0.02");
        viewModel.Add();

        assertEquals("[-5.0, 4.0, 2.75, 10.1, 0.02]", viewModel.getOutputArray());
    }

    @Test
    public void canClearArray() {
        viewModel.setElemArray("6");
        viewModel.Add();
        viewModel.setElemArray("4");
        viewModel.Add();
        viewModel.setElemArray("1");
        viewModel.Add();
        viewModel.setElemArray("10");
        viewModel.Add();
        viewModel.setElemArray("8");
        viewModel.Add();

        viewModel.Clear();

        assertEquals("[]", viewModel.getOutputArray());
    }

    @Test
    public void  canSortOfArrayWithOneElement() {
        viewModel.setElemArray("-4.0");
        viewModel.Add();

        viewModel.Sort();

        assertEquals("[-4.0]", viewModel.getOutputArray());
    }

    @Test
    public void  canSortOfNonSortedBigArray() {
        viewModel.setElemArray("-4.0");
        viewModel.Add();
        viewModel.setElemArray("28.1");
        viewModel.Add();
        viewModel.setElemArray("13");
        viewModel.Add();
        viewModel.setElemArray("-0.4");
        viewModel.Add();
        viewModel.setElemArray("15.2");
        viewModel.Add();
        viewModel.setElemArray("3.1");
        viewModel.Add();
        viewModel.setElemArray("10.2");
        viewModel.Add();

        viewModel.Sort();

        assertEquals("[-4.0, -0.4, 3.1, 10.2, 13.0, 15.2, 28.1]", viewModel.getOutputArray());
    }

    @Test
    public void  isWaitingStatusWhenLaunch() { assertEquals(Status.WAITING, viewModel.getCurrentState()); }

    @Test
    public void isWaitingStatWhenBeginning() {
        assertEquals(ViewModel.Status.WAITING, viewModel.getCurrentState());
    }

    @Test
    public void isWaitingStateWhenAddAndDelElemEmptyField() {
        viewModel.setElemArray("");

        viewModel.processingAddField(1);

        assertEquals(Status.WAITING, viewModel.getCurrentState());
    }

    @Test
    public void isReadyStateWhenAddElemFieldIsWriteIn() {
        viewModel.setElemArray("6.1");

        viewModel.processingAddField(1);

        assertEquals(Status.READY, viewModel.getCurrentState());
    }

    @Test
    public void canSetBadFormatMessage() {
        viewModel.setElemArray("b");

        viewModel.processingAddField(1);

        assertEquals(Status.BAD_FORMAT, viewModel.getCurrentState());
    }

    @Test
    public void canSetSuccessMessage() {
        viewModel.setElemArray("-1.0");
        viewModel.Add();
        viewModel.setElemArray("2.0");
        viewModel.Add();
        viewModel.setElemArray("5.4");

        viewModel.Sort();

        assertEquals(Status.SUCCESSFUL, viewModel.getCurrentState());
    }

    @Test
    public void isAddButtonDisabledWhenLaunch() {
        assertEquals(false, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isClearButtonDisabledWhenLaunch() {
        assertEquals(false, viewModel.isClearButtonEnabled());
    }

    @Test
    public void isSortButtonDisabledWhenLaunch() {
        assertEquals(false, viewModel.isSortButtonEnabled());
    }

    @Test
    public void isAddButtonEnabledAddElemFieldIsCorrect() {
        viewModel.setElemArray("1.2");
        viewModel.processingAddField(1);

        assertEquals(true, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isAddButtonDisabledWhenAddElemFieldIsEmpty() {
        viewModel.setElemArray("");
        viewModel.processingAddField(1);

        assertEquals(false, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isAddButtonDisabledWhenAddElemIsInvalid() {
        viewModel.setElemArray("ijijfdf");
        viewModel.processingAddField(1);

        assertEquals(false, viewModel.isAddButtonEnabled());
    }

    @Test
    public void isClearButtonEnabledWhenArrayIsNotEmpty() {
        viewModel.setElemArray("2");
        viewModel.Add();
        viewModel.setElemArray("9");
        viewModel.Add();

        assertEquals(true, viewModel.isClearButtonEnabled());
    }

    @Test
    public void isSortButtonEnabledWhenArrayIsNotEmpty() {
        viewModel.setElemArray("8");
        viewModel.Add();
        viewModel.setElemArray("4");
        viewModel.Add();

        assertEquals(true, viewModel.isSortButtonEnabled());
    }
    @Test
    public void canClearDisableClearButton() {
        viewModel.setElemArray("1");
        viewModel.Add();
        viewModel.setElemArray("8");
        viewModel.Add();
        viewModel.setElemArray("4");
        viewModel.Add();

        viewModel.Clear();

        assertEquals(false, viewModel.isClearButtonEnabled());
    }

    @Test
    public void canClearDisableSortButton() {
        viewModel.setElemArray("8");
        viewModel.Add();
        viewModel.setElemArray("2");
        viewModel.Add();
        viewModel.setElemArray("1");
        viewModel.Add();
        viewModel.setElemArray("5");
        viewModel.Add();

        viewModel.Clear();

        assertEquals(false, viewModel.isSortButtonEnabled());
    }

    @Test
    public void isClearButtonAddOneElementEnabled() {
        viewModel.setElemArray("2");
        viewModel.Add();

        viewModel.Sort();

        assertEquals(true, viewModel.isClearButtonEnabled());
    }
}
