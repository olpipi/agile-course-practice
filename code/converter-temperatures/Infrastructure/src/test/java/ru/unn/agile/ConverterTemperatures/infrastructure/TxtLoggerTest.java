package ru.unn.agile.ConverterTemperatures.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class TxtLoggerTest {
    private static final String FILE_NAME = "./TxtLogger.log";
    private TxtLogger txtLogger;

    @Before
    public void initTxtLogger() {
        txtLogger = new TxtLogger(FILE_NAME);
    }

    @After
    public void nullLogger() {
        txtLogger = null;
    }

    @Test
    public void canCreateLogger() {
        assertNotNull(txtLogger);
    }

    @Test
    public void canCreateLogFile() {
        File logfile = new File(FILE_NAME);

        assertTrue(logfile.exists());
    }

    @Test
    public void canWriteLogMessage() {
        String message = "Value -300 is not corrected";

        txtLogger.log(message);

        String logMessage = txtLogger.getLog().get(0);
        assertTrue(logMessage.matches(message));
    }

    @Test
    public void canWriteTwoMessages() {
        String[] messages = {"Value -300 is not corrected",
                "Value -450 is not corrected"};

        for (String mes : messages) {
            txtLogger.log(mes);
        }

        List<String> log = txtLogger.getLog();
        for (int i = 0; i < log.size(); i++) {
            assertTrue(log.get(i).matches(messages[i]));
        }
    }
}
