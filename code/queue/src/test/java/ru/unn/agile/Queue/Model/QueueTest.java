package ru.unn.agile.queue.model;

import ru.unn.agile.queue.model.errorhandling.EmptyQueueException;

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

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenPushNullElementToQueue() {
        Queue q = new Queue();

        q.push(null);
    }

    @Test
    public void canPopIntegerElementFromQueue() {
        Queue q = new Queue();
        Integer expectedElement = 1;
        q.push(expectedElement);

        Integer actualElement = q.pop();

        assertEquals(expectedElement, actualElement);
    }

    @Test(expected = EmptyQueueException.class)
    public void throwWhenPopFromEmptyQueue() {
        Queue q = new Queue();

        Integer actualElement = q.pop();
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
