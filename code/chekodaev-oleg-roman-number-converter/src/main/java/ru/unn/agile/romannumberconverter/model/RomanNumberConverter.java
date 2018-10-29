package ru.unn.agile.romannumberconverter.model;

public final class RomanNumberConverter {
	private static String convertToRomanFirstThreeNumbers(final int arabicNumber) {
		String romanNumber = "";
		if (arabicNumber < 4) {
			for (int i = 0; i < arabicNumber; i++) {
				romanNumber += "I";
			}
		}

		return romanNumber;
	}

    public static String convertToRoman(final int arabicNumber) {
		String romanNumber = "";
		if (arabicNumber < 4) {
			romanNumber = convertToRomanFirstThreeNumbers(arabicNumber);
		} else if (arabicNumber == 4) {
			romanNumber = "IV";
		} else if (arabicNumber >= 5) {
			romanNumber = "V";
			romanNumber += convertToRomanFirstThreeNumbers(arabicNumber - 5);
		}
			
		return romanNumber;
    }
}
