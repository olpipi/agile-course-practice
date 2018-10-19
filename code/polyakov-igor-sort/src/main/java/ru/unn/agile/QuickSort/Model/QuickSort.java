package ru.unn.agile.QuickSort.Model;

public class QuickSort {
    public static void quickSort(int[] array) {
        if (array.length == 2) {
            if (array[0] > array[1]) {
                swap(array, 0, 1);
            }
        }
    }

    private static void swap(int[] array, int pos_1, int pos_2) {
        int tmp = array[pos_1];
        array[pos_1] = array[pos_2];
        array[pos_2] = tmp;
    }
}
