package ru.unn.agile.vector3d.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class TxtLoggerTest {
    private static final String FILE_NAME = "./TxtLoggerTest.log";
    private static final String RE_LOG_LINE = "^\\d{2}.\\d{2}.\\d{4} \\d{2}:\\d{2}:\\d{2} - ";

    private TxtLogger txtLogger;

    @Before
    public void setUp() {
        txtLogger = new TxtLogger(FILE_NAME);
    }

    @After
    public void tearDown() {
        txtLogger = null;
    }

    @Test
    public void canCreateLoggerWithFileName() {
        // Assert
        assertNotNull(txtLogger);
    }

    @Test
    public void canCreateLogFile() {
        // Act
        File f = new File(FILE_NAME);

        // Assert
        assertTrue(f.exists());
    }

    @Test
    public void canWriteLogMessage() {
        // Arrange
        String message = "This is a test message";

        // Act
        txtLogger.log(message);

        // Assert
        String logMessage = txtLogger.getLog().get(0);
        assertTrue(logMessage.matches(RE_LOG_LINE + message));
    }

    @Test
    public void canWriteMultipleMessages() {
        // Arrange
        String[] messages = {"Test message 1", "Test message 1"};

        // Act
        for (String message : messages) {
            txtLogger.log(message);
        }

        // Assert
        List<String> log = txtLogger.getLog();
        for (int i = 0; i < log.size(); i++) {
            assertTrue(log.get(i).matches(RE_LOG_LINE + messages[i]));
        }
    }
}
