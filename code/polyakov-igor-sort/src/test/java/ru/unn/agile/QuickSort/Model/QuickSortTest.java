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
    public void canSortingOfArrayWithOneInteger() {
        int[] array = {1};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfSortedArrayWithTwoIntegers() {
        int[] array = {1, 2};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfNonsortedArrayWithTwoIntegers() {
        int[] array = {2, 1};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfNonsortedArrayWithThreeIntegers() {
        int[] array = {2, 0, 1};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfSortedArrayWithThreeIntegers() {
        int[] array = {0, 1, 2};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfNonsortedBigArrayOfIntegers() {
        int[] array = {1, 4, 3, -1, 5, 8, 8, -100, 9, 4, 1, 0};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenSortingOfEmptyArrayOfIntegers() {
        int[] array = {};

        QuickSort.quickSort(array);
    }
}
