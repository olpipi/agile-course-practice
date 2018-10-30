package ru.unn.agile.caesarcipher.model;

public class CaesarCipher {
    public CaesarCipher() {
        /* constructor not needed here */
    }

    private int numberOfCharactersInInterval = (int) 'z' - (int) 'a' + 1;
    private int startingPosition = (int) 'a';

    public String encode(final String input, final int offset) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            int charCode = (int) input.charAt(i) - startingPosition;
            int newCharCode = charCode + offset;
            if (newCharCode < 0) {
                newCharCode += numberOfCharactersInInterval;
            }
            newCharCode %= numberOfCharactersInInterval;
            newCharCode += startingPosition;
            output += (char) (newCharCode);
        }
        return output;
    }
}
