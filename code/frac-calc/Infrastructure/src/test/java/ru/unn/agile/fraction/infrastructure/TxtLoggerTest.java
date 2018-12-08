package ru.unn.agile.fraction.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TxtLoggerTest {
    private static final String FILE_NAME = "./TxtLoggerTest.log";
    private static final String DATE_TIME_LOG_LINE = "^\\d{2}.\\d{2}.\\d{4} \\d{2}:\\d{2}:\\d{2} -> ";

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
        assertNotNull(txtLogger);
    }

    @Test
    public void canCreateLogFile() {
        File f = new File(FILE_NAME);

        assertTrue(f.exists());
    }

    @Test
    public void canWriteLogMessage() {
        String message = "Test message";

        txtLogger.log(message);

        List<String> logList = txtLogger.getLog();
        assertTrue(logList.get(0).matches(DATE_TIME_LOG_LINE + message));
    }

    @Test
    public void canWriteSeveralLogMessages() {
        String[] messages = {"Test message 0", "Test message 1"};

        for (String message : messages) {
            txtLogger.log(message);
        }

        List<String> logList = txtLogger.getLog();
        for (int i = 0; i < logList.size(); i++) {
            assertTrue(logList.get(i).matches(DATE_TIME_LOG_LINE + messages[i]));
        }
    }

    @Test
    public void createTxtLoggerWithIncorrectFileNameCreatedEmptyLoggerAndThrowsException() {
        TxtLogger emptyLogger = new TxtLogger("");

        assertEquals(0, emptyLogger.getLog().size());
    }

    @Test
    public void cantWriteToTxtLoggerWithIncorrectFileNameAndThrowsException() {
        TxtLogger emptyLogger = new TxtLogger("");

        emptyLogger.log("Test message");

        assertEquals(0, emptyLogger.getLog().size());
    }

    @Test
    public void readeFromTxtLoggerWithIncorrectFileNameThrowsException() {
        TxtLogger emptyLogger = new TxtLogger("");

        List<String> logList = emptyLogger.getLog();

        assertEquals(0, logList.size());
    }
}
