package ru.unn.agile.stack.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void canCreateEmptyStack() {
        Stack stack = new Stack<Integer>();

        assertTrue(stack.empty());
    }
}