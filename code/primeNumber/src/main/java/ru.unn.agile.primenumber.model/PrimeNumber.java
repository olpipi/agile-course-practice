package ru.unn.agile.primenumber.model;

import java.util.ArrayList;
import java.util.List;

public final class PrimeNumber {

    private PrimeNumber() {

    }

    public static List<Integer> findPrimeNumbers(final int firstValueInterval,
                                                 final int lastValueInterval) {
        List<Integer> primeNumbersArray = new ArrayList<>();

            for (int i = 2; i <= lastValueInterval; i++) {
                if (i == 2) {
                    primeNumbersArray.add(i);
                }

                if (i % 2 != 0) {
                    primeNumbersArray.add(i);
                }
            }

        return primeNumbersArray;
    }
}
