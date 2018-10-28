package ru.unn.agile.stack.model;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public E push(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Element must not be null");
        }

        list.add(item);
        return item;
    }

    public synchronized E pop() {
        int size = list.size();

        if (size < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        return list.remove(size - 1);
    }

}
