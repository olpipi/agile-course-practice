package ru.unn.agile.romannumberconverter.model;

public final class RomanNumberConverter {
    public static String convertToRoman(final int arabicNumber) {
		String romanNumber = "";
        for (int i = 0; i < arabicNumber; i++) {
        	romanNumber += "I";
		}
			
		return romanNumber;
    }
}
