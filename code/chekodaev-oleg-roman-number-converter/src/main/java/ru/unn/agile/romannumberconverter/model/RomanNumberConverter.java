package ru.unn.agile.romannumberconverter.model;

public final class RomanNumberConverter {
    public static String convertToRoman(final int arabicNumber) {
		String romanNumber = "";
		if (arabicNumber < 4) {
			for (int i = 0; i < arabicNumber; i++) {
				romanNumber += "I";
			}
		} else if (arabicNumber == 4) {
			romanNumber = "IV";
		} else if (arabicNumber == 5) {
			romanNumber = "V";
		}
			
		return romanNumber;
    }
}
