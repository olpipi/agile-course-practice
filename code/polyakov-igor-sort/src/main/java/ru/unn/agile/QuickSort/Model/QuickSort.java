package ru.unn.agile.QuickSort.Model;

public class QuickSort {
    public static void quickSort(final int[] array, int startElementIndex, int endElementIndex) {
        int i = startElementIndex;
        int j = endElementIndex;
        int bearingElement = array[startElementIndex];
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
            quickSort(array, startElementIndex, j);
        }
        if (i < endElementIndex) {
            quickSort(array, i, endElementIndex);
        }
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
