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
        assertEquals("", viewModel.getNewElem());
        assertEquals("", viewModel.getOutputArray());
        assertEquals(Status.WAITING, viewModel.getCurrentState());
    }

    @Test
    public void canAddOneElementToArray() {
        viewModel.setNewElem("3.0");
        viewModel.Add();

        assertEquals("[3.0]", viewModel.getOutputArray());
    }

    @Test
    public void canAddSeveralElementsToArray() {
        viewModel.setNewElem("-5.0");
        viewModel.Add();
        viewModel.setNewElem("4.0");
        viewModel.Add();
        viewModel.setNewElem("2.75");
        viewModel.Add();
        viewModel.setNewElem("10.1");
        viewModel.Add();
        viewModel.setNewElem("0.02");
        viewModel.Add();

        assertEquals("[-5.0, 4.0, 2.75, 10.1, 0.02]", viewModel.getOutputArray());
    }

    @Test
    public void canClearArray() {
        viewModel.setNewElem("6");
        viewModel.Add();
        viewModel.setNewElem("4");
        viewModel.Add();
        viewModel.setNewElem("1");
        viewModel.Add();
        viewModel.setNewElem("10");
        viewModel.Add();
        viewModel.setNewElem("8");
        viewModel.Add();

        viewModel.Clear();

        assertEquals("[]", viewModel.getOutputArray());
    }

    @Test
    public void  canSortOfArrayWithOneElement() {
        viewModel.setNewElem("-4.0");
        viewModel.Add();

        viewModel.Sort();

        assertEquals("[-4.0]", viewModel.getOutputArray());
    }

    @Test
    public void  canSortOfNonSortedBigArray() {
        viewModel.setNewElem("-4.0");
        viewModel.Add();
        viewModel.setNewElem("28.1");
        viewModel.Add();
        viewModel.setNewElem("13");
        viewModel.Add();
        viewModel.setNewElem("-0.4");
        viewModel.Add();
        viewModel.setNewElem("15.2");
        viewModel.Add();
        viewModel.setNewElem("3.1");
        viewModel.Add();
        viewModel.setNewElem("10.2");
        viewModel.Add();

        viewModel.Sort();

        assertEquals("[-4.0, -0.4, 3.1, 10.2, 13.0, 15.2, 28.1]", viewModel.getOutputArray());
    }

    @Test
    public void  isWaitingStatusWhenLaunch() { assertEquals(Status.WAITING, viewModel.getCurrentState()); }


}
