package ru.unn.agile.romannumberconverter.model;

public final class RomanNumberConverter {
    public static String convertToRoman(final int arabicNumber) {
		String romanNumber = "";
        if (arabicNumber == 1) {
			romanNumber = "I";
		}
			
		return romanNumber;
    }
}
