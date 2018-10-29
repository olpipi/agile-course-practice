package ru.unn.agile.lengthconverter.model;

public enum LengthUnit {
    METERS {
        protected double convertToMeters(final double value) {
            return value;
        }

        public double convert(final double value, final LengthUnit targetUnit) {
            switch (targetUnit) {
                case MILLIMETERS:
                    return value * KILO;
                case KILOMETERS:
                    return value * MILLI;
                case FEET:
                    return value * METER_TO_FOOT;
                default:
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
    },
    FEET {
        protected double convertToMeters(final double value) {
            return value * FOOT_TO_METER;
        }
    };

    public double convert(final double value, final LengthUnit targetUnit) {
        return METERS.convert(this.convertToMeters(value), targetUnit);
    }
    private static final double KILO = 1e3;
    private static final double MILLI = 1e-3;
    private static final double METER_TO_FOOT = 3.28084;
    private static final double FOOT_TO_METER = 0.3048;
    abstract double convertToMeters(double value);
}
