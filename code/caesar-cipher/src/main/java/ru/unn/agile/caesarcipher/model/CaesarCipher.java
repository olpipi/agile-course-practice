package ru.unn.agile.caesarcipher.model;

public class CaesarCipher {
    public CaesarCipher() {
        /* constructor not needed here */
    }

    public String encode(final String input, final int offset) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            int charCode = (int) input.charAt(i);
            output += (char) (charCode + offset);
        }
        return output;
    }
}
