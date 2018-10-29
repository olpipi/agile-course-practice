package ru.unn.agile.lengthconverter.model;

public enum LengthUnit {
    METERS {
        protected double convertToMeters(final double value) {
            return value;
        }

        public double convert(final double value, final LengthUnit targetUnit) {
            if (targetUnit == MILLIMETERS) {
                return value * KILO;
            } else if (targetUnit == KILOMETERS) {
                return value * MILLI;
            } else {
                return value;
            }
        }
    },
    MILLIMETERS {
        protected double convertToMeters(final double value) {
            return value * MILLI;
        }
    },
    KILOMETERS {
        protected double convertToMeters(final double value) {
            return value * KILO;
        }
    };

    public double convert(final double value, final LengthUnit targetUnit) {
        return METERS.convert(this.convertToMeters(value), targetUnit);
    }
    private static final double KILO = 1e3;
    private static final double MILLI = 1e-3;
    abstract double convertToMeters(double value);
}
