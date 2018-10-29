package ru.unn.agile.primenumber.model;

import java.util.ArrayList;
import java.util.List;

public final class PrimeNumber {

    private PrimeNumber() {

    }

    private static boolean isPrimeNumber(final int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> findPrimeNumbers(final double firstValueInterval,
                                                 final double lastValueInterval) {

        if (lastValueInterval < firstValueInterval) {
            throw new IllegalArgumentException("Last value must be more or equal to first value!");
        }

        List<Integer> primeNumbersArray = new ArrayList<>();

        int finalFirstValueInterval = (int) Math.ceil(firstValueInterval);

        for (int i = finalFirstValueInterval; i <= (int) lastValueInterval; i++) {
            if (isPrimeNumber(i)) {
                primeNumbersArray.add(i);
            }
        }

        return primeNumbersArray;
    }
}
