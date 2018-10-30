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
        Integer expectedElement = 1;

        q.push(expectedElement);

        assertEquals(expectedElement, q.getTail());
    }

    @Test
    public void canPopIntegerElementFromQueue() {
        Queue q = new Queue();
        Integer expectedElement = 1;
        q.push(expectedElement);

        Integer actualElement = q.pop();

        assertEquals(expectedElement, actualElement);
    }

    @Test
    public void isQueueWithoutIntegerElementsEmptiness() {
        Queue q = new Queue();

        assertTrue(q.isEmpty());
    }

    @Test
    public void isQueueWithOneIntegerElementNotEmpty() {
        Queue q = new Queue();
        q.push(1);

        assertFalse(q.isEmpty());
    }
}
