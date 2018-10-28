package ru.unn.agile.bitarray.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitArray {

    private List<Integer> bits;

    BitArray(){
        this.bits = new ArrayList<>();
    }

    BitArray(List<Integer> bitArray) {
        if (bitArray == null)
            throw new NullPointerException();

        if (bitArray.stream().anyMatch(i -> i < 0 || i > 1))
            throw new IllegalArgumentException("Array must contains only 1 and 0");

        int i = 0;
        while (bitArray.size() != 0 && bitArray.get(i) == 0)
            bitArray.remove(i);

        this.bits = bitArray;
    }

    public int size() {
        return bits.size();
    }

    @Override
    public String toString() {
        String stringBitArray = "";
        for (Integer i: bits) stringBitArray += i.toString();

        return stringBitArray;
    }
}
