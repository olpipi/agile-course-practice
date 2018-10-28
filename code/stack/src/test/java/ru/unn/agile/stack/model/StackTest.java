package ru.unn.agile.stack.model;

import org.junit.Test;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void canNotPopElementFromEmptyStack() {
        Stack<Object> stack = new Stack<>();

        stack.pop();
    }

    @Test
    public void canPopElementFromNotEmptyStack() {
        Object expected = new Object();
        Stack<Object> stack = new Stack<>();
        stack.push(expected);

        Object actual = stack.pop();

        assertEquals(expected, actual);
    }

}
