package ru.unn.agile.queue.model;

import com.sun.javaws.exceptions.InvalidArgumentException;
import ru.unn.agile.queue.model.errorhandling.EmptyQueueException;

import java.util.LinkedList;
import java.util.List;

public final class Queue {

    private List<Integer> container;

    public Queue() {
        container = new LinkedList<>();
    }

    public void push(Integer element) {
        if( element == null )
            throw new IllegalArgumentException("Element should be initialized");

        container.add(element);
    }

    public Integer pop() {
        checkNotEmpty();

        return container.remove(0);
    }

    public Integer getHead() {
        checkNotEmpty();

        return container.get(0);
    }

    public Integer getTail() {
        checkNotEmpty();

        return container.get(container.size() - 1);
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
    }
}
