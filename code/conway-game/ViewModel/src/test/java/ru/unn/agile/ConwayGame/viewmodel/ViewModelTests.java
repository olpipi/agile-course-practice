package ru.unn.agile.ConwayGame.viewmodel;

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
        assertEquals("", viewModel.rowsCountProperty().get());
        assertEquals("", viewModel.columnsCountProperty().get());
//        here check table
        assertEquals("Input:", viewModel.inputProperty().get());
        assertEquals("Output:", viewModel.outputProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());

    }
}
