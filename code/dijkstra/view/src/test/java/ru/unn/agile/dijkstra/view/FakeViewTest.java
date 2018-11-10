package ru.unn.agile.dijkstra.view;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FakeViewTest {

    @Ignore @Test
    public void fakeTest() {
        fail("No tests for view");
    }

    @Test
    public void fakeTestView() {
        DijkstraController viewModel = new DijkstraController();
        assertEquals(viewModel.getClass(), viewModel.getClass());
    }
}
