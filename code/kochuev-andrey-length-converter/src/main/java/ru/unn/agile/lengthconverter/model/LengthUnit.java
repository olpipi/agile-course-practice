package ru.unn.agile.lengthconverter.model;

public enum LengthUnit {
    METERS {
        protected double convertToMeters(final double value) {
            return value;
        }

        public double convert(final double value, LengthUnit targetUnit) {
            if (targetUnit == MILLIMETERS)
                return value * COEF_KILO;
            else if (targetUnit == KILOMETERS)
                return value * COEF_MILLI;
            else
                return value;
        }
    },
    MILLIMETERS {
        protected double convertToMeters(final double value) {
            return value * COEF_MILLI;
        }
    },
    KILOMETERS {
        protected double convertToMeters(final double value) {
            return value * COEF_KILO;
        }
    };

    public double convert(final double value, LengthUnit targetUnit) {
        return METERS.convert(this.convertToMeters(value), targetUnit);
    }

    private static final double COEF_KILO = 1e3;
    private static final double COEF_MILLI = 1e-3;

    abstract double convertToMeters(final double value);
}
