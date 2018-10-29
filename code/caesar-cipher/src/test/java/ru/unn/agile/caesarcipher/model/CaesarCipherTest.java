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

}
