package ru.unn.agile.mathstatistics.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathStatisticsTest {

    @Test
    public void canCalculateMeanWithOneNumbers() {
        Integer[] data = {10};

        Double mean = MathStatistics.MeanCalculate(data);

        assertEquals(new Double(10), mean);
    }

    @Test
    public void canCalculateMeanWithOneNegotiveInteger() {
        Integer[] data = {-23};

        Double mean = MathStatistics.MeanCalculate(data);

        assertEquals(new Double(-23), mean);
    }

    @Test
    public void canCalculateMeanPositiveIntegers() {
        Integer[] data = {10, 5, 25, 30};

        Double mean = MathStatistics.MeanCalculate(data);

        assertEquals(new Double(17.5), mean);
    }


}
