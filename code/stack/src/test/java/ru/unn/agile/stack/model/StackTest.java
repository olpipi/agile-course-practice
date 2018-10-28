package ru.unn.agile.stack.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void canCreateStack() {
        Stack stack = new Stack<Integer>();

        assertTrue(stack.empty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotPushNullToStack() {
        Stack stack = new Stack<Integer>();

        stack.push(null);
    }

    @Test
    public void canPushObjectToStack() {
        Object expected = new Object();
        Stack stack = new Stack<Integer>();

        Object actual = stack.push(expected);

        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canNotPopElementFromEmptyStack() {
        Stack stack = new Stack<Integer>();

        stack.pop();
    }

    @Test
    public void canPopElementFromNotEmptyStack() {
        Object expected = new Object();
        Stack stack = new Stack<Integer>();
        stack.push(expected);

        Object actual = stack.pop();

        assertEquals(expected, actual);
    }

}