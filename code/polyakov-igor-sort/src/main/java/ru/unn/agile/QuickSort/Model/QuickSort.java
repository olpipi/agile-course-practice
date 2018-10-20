package ru.unn.agile.QuickSort.Model;

public class QuickSort {
    public static void quickSort(final int[] array) {
        if (array.length == 2) {
            if (array[0] > array[1]) {
                swapTwoElementsInArray(array, 0, 1);
            }
        }
    }

    private static void swapTwoElementsInArray(final int[] array, final int firstElement, final int secondElement) {
        int tmp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = tmp;
    }

    private QuickSort() {

    }
}
