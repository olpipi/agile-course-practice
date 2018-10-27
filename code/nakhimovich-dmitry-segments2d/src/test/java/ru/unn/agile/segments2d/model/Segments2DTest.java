package ru.unn.agile.segments2d.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class Segments2DTest {

    @Test
    public void canCreateSegments2DTestWithCorrectParams() {
        Segments2D segment = new Segments2D(0.0, 0.0, 1.0, 1.0);

        assertNotNull(segment);
    }

}
