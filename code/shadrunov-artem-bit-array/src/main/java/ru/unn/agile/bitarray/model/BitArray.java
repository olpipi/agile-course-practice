package ru.unn.agile.bitarray.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.BitSet;
import java.util.List;

public class BitArray {

    private List<Integer> bits;

    BitArray(List<Integer> bitArray) {
        if (bitArray == null)
            throw new NullPointerException();

        if (bitArray.stream().anyMatch(i -> i < 0 || i > 1))
            throw new IllegalArgumentException("Array must contains only 1 and 0");

        this.bits = bitArray;
    }

}
