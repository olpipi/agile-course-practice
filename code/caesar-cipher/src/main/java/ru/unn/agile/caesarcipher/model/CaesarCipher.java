package ru.unn.agile.caesarcipher.model;

public class CaesarCipher {
    public CaesarCipher() {
        /* constructor not needed here */
    }

    private static final int NUMBER_OF_CHARACTERS_IN_INTERVAL = (int) 'z' - (int) 'a' + 1;
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
                newCharCode %= NUMBER_OF_CHARACTERS_IN_INTERVAL;
                if (newCharCode < 0) {
                    newCharCode += NUMBER_OF_CHARACTERS_IN_INTERVAL;
                }
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

