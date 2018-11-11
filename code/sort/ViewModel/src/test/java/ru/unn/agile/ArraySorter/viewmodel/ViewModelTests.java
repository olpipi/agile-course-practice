package ru.unn.agile.ArraySorter.viewmodel;

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
    }

    @Test
    public void canAddOneElementToArray() {
        viewModel.setNewElem("3");
        viewModel.Add();

        assertEquals("[3.0]", viewModel.getOutputArray());
    }

    @Test
    public void canAddSeveralElementsToArray() {
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

        assertEquals("[6.0, 4.0, 1.0, 10.0, 8.0]", viewModel.getOutputArray());
    }
}
