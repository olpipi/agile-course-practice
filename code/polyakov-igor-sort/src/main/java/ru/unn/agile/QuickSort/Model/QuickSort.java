package ru.unn.agile.QuickSort.Model;

public class QuickSort {
    public static void quickSort(int[] array) {
        if (array.length == 2) {
            if (array[0] > array[1]) {
                int tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;
            }
        }
    }
}
