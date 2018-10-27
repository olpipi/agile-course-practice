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

    @Test
    public void canCalculateMeanWithNegotiveNumbers() {
        Number[] data = {-3, 8.3, 86.2, -3.5};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(22.0), mean);
    }

    @Test
    public void canCalculateNegotiveMean() {
        Double[] data = {-10.2, 4.3, 0.0, -31.9, 3.0, 0.33};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(-5.745), mean);
    }

    @Test
    public void canCalculateMeanWithBigSizeofDataArray() {
        Integer[] data = new Integer[1000];
        for(int i=0; i<data.length; i++) {
            data[i] = i;
        }
        Double expected = new Double((0+999)/2.0);

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(expected, mean);
    }


}
