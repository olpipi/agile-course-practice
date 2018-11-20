package ru.unn.agile.triangle.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
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
    public void initViewModelWithDefaultValues() {
        assertEquals("", viewModel.aXProperty().get());
        assertEquals("", viewModel.bXProperty().get());
        assertEquals("", viewModel.cXProperty().get());
        assertEquals("", viewModel.aYProperty().get());
        assertEquals("", viewModel.bYProperty().get());
        assertEquals("", viewModel.cYProperty().get());
    }
}
