package ru.unn.agile.queue.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals("", viewModel.getNewElem());
    }

    @Test
    public void canAddOneElemToQueue() {
        viewModel.setNewElem("5.43");
        viewModel.Add();

        assertEquals("[5.43]", viewModel.getOutputQueue());
    }


    @Test
    public void canAddQueue() {
        viewModel.setNewElem("1.0");
        viewModel.Add();
        viewModel.setNewElem("3.0");
        viewModel.Add();
        viewModel.setNewElem("4.0");
        viewModel.Add();
        viewModel.setNewElem("8.0");
        viewModel.Add();

        assertEquals("[1.0, 3.0, 4.0, 8.0]", viewModel.getOutputQueue());
    }

}
