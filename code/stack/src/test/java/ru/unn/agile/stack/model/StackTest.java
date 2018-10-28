package ru.unn.agile.stack.model;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void canCreateStack() {
        Stack<Object> stack = new Stack<>();

        assertTrue(stack.empty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotPushNullToStack() {
        Stack<Object> stack = new Stack<>();

        stack.push(null);
    }

    @Test
    public void canPushObjectToStack() {
        Object expected = new Object();
        Stack<Object> stack = new Stack<>();

        Object actual = stack.push(expected);

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyStackException.class)
    public void canNotPopFromEmptyStack() {
        Stack<Object> stack = new Stack<>();

        stack.pop();
    }

    @Test
    public void canPopFromNotEmptyStack() {
        Object expected = new Object();
        Stack<Object> stack = new Stack<>();
        stack.push(expected);

        Object actual = stack.pop();

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyStackException.class)
    public void canNotPeekFromEmptyStack() {
        Stack<Object> stack = new Stack<>();

        stack.peek();
    }

    @Test
    public void canPeekFromNotEmptyStack() {
        Object expected = new Object();
        Stack<Object> stack = new Stack<>();
        stack.push(expected);

        Object actual = stack.peek();

        assertEquals(expected, actual);
    }

}
