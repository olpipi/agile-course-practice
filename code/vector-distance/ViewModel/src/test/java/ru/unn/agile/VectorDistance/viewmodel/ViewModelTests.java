package ru.unn.agile.VectorDistance.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;

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
        fail();
    }

    @Test
    public void canSetL1DistanceCalculation() {
        viewModel.distanceProperty().set(Distance.L1);
        assertEquals(Distance.L1, viewModel.distanceProperty().get());
    }



}
