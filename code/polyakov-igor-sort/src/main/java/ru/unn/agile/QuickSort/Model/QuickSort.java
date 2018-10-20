package ru.unn.agile.QuickSort.Model;

public class QuickSort {
    public static void quickSort(final int[] array) {
        if (array.length == 2) {
            if (array[0] > array[1]) {
                swapTwoElementsInArray(array, 0, 1);
            }
        }
    }

    private static void swapTwoElementsInArray(final int[] array, int pos_element_1, int pos_element_2) {
        int tmp = array[pos_element_1];
        array[pos_element_1] = array[pos_element_2];
        array[pos_element_2] = tmp;
    }

    private QuickSort() {

    }
}
