package ru.unn.agile.segment2d.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void createViewModel() {
        viewModel = new ViewModel();
    }

    @After
    public void deleteViewModel() {
        viewModel = null;
    }

    @Test
    public void initViewModelWithDefaultValues() {
        assertEquals("", viewModel.getFirstSegmentFirstPointCoordX());
        assertEquals("", viewModel.getFirstSegmentFirstPointCoordY());
        assertEquals("", viewModel.getFirstSegmentSecondPointCoordX());
        assertEquals("", viewModel.getFirstSegmentSecondPointCoordY());
        assertEquals("", viewModel.getSecondSegmentFirstPointCoordX());
        assertEquals("", viewModel.getSecondSegmentFirstPointCoordY());
        assertEquals("", viewModel.getSecondSegmentSecondPointCoordX());
        assertEquals("", viewModel.getSecondSegmentSecondPointCoordY());
        assertEquals("", viewModel.getFirstSegmentStatus());
        assertEquals("", viewModel.getSecondSegmentStatus());
        assertEquals("", viewModel.getResult());
    }
}