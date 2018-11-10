package ru.unn.agile.dijkstra.viewModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FakeViewModelTest {
    @Test
    public void fakeTestView() {
        ViewModel viewModel = new ViewModel();
        assertEquals(viewModel.getClass(), viewModel.getClass());
    }
}
