package ru.unn.agile.QuickSort.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    private boolean isArraySorted(int[] array)
    {
        for (int i = 0; i < array.length - 1; ++i)
            if (array[i] > array[i+1])
                return false;

        return true;
    }

    @Test
    public void canSortOneInteger() {
        int[] array = {1};

        QuickSort.quickSort(array, 0, array.length - 1);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortTwoSortedIntegers() {
        int[] array = {1, 2};

        QuickSort.quickSort(array, 0, array.length - 1);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortTwoNonSortedIntegers() {
        int[] array = {2, 1};

        QuickSort.quickSort(array, 0, array.length - 1);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortThreeNonSortedIntegers() {
        int[] array = {2, 0, 1};

        QuickSort.quickSort(array, 0, array.length - 1);

        assertTrue(isArraySorted(array));
    }
}
