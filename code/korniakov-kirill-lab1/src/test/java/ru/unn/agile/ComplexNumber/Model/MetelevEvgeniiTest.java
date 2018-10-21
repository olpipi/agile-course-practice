package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetelevEvgeniiTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ru.unn.agile.complexnumber.model.ComplexNumber z1 =
                new ru.unn.agile.complexnumber.model.ComplexNumber(4, 0);
        ru.unn.agile.complexnumber.model.ComplexNumber z2 =
                new ru.unn.agile.complexnumber.model.ComplexNumber(0, 4);

        // Act
        ru.unn.agile.complexnumber.model.ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ru.unn.agile.complexnumber.model.ComplexNumber(4, 4), z);
    }
}
