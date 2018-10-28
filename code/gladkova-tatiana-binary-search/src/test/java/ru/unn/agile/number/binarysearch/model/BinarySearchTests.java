package ru.unn.agile.number.binarysearch.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTests {
    @Test
    public void canInitializationKeyBinarySearch(){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 7;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(7, binarySearch.getKey());
    }

    @Test
    public void canInitializationArrayBinarySearch(){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 7;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(array, binarySearch.getArray());
    }

    @Test
    public void canSearchKeyInArray(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int key = 7;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(7, binarySearch.doSearch());
    }

    @Test
    public void getRightPositionBorder(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int key = 2;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(5, binarySearch.getRightPositionBorder());
    }

    @Test
    public void getRightPositionBorder2(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int key = 8;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(9, binarySearch.getRightPositionBorder());
    }

    @Test
    public void getLeftPositionBorder(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int key = 8;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(5, binarySearch.getLeftPositionBorder());
    }

    @Test
    public void getLeftPositionBorder2(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int key = 2;
        BinarySearch binarySearch = new BinarySearch(array, key);
        assertEquals(0, binarySearch.getLeftPositionBorder());
    }

}
