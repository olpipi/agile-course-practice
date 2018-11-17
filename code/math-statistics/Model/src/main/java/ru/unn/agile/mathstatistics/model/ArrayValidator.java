package ru.unn.agile.mathstatistics.model;

public class ArrayValidator {
    public static <T> void validate(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array should be initialized!");
        }

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null) {
                throw new IllegalArgumentException(
                        "Each array element should be initialized!");
            }
        }
    }

    private ArrayValidator() {
    }
}
