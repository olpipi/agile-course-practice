package ru.unn.agile.bitarray.model;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertNotNull;


public class BitArrayTests {

    @Test(expected = NullPointerException.class)
    public void canInitializeWithNull() {
        List<Integer> bits = null;

        new BitArray(bits);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitializeWithAnyDecimalNumbersArray(){
        List<Integer> list = new ArrayList<>();

        int i = 7;
        while (i != 0)
            list.add(i--);

        new BitArray(list);
    }

    @Test
    public void canCreateBitArrayWithOnesAndZeroesArray(){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(1);
            list.add(0);
        }

        BitArray bitArray = new BitArray(list);

        assertNotNull(bitArray);
    }
}
