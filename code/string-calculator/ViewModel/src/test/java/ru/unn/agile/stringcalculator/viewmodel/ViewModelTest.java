package ru.unn.agile.stringcalculator.viewmodel;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

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


}
