package ru.unn.agile.QuickSort.Model;

public final class QuickSort {
    public static final int MIN_ARRAY_ELEMENTS_COUNT = 1;

    public static <T extends Comparable<T>>
    void quickSort(final T[] array) {
        if (array.length < MIN_ARRAY_ELEMENTS_COUNT) {
            throw new IllegalArgumentException("Array elements count should be positive");
        }

        int startElementIndex = 0;
        int endElementIndex = array.length - 1;
        quickSortImpl(array, startElementIndex, endElementIndex);
    }

    private static <T extends Comparable<T>>
    void quickSortImpl(final T[] array,
                       final int startSubArrayIndex,
                       final int endSubArrayIndex) {
        T bearingElement = calculateBearingElement(array, startSubArrayIndex, endSubArrayIndex);

        int currentLeftBound = startSubArrayIndex;
        int currentRightBound = endSubArrayIndex;
        while (currentLeftBound <= currentRightBound) {
            while (array[currentLeftBound].compareTo(bearingElement) < 0) {
                ++currentLeftBound;
            }

            while (array[currentRightBound].compareTo(bearingElement) > 0) {
                --currentRightBound;
            }

            if (currentLeftBound <= currentRightBound) {
                swapTwoElementsInArray(array, currentLeftBound, currentRightBound);
                ++currentLeftBound;
                --currentRightBound;
            }
        }

        if (currentRightBound > startSubArrayIndex) {
            quickSortImpl(array, startSubArrayIndex, currentRightBound);
        }
        if (currentLeftBound < endSubArrayIndex) {
            quickSortImpl(array, currentLeftBound, endSubArrayIndex);
        }
    }

    private static <T extends Comparable<T>>
    T calculateBearingElement(final T[] array,
                              final int firstElementIndex,
                              final int secondElementIndex) {
        return array[(firstElementIndex + secondElementIndex) / 2];
    }

    private static <T extends Comparable<T>>
    void swapTwoElementsInArray(final T[] array,
                                final int firstElementIndex,
                                final int secondElementIndex) {
        T tmp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = tmp;
    }

    private QuickSort() {
    }
}
