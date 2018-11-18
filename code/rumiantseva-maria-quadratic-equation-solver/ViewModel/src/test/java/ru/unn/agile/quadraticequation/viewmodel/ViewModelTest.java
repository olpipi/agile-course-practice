package ru.unn.agile.quadraticequation.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTest {

    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @Test
    public void canInitializeViewModel() {
        assertEquals("0", viewModel.aProperty().get());
        assertEquals("0", viewModel.bProperty().get());
        assertEquals("0", viewModel.cProperty().get());
        assertEquals("", viewModel.rootsProperty().get());
    }

    @Test
    public void canSolve() {
        viewModel.aProperty().set("4");
        viewModel.bProperty().set("1");
        viewModel.cProperty().set("0");

        viewModel.solve();

        assertEquals("[-0.25, 0.0]", viewModel.rootsProperty().get());
    }

    @Test
    public void canSolveWitOneRoot() {
        viewModel.aProperty().set("1");
        viewModel.bProperty().set("2");
        viewModel.cProperty().set("1");

        viewModel.solve();

        assertEquals("[-1.0, -1.0]", viewModel.rootsProperty().get());
    }

    @Test
    public void canSolveWithoutRoots() {
        viewModel.aProperty().set("1");
        viewModel.bProperty().set("1");
        viewModel.cProperty().set("1");

        viewModel.solve();

        assertEquals("No roots", viewModel.rootsProperty().get());
    }
}
