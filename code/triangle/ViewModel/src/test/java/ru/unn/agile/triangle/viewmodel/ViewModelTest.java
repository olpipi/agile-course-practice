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

    @Test
    public void canGetPerimeter() {
        viewModel.aXProperty().set("0.0");
        viewModel.aYProperty().set("0.0");
        viewModel.bXProperty().set("3.0");
        viewModel.bYProperty().set("0.0");
        viewModel.cXProperty().set("3.0");
        viewModel.cYProperty().set("4.0");

        viewModel.perimeter();

        assertEquals("12.0", viewModel.getResult());
    }
}
