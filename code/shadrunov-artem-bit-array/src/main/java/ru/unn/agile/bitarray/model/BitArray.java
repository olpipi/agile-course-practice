package ru.unn.agile.bitarray.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitArray {

    private List<Integer> bits;

    BitArray() {
        this.bits = new ArrayList<>();
    }

    BitArray(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Argument must be positive number");

        this.bits = new ArrayList<>();

        if (number == 0)
            return;

        do {
            this.bits.add(number %2);
            number /= 2;
        } while (number != 0);

        Collections.reverse(this.bits);
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

    public int getAtIndex(int index) {
        return this.bits.get(index);
    }

    @Override
    public String toString() {
        String stringBitArray = "";
        for (Integer i: bits) stringBitArray += i.toString();

        return stringBitArray;
    }
}
