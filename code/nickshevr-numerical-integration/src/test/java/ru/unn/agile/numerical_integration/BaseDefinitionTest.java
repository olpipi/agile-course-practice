package ru.unn.agile.numerical_integration;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDefinitionTest {
    private final double delta = 0.001;
    private Expression cube = x -> Math.pow(x, 3);
    private final Class mainClass = BaseDefinition.class;
    private final String defaultMessage = "Don't make instance";

    @Test
    public void shouldBeFinal() {
        UtilityClassTest.testForFinal(mainClass);
    }

    @Test
    public void shouldHaveOneConstructor() {
        UtilityClassTest.shouldHaveOneConstructor(mainClass);
    }

    @Test
    public void constructorShouldBePrivate()
            throws IllegalArgumentException, NoSuchMethodException {
        UtilityClassTest.constructorShouldBePrivate(mainClass);
    }

    @Test
    public void constructorShouldThrowError()
            throws IllegalArgumentException, NoSuchMethodException {
        UtilityClassTest.constructWithExeption(mainClass, defaultMessage);
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

    @Test(expected = IllegalArgumentException.class)
    public void dxIsNegative() {
        BaseDefinition.calculate(cube, 0, 1, -0.01);
    }
}
