package ru.unn.agile.mathstatistics.model;

public final class MathStatistics {
    private MathStatistics() {
    }

    static Double meanCalculate(final Number[] data) {
        Double mean = 0.0;
        for (int i = 0; i < data.length; ++i) {
            mean += data[i].doubleValue();
        }
        mean /= data.length;
        return mean;
    }


}
