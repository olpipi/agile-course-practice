package ru.unn.agile.mathstatistics.model;

public final class MathStatistics {
    private MathStatistics() {
    }

    static Double meanCalculate(final Number[] data) {
        if(data == null){
            throw new IllegalArgumentException("array should be initialized");
        }
        for (int i = 0; i < data.length; ++i) {
            if (data[i] == null) {
                throw new IllegalArgumentException("null element shouldn't be in array");
            }
        }

        Double mean = 0.0;
        for (int i = 0; i < data.length; ++i) {
            mean += data[i].doubleValue();
        }
        mean /= data.length;
        return mean;
    }

    static Double dispersionCalculate(final Number[] data) {
        if(data == null){
            throw new IllegalArgumentException("array should be initialized");
        }
        for (int i = 0; i < data.length; ++i) {
            if (data[i] == null) {
                throw new IllegalArgumentException("null element shouldn't be in array");
            }
        }

        final Double mean = meanCalculate(data);

        Double dispersion = 0.0;
        for (int i = 0; i < data.length; ++i) {
            dispersion += Math.pow((data[i].doubleValue() - mean), 2);
        }

        dispersion /= data.length;
        return dispersion;
    }

}
