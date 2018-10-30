package ru.unn.agile.queue.model;


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
        return 1;
    }

    public Integer getTail() {
        return 1;
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }
}
