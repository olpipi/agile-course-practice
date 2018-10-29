package ru.unn.agile.caesarcipher.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaesarCipherTest {

    @Test
    public void canEncodeEmptyString() {
        // Arrange
        CaesarCipher cipher = new CaesarCipher();
        // Act
        String encodedString = cipher.encode("", 1);
        // Assert
        assertEquals(encodedString, "");
    }

    @Test
    public void canShiftStringByZeroOffset() {
        CaesarCipher cipher = new CaesarCipher();
        String encodedString = cipher.encode("abc", 0);
        assertEquals(encodedString, "abc");
    }

    @Test
    public void canShiftStringByPositiveOffset() {
        CaesarCipher cipher = new CaesarCipher();
        String encodedString = cipher.encode("abc", 1);
        assertEquals(encodedString, "bcd");
    }

    @Test
    public void canShiftStringByNegativeOffset() {
        CaesarCipher cipher = new CaesarCipher();
        String encodedString = cipher.encode("bcd", -1);
        assertEquals(encodedString, "abc");
    }

}
