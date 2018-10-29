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

    public static List<Integer> findPrimeNumbersInInterval(final double startInterval,
                                                           final double endInterval) {

        if (endInterval < startInterval) {
            throw new IllegalArgumentException("Last value must be more or equal to first value!");
        }

        List<Integer> primeNumbersArray = new ArrayList<>();

        int finalstartOfInterval = (int) Math.ceil(startInterval);

        for (int i = finalstartOfInterval; i <= (int) endInterval; i++) {
            if (isPrimeNumber(i)) {
                primeNumbersArray.add(i);
            }
        }

        return primeNumbersArray;
    }
}
