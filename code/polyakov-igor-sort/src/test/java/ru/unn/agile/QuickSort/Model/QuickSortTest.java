package ru.unn.agile.QuickSort.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    private <T extends Comparable<T>>
    boolean isArraySorted(final T[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void canSortingOfArrayWithOneInteger() {
        Integer[] array = {1};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfSortedArrayWithTwoIntegers() {
        Integer[] array = {1, 2};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfNonSortedArrayWithTwoIntegers() {
        Integer[] array = {2, 1};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfNonSortedArrayWithThreeIntegers() {
        Integer[] array = {2, 0, 1};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfSortedArrayWithThreeIntegers() {
        Integer[] array = {0, 1, 2};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test
    public void canSortingOfNonSortedBigArrayOfIntegers() {
        Integer[] array = {1, 4, 3, -1, 5, 8, 8, -100, 9, 4, 1, 0};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenSortingOfEmptyArrayOfIntegers() {
        Integer[] array = {};

        QuickSort.quickSort(array);
    }

    @Test
    public void canSortingOfNonSortedBigArrayOfDoubles() {
        Double[] array = {1.4, 4.3, 3.3, -1.9, 5.1, 8.5, 8.0, -100.0, 9.7, 4.1, 1.6, 0.0};

        QuickSort.quickSort(array);

        assertTrue(isArraySorted(array));
    }
}
