package ru.unn.agile.dijkstra.mview;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FakeViewTest {

    @Ignore @Test
    public void fakeTest() {
        fail("No tests for mview");
    }

    @Test
    public void fakeTestView() {
        DijkstraView viewModel = new DijkstraView();
        assertEquals(viewModel.getClass(), viewModel.getClass());
    }
}
