package ru.unn.agile.lengthconverter.model;

public enum LengthUnit {
    METERS{
        public double convert(final double value, LengthUnit targetUnit){
            if(targetUnit == MILLIMETERS)
            {
                return value * 1000;
            }
            else
            {
                return value * 0.001;
            }
        }
    },
    MILLIMETERS{
        public double convert(final double value, LengthUnit targetUnit){
            if(targetUnit == METERS)
            {
                return value * 0.001;
            }
            else
            {
                return value * 0.000001;
            }
        }
    },
    KILOMETERS{
        public double convert(final double value, LengthUnit targetUnit){
            if(targetUnit == METERS)
            {
                return value * 1000;
            }
            else
            {
                return value * 1000000;
            }
        }
    };

    public abstract double convert(final double value, LengthUnit targetUnit);
}
