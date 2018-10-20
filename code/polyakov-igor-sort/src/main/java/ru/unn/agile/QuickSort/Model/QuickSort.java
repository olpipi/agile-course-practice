package ru.unn.agile.QuickSort.Model;

public final class QuickSort {
    public static final int MIN_ARRAY_ELEMENTS_COUNT = 1;

    public static <T extends Comparable<T>> void quickSort(final T[] array) {
        if (array.length < MIN_ARRAY_ELEMENTS_COUNT) {
            throw new IllegalArgumentException("Array elements count should be positive");
        }

        int startElementIndex = 0;
        int endElementIndex = array.length - 1;
        quickSortImpl(array, startElementIndex, endElementIndex);
    }

    private static <T extends Comparable<T>> void quickSortImpl(final T[] array,
                                                                final int startElementIndex,
                                                                final int endElementIndex) {
        T bearingElement = calculateBearingElement(array, startElementIndex, endElementIndex);

        int i = startElementIndex;
        int j = endElementIndex;
        while (i <= j) {
            while (array[i].compareTo(bearingElement) < 0) {
                ++i;
            }

            while (array[j].compareTo(bearingElement) > 0) {
                --j;
            }

            if (i <= j) {
                swapTwoElementsInArray(array, i, j);
                ++i;
                --j;
            }
        }

        if (j > startElementIndex) {
            quickSortImpl(array, startElementIndex, j);
        }
        if (i < endElementIndex) {
            quickSortImpl(array, i, endElementIndex);
        }
    }

    private static <T extends Comparable<T>> T calculateBearingElement(final T[] array,
                                                                       final int firstElementIndex,
                                                                       final int secondElementIndex) {
        return array[(firstElementIndex + secondElementIndex) / 2];
    }

    private static <T extends Comparable<T>> void swapTwoElementsInArray(final T[] array,
                                                                         final int firstElementIndex,
                                                                         final int secondElementIndex) {
        T tmp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = tmp;
    }

    private QuickSort() {
    }
}
