package ru.unn.agile.queue.model;

import org.junit.Test;
import static org.junit.Assert.*;


public final class QueueTest {
    @Test
    public void canCreateQueue() {
        Queue q = new Queue();

        assertNotEquals(null, q);
    }

    @Test
    public void canPushIntegerElementToQueue() {
        Queue q = new Queue();
        Integer expectedValue = 1;

        q.push(expectedValue);

        assertEquals(expectedValue, q.getTail());
    }
}
