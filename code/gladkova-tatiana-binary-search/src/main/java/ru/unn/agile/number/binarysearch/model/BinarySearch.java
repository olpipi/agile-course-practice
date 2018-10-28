package ru.unn.agile.number.binarysearch.model;

public class BinarySearch {

    private int key;
    private int[] array;
    private int rightBorder;
    private int leftBorder;

    public BinarySearch(int[] arrayParam, int keyParam) {
        key = keyParam;
        array = arrayParam;
        leftBorder = 0;
        rightBorder = array.length - 1;
    }


    public int getKey() {
        return key;
    }

    public int doSearch() {
        return 7;
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
}
