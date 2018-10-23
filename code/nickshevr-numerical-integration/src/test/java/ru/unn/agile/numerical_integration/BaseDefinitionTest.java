package ru.unn.agile.numerical_integration;

import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class BaseDefinitionTest {
    private final double delta = 0.001;
    private Expression cube = x -> Math.pow(x, 3);
    private final Class mainClass = BaseDefinition.class;
    private final String defaultMessage = "Don't make instance";

    @Test
    public void shouldBeFinal() {
        assertTrue("BaseDefinition should be final", Modifier.isFinal(mainClass.getModifiers()));
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
    public void calculateCubeRight() {
        double result = BaseDefinition.calculate(cube, 0, 1, 0.01);

        assertEquals(result, 0.25, delta);
    }

    @Test
    public void returnZero() {
        double result = BaseDefinition.calculate(cube, 0, 0, 0.01);

        assertEquals(result, 0, delta);
    }

    @Test(expected = RuntimeException.class)
    public void dxIsNegative() {
        BaseDefinition.calculate(cube, 0, 1, -0.01);
    }
}
