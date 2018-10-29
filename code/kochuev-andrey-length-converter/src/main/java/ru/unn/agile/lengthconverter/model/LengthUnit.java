package ru.unn.agile.lengthconverter.model;

public enum LengthUnit {
    METERS{
        public double convert(final double value, LengthUnit targetUnit){
            if(targetUnit == MILLIMETERS)
                return value * 1000;
            else if(targetUnit == KILOMETERS)
                return value * 0.001;
            else
                return value;
        }
    },
    MILLIMETERS{
        public double convert(final double value, LengthUnit targetUnit){
            if(targetUnit == METERS)
                return value * 0.001;
            else if(targetUnit == KILOMETERS)
                return value * 0.000001;
            else
                return value;
        }
    },
    KILOMETERS{
        public double convert(final double value, LengthUnit targetUnit){
            if(targetUnit == METERS)
                return value * 1000;
            else if(targetUnit == MILLIMETERS)
                return value * 1000000;
            else
                return value;
        }
    };

    public abstract double convert(final double value, LengthUnit targetUnit);
}
