package ru.unn.agile.queue.model;

import ru.unn.agile.queue.model.errorhandling.EmptyQueueException;

import java.util.LinkedList;
import java.util.List;

public final class Queue {

    private List<Integer> container;

    public Queue() {
        container = new LinkedList<>();
    }

    public void push(Integer element) {
        container.add(element);
    }

    public Integer pop() {
        if (isEmpty())
            throw new EmptyQueueException("Queue is empty");

        return container.get(0);
    }

    public Integer getTail() {
        return 1;
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }
}
