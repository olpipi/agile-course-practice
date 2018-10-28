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
        int firstValueInterval = 0;
        int lastValueInterval = 3;

        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);
        expectedArray.add(3);

        List<Integer> actualArray =
                PrimeNumber.findPrimeNumbers(firstValueInterval, lastValueInterval);

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
}
