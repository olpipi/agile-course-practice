package ru.unn.agile.primenumber.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import java.util.List;

public final class PrimeNumberTest {

    @Test
    public void canReceiveOnePrimeValueFromIntervalZeroToTwo() {
        int firstValueInterval = 0;
        int lastValueInterval = 2;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveTwoPrimeValueFromIntervalZeroToThree() {
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);
        expectedArray.add(3);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(0, 3);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveThreePrimeValueFromIntervalZeroToFive() {
        int firstValueInterval = 0;
        int lastValueInterval = 5;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);
        expectedArray.add(3);
        expectedArray.add(5);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveFourPrimeValueFromIntervalZeroToNine() {
        int firstValueInterval = 0;
        int lastValueInterval = 9;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);
        expectedArray.add(3);
        expectedArray.add(5);
        expectedArray.add(7);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveFourPrimeValueFromIntervalFiveToFifteen() {
        int firstValueInterval = 5;
        int lastValueInterval = 15;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(5);
        expectedArray.add(7);
        expectedArray.add(11);
        expectedArray.add(13);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveTwoPrimeValueFromIntervalMinusFiveToThree() {
        int firstValueInterval = -5;
        int lastValueInterval = 3;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);
        expectedArray.add(3);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveTwoPrimeValueFromDoubleInterval() {
        double firstValueInterval = 4.2;
        double lastValueInterval = 7.6;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(5);
        expectedArray.add(7);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void canReceiveOnePrimeValueFromDoubleInterval() {
        double firstValueInterval = 5.2;
        double lastValueInterval = 7.6;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(7);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

        assertEquals(expectedArray, actualArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotReceivePrimeValueFromIncorrectInterval() {
        int firstValueInterval = 3;
        int lastValueInterval = -3;

        PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);
    }
}
