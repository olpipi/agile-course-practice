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

    public static int checkWholePartOfFirstValueInterval(final double firstValueInterval) {
        int wholePartOfFirstValueInterval = (int) firstValueInterval;
        double fractionalPartOfFirstValueInterval =
                firstValueInterval - wholePartOfFirstValueInterval;
        if (fractionalPartOfFirstValueInterval > 0) {
            wholePartOfFirstValueInterval++;
        }

        return wholePartOfFirstValueInterval;
    }

    public static List<Integer> findPrimeNumbers(final double firstValueInterval,
                                                 final double lastValueInterval) {

        List<Integer> primeNumbersArray = new ArrayList<>();

        int finalFirstValueInterval = checkWholePartOfFirstValueInterval(firstValueInterval);

        for (int i = finalFirstValueInterval; i <= (int) lastValueInterval; i++) {
            if (isPrimeNumber(i)) {
                primeNumbersArray.add(i);
            }
        }

        return primeNumbersArray;
    }
}
