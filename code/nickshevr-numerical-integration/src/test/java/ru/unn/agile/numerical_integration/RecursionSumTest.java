package ru.unn.agile.numerical_integration;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RecursionSumTest {
    private final double delta = 0;

    private Expression step = x -> x + 1;
    private Expression square = x -> x * x;
    private Expression cube = x -> Math.pow(x, 3);
    private final Class mainClass = FpUtils.class;
    private final String defaultMessage = "Don't make instance";

    @Test
    public void shouldBeFinal() {
        assertTrue("FpUtils should be final", Modifier.isFinal(mainClass.getModifiers()));
    }

    @Test
    public void shouldHaveOneConstructor() {
        assertEquals("There must be only one constructor", 1,
                mainClass.getDeclaredConstructors().length);
    }

    @Test
    public void constructorShouldBePrivate() throws IllegalArgumentException, NoSuchMethodException {
        final Constructor<?> constructor = mainClass.getDeclaredConstructor();

        if (!Modifier.isPrivate(constructor.getModifiers())) {
            fail("constructor is not private");
        }
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldThrowError() throws IllegalArgumentException, NoSuchMethodException {
        final Constructor<?> constructor = mainClass.getDeclaredConstructor();

        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (Exception e) {
            assertEquals(e.getMessage(), defaultMessage);
        }

        constructor.setAccessible(false);
    }

    @Test
    public void shouldReturnZero() {
        double result = FpUtils.recursionSum(square, step, 0, 0);

        assertEquals(result, 0, delta);
    }

    @Test
    public void squareSum() {
        double result = FpUtils.recursionSum(square, step, 0, 2);

        assertEquals(result, 5, delta);
    }

    @Test
    public void cubeSum() {
        double result = FpUtils.recursionSum(cube, step, 0, 2);

        assertEquals(result, 9, delta);
    }
}
