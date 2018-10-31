package ru.unn.agile.caesarcipher.model;

public class CaesarCipher {
    public CaesarCipher() {
        /* constructor not needed here */
    }

    private int numberOfCharactersInInterval = (int) 'z' - (int) 'a' + 1;
    private int calculateStartingPosition(final int charCode) {
        int startingPosition = 0;
        if ((charCode >= (int) 'a') & (charCode <= (int) 'z')) {
            startingPosition = (int) 'a';
        } else if ((charCode >= (int) 'A') & (charCode <= (int) 'Z')) {
            startingPosition = (int) 'A';
        }
        return startingPosition;
    }

    public String encode(final String input, final int offset) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            int charCode = (int) input.charAt(i);
            int startingPosition = calculateStartingPosition(charCode);
            if (startingPosition != 0) {
                charCode -= startingPosition;
                int newCharCode = charCode + offset;
                if (newCharCode < 0) {
                    newCharCode += numberOfCharactersInInterval;
                }
                newCharCode %= numberOfCharactersInInterval;
                newCharCode += startingPosition;
                output += (char) (newCharCode);
            } else {
                output += (char) (charCode);
            }
        }
        return output;
    }

    public String decode(final String input, final int offset) {
        return encode(input, -1 * offset);
    }
}
