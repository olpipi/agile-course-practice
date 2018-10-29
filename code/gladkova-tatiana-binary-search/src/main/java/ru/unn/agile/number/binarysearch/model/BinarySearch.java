package ru.unn.agile.number.binarysearch.model;

public class BinarySearch {

    private int[] array;

    public BinarySearch(final int[] arrayParam) {
        array = arrayParam;
    }


    public int[] getArray() {
        return array;
    }

    public boolean inLeftHalf(final int key) {
        int size = array.length;
        return  (key < array[size / 2]);
    }

    public boolean inRightHalf(final int key) {
        int size = array.length;
        return (array[size / 2] < key);
    }

    public int search(final int key) {
        int middle;
        int leftBorder = 0;
        int rightBorder = array.length - 1;

        if (identifyAnArray()) {
            while ((leftBorder <= rightBorder)) {
                middle = (leftBorder + rightBorder) / 2;
                if (key > array[middle]) {
                    leftBorder = middle + 1;
                }
                if (key < array[middle]) {
                    rightBorder = middle - 1;
                }
                if (key == array[middle]) {
                    return middle;
                }
            }
        }
        return -1;
    }

    public boolean identifyAnArray() {
        int size = array.length;
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
