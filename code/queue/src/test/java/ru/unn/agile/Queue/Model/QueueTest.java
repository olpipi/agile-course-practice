package ru.unn.agile.queue.model;

import org.junit.Test;
import static org.junit.Assert.*;


public final class QueueTest {
    @Test
    public void canCreateQueue() {
        Queue q = new Queue();

        assertNotEquals(null, q);
    }
}
