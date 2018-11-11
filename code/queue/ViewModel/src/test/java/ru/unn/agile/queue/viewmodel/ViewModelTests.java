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


}
