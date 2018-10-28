package ru.unn.agile.bitarray.model;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class BitArrayTests {

    @Test(expected = NullPointerException.class)
    public void canInitializeWithNull() {
        List<Integer> bits = null;

        new BitArray(bits);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitializeWithAnyDecimalNumbersArray() {
        List<Integer> list = new ArrayList<>();

        int i = 7;
        while (i != 0)
            list.add(i--);

        new BitArray(list);
    }

    @Test
    public void canCreateBitArrayWithOnesAndZeroesArray() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(1);
            list.add(0);
        }

        BitArray bitArray = new BitArray(list);

        assertNotNull(bitArray);
    }

    @Test
    public void canGetSize() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray = new BitArray(list);

        assertEquals(4, bitArray.size());
    }

    @Test
    public void canCreateBitArrayFromZeroesArray() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray = new BitArray(list);

        assertEquals(0, bitArray.size());
    }

    @Test
    public void canConvertToString(){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray = new BitArray(list);

        assertEquals("1000", bitArray.toString());
    }

    @Test
    public void canConvertEmptyBitArrayToString() {
        BitArray bitArray = new BitArray();

        assertEquals("", bitArray.toString());
    }

    @Test
    public void canCutFirstZeroesInStringRepresentation() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            list.add(0);

        list.add(1);

        BitArray bitArray = new BitArray(list);

        assertEquals("1", bitArray.toString());
    }

    @Test
    public void canConvertZeroesArrayToString() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray = new BitArray(list);

        assertEquals("", bitArray.toString());
    }

    @Test
    public void canGetAtIndex() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray = new BitArray(list);

        assertEquals(0, bitArray.getAtIndex(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canGetAtIndexOutOfRange() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray = new BitArray(list);

        bitArray.getAtIndex(100);
    }

    @Test
    public void canInitializeWithInteger() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        for (int i = 0; i < 3; i++)
            list.add(0);

        BitArray bitArray1 = new BitArray(8);
        BitArray bitArray2 = new BitArray(list);

        boolean isAllElementsEquals = true;
        for (int i = 0; i < bitArray1.size(); i++) {
            if (bitArray1.getAtIndex(i) != bitArray2.getAtIndex(i)) {
                isAllElementsEquals = false;
            }
        }

        assertTrue(isAllElementsEquals);
    }

    @Test
    public void canInitializeWithZero() {
        BitArray bitArray = new BitArray(0);

        assertTrue(bitArray.size() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitializeWithNegativeNumber() {
        BitArray bitArray = new BitArray(-1);
    }
}
