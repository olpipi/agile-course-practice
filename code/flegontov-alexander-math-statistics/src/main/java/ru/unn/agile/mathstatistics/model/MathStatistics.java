package ru.unn.agile.mathstatistics.model;

public final class MathStatistics {
    private MathStatistics() {
    }

    static Double meanCalculate(final Number[] data) {
        checkInputData(data);

        Double mean = 0.0;
        for (int i = 0; i < data.length; ++i) {
            mean += data[i].doubleValue();
        }
        mean /= data.length;
        return mean;
    }

    static Double dispersionCalculate(final Number[] data) {
        final Double mean = meanCalculate(data);

        Double dispersion = 0.0;
        for (int i = 0; i < data.length; ++i) {
            dispersion += Math.pow((data[i].doubleValue() - mean), 2);
        }

        dispersion /= data.length;
        return dispersion;
    }

    static Double momentCalculate(final Number[] data, int order, Number a) {
        checkInputData(data);

        if (order <= 0) {
            throw new IllegalArgumentException("Order must be non-zero and positive value!");
        }

        Double moment = 0.0;
        for (int i = 0; i < data.length; ++i) {
            moment += Math.pow((data[i].doubleValue() - a.doubleValue()), order);
        }

        moment /= data.length;
        return moment;
    }

    private static void checkInputData(final Number[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Array should be initialized!");
        }

        for (int i = 0; i < data.length; ++i) {
            if (data[i] == null) {
                throw new IllegalArgumentException("Null element shouldn't be in array!");
            }
        }

        if (data.length < 1) {
            throw new IllegalArgumentException("The Length of data array must be non-zero value!");
        }
    }

}
