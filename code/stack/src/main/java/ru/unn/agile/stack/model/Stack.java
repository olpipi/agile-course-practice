package ru.unn.agile.stack.model;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list;

    public Stack() {
        list = new ArrayList<E>();
    }

    public boolean empty() {
        return list.size() == 0;
    }
}
