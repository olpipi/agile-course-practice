package ru.unn.agile.QuickSort.Model;

public final class QuickSort {
    public static final int MIN_ARRAY_ELEMENTS_COUNT = 1;

    public static void quickSort(final int[] array) {
        if (array.length < MIN_ARRAY_ELEMENTS_COUNT) {
            throw new IllegalArgumentException("Array elements count should be positive");
        }

        int startElementIndex = 0;
        int endElementIndex = array.length - 1;
        quickSortImpl(array, startElementIndex, endElementIndex);
    }

    private static void quickSortImpl(final int[] array,
                                      final int startElementIndex,
                                      final int endElementIndex) {
        int bearingElement = calculateBearingElement(array, startElementIndex, endElementIndex);

        int i = startElementIndex;
        int j = endElementIndex;
        while (i <= j) {
            while (array[i] < bearingElement) {
                ++i;
            }

            while (array[j] > bearingElement) {
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

    private static int calculateBearingElement(final int[] array,
                                               final int firstElementIndex,
                                               final int secondElementIndex) {
        return array[(firstElementIndex + secondElementIndex) / 2];
    }

    private static void swapTwoElementsInArray(final int[] array,
                                               final int firstElementIndex,
                                               final int secondElementIndex) {
        int tmp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = tmp;
    }

    private QuickSort() {

    }
}
