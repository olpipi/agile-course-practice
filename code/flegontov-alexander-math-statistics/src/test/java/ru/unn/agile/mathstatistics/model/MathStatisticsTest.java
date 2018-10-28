package ru.unn.agile.mathstatistics.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathStatisticsTest {

    @Test
    public void canCalculateMeanWithOneNumbers() {
        Integer[] data = {10};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(10), mean);
    }

    @Test
    public void canCalculateMeanWithOneNegativeInteger() {
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
    public void canCalculateMeanWithNegativeNumbers() {
        Number[] data = {-3, 8.3, 86.2, -3.5};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(22.0), mean);
    }

    @Test
    public void canCalculateNegativeMean() {
        Double[] data = {-10.2, 4.3, 0.0, -31.9, 3.0, 0.33};

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(new Double(-5.745), mean);
    }

    @Test
    public void canCalculateMeanWithBigSizeOfDataArray() {
        Integer[] data = getMonotonicArray(0, 1000);
        Double expected = new Double((0 + 999) / 2.0);

        Double mean = MathStatistics.meanCalculate(data);

        assertEquals(expected, mean);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMeanWithNullElement() {
        Number[] data = {1.2, 2, -5, null, 8, 7};

        MathStatistics.meanCalculate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMeanWithNullData() {
        Double[] data = null;

        MathStatistics.meanCalculate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMeanWithEmptyData() {
        Number[] data = {};

        MathStatistics.meanCalculate(data);
    }

    @Test
    public void canCalculateDispersionWithOneNumber() {
        Integer[] data = {8};

        Double dispersion = MathStatistics.dispersionCalculate(data);

        assertEquals(new Double(0), dispersion);
    }

    @Test
    public void canCalculateDispersionWithOneNegativeNumber() {
        Integer[] data = {-23};

        Double dispersion = MathStatistics.dispersionCalculate(data);

        assertEquals(new Double(0), dispersion);
    }

    @Test
    public void canCalculateDispersionWithNegativeNumbers() {
        Number[] data = {9, 3, -1, 9, -8};

        Double dispersion = MathStatistics.dispersionCalculate(data);

        assertEquals(new Double(41.44), dispersion);
    }

    @Test
    public void canCalculateDispersionWithArrayOfZeros() {
        Number[] data = {0, 0, 0, 0};

        Double dispersion = MathStatistics.dispersionCalculate(data);

        assertEquals(new Double(0.0), dispersion);
    }

    @Test
    public void canCalculateDispersionWithDouble() {
        Number[] data = {7.2, 64.3, -13.8, 0.6, 23.1};

        Double dispersion = MathStatistics.dispersionCalculate(data);

        assertEquals(new Double(717.1096), dispersion);
    }

    @Test
    public void canCalculateDispersionWithBigSizeOfDataArray() {
        Integer[] data = getMonotonicArray(0, 1000);

        Double dispersion = MathStatistics.dispersionCalculate(data);

        assertEquals(new Double(83333.25), dispersion);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateDispersionWithNullElement() {
        Number[] data = {2, -3, 5, null, 1, 8};

        MathStatistics.dispersionCalculate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateDispersionWithNullData() {
        Double[] data = null;

        MathStatistics.dispersionCalculate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateDispersionWithEmptyData() {
        Number[] data = {};

        MathStatistics.dispersionCalculate(data);
    }

    @Test
    public void canCalculateMomentWithOneNumber() {
        Integer[] data = {3};

        Double moment = MathStatistics.momentCalculate(data, 3, 46);

        assertEquals(new Double(-79507.0), moment);
    }

    @Test
    public void canCalculateMomentWithOneNegativeNumber() {
        Integer[] data = {-11};

        Double moment = MathStatistics.momentCalculate(data, 1, 44);

        assertEquals(new Double(-55), moment);
    }

    @Test
    public void canCalculateMomentWithNegativeNumbers() {
        Number[] data = {9, 3, -1, 9, -8};

        Double moment = MathStatistics.momentCalculate(data, 6, 9);

        assertEquals(new Double(5036845.0), moment);
    }

    @Test
    public void canCalculateMomentWithArrayOfZeros() {
        Number[] data = {0, 0, 0, 0};

        Double moment = MathStatistics.momentCalculate(data, 5, 2);

        assertEquals(new Double(-32.0), moment);
    }

    @Test
    public void canCalculateMomentWithDouble() {
        Number[] data = {7.1, 6.3, 11.8, 0.8, 23.2};

        Double moment = MathStatistics.momentCalculate(data, 3, 3);

        assertEquals(new Double(1803.618), moment);
    }

    @Test
    public void canCalculateMomentWithBigSizeOfDataArray() {
        Integer[] data = getMonotonicArray(-400, 400);

        Double moment = MathStatistics.momentCalculate(data, 3, 1);

        assertEquals(new Double(-240003.0), moment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithNullElement() {
        Number[] data = {1, null, 7, 2, 2, 3};

        MathStatistics.momentCalculate(data,3,6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithNullData() {
        Double[] data = null;

        MathStatistics.momentCalculate(data, 1,2.8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithEmptyData() {
        Number[] data = {};

        MathStatistics.momentCalculate(data, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithZeroOrder() {
        Number[] data = {0.1, 9.3, 1.8, 0.8, 2.2};

        Double moment = MathStatistics.momentCalculate(data, 0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithNegativeOrder() {
        Number[] data = {0.1, 0.3, 6.8, -6.8, 2.2};

        Double moment = MathStatistics.momentCalculate(data, -5, 3);
    }

    private Integer[] getMonotonicArray(final int start, final int end) {
        Integer[] data = new Integer[end-start];
        for (int i = 0; i < data.length; ++i) {
            data[i] = start + i;
        }
        return data;
    }

}
