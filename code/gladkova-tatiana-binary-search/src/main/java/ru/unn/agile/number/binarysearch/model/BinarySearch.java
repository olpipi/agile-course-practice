package ru.unn.agile.number.binarysearch.model;

public class BinarySearch {

    private int key;
    private int[] array;
    private int rightBorder;
    private int leftBorder;

    public BinarySearch(final int[] arrayParam, final int keyParam) {
        key = keyParam;
        array = arrayParam;
        leftBorder = 0;
        rightBorder = array.length - 1;
    }


    public int getKey() {
        return key;
    }

    public int[] getArray() {
        return array;
    }

    public int getRightPositionBorder() {
        int size = array.length;
        if (key < array[size / 2]) {
            rightBorder = size / 2;
        }
        return rightBorder;
    }

    public int getLeftPositionBorder() {
        int size = array.length;
        if (key > array[size / 2]) {
            leftBorder = size / 2;
        }
        return leftBorder;
    }

    public int doSearch() {
        int middle;

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
        return -1;
    }
}
