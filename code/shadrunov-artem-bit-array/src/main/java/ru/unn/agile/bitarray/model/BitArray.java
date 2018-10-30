package ru.unn.agile.bitarray.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitArray {

    private List<Integer> bits;

    BitArray() {
        bits = new ArrayList<>();
    }

    BitArray(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Argument must be positive number");

        bits = new ArrayList<>();

        if (number == 0)
            return;

        do {
            bits.add(number % 2);
            number /= 2;
        } while (number != 0);

        Collections.reverse(bits);
    }

    BitArray(List<Integer> bitArray) {
        if (bitArray == null)
            throw new NullPointerException();

        if (bitArray.stream().anyMatch(i -> !isOneOrZero(i)))
            throw new IllegalArgumentException("Array must contains only 1 and 0");

        int i = 0;
        while (bitArray.size() != 0 && bitArray.get(i) == 0)
            bitArray.remove(i);

        bits = bitArray;
    }

    public int size() {
        return bits.size();
    }

    public int getAtIndex(int index) {
        return bits.get(index);
    }

    public void add(int bit) {
        if (!isOneOrZero(bit))
            throw new IllegalArgumentException("Array must contains only 1 and 0");

        bits.add(bit);
    }

    public void remove(int index) {
        bits.remove(index);
    }

    public void replace(int index, int bit) {
        if (!isOneOrZero(bit))
            throw new IllegalArgumentException("Array must contains only 1 and 0");

        bits.set(index, bit);
    }

    public int toInt() {
        int result = 0;

        for (int i = 0; i < bits.size(); i++) {
            result += bits.get(i) * Math.pow(2, size() - i - 1);
        }

        return result;
    }

    @Override
    public String toString() {
        String stringBitArray = "";
        for (Integer i : bits) stringBitArray += i.toString();

        return stringBitArray;
    }

    public boolean equals(BitArray other) {
        return toInt() == other.toInt();
    }

    private boolean isOneOrZero(int number) {
        return number == 1 || number == 0;
    }
}
