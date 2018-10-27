package ru.unn.agile.mathstatistics.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathStatisticsTest {

    @Test
    public void canCalculateMeanWithOneNumbers() {
        Integer[] data = {10};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(10), mean);
    }

    @Test
    public void canCalculateMeanWithOneNegotiveInteger() {
        Integer[] data = {-23};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(-23), mean);
    }

    @Test
    public void canCalculateMeanPositiveIntegers() {
        Integer[] data = {10, 5, 25, 30};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(17.5), mean);
    }

    @Test
    public void canCalculateMeanWithDouble() {
        Double[] data = {1.2, 3.3, 0.2, 8.1, 0.9};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(2.74), mean);
    }

    @Test
    public void canCalculateMeanWithIntegersAndDouble() {
        Number[] data = {1.2, 3.3, 11, 2, 8.9, 2, 36, 7.3};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(8.9625), mean);
    }

}
