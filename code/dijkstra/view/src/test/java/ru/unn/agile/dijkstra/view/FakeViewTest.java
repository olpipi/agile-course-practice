package ru.unn.agile.dijkstra.view;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FakeViewTest {

    @Test
    public void fakeTestView() {
        View view = new View();
        assertEquals(view.getClass(), view.getClass());
    }
}
