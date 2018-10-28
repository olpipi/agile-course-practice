package ru.unn.agile.primenumber.model;

import java.util.ArrayList;
import java.util.List;

public final class PrimeNumber {

    private PrimeNumber() {

    }

    public static boolean isPrimeNumber(final int number) {
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

    public static List<Integer> findPrimeNumbers(final int firstValueInterval,
                                                 final int lastValueInterval) {

        if (lastValueInterval < firstValueInterval ) {
            throw new IllegalArgumentException("Enter the correct value!");
        }


        List<Integer> primeNumbersArray = new ArrayList<>();

        for (int i = firstValueInterval; i <= lastValueInterval; i++) {
            if (isPrimeNumber(i)) {
                primeNumbersArray.add(i);
            }
        }

        return primeNumbersArray;
    }
}
