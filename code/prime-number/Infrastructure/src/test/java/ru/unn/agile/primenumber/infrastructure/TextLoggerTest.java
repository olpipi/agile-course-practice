package ru.unn.agile.primenumber.infrastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class TextLoggerTest {

    private LoggerFactory factory;

    @Before
    public void initFactory() {
        factory = new LoggerFactory();
    }

    @Test
    public void canInitiateLogger() {
        Logger logger = factory.getLogger();

        assertTrue(logger.getLogs().isEmpty());
    }

    @Test
    public void canResetFileLogger() {
        Logger logger = factory.resetLogger();

        assertTrue(logger.getLogs().isEmpty());
    }

    @Test
    public void canResetFileLoggerTwice() {
        Logger logger = factory.getLogger();
        logger.log("Log1");

        Logger newLogger = factory.resetLogger();
        assertTrue(newLogger.getLogs().isEmpty());
    }

    @Test
    public void isSingletonLogger() {
        Logger logger = factory.getLogger();

        Logger newLogger = factory.getLogger();
        assertTrue(logger == newLogger);
    }

    @Test
    public void isLoggerReset() {
        Logger logger = factory.getLogger();

        Logger newLogger = factory.resetLogger();
        assertTrue(logger != newLogger);
    }

    @Test
    public void canLoginString() {
        Logger logger = factory.getLogger();
        logger.log("Log1");
        assertTrue(logger.getLogs().size() == 1);
    }

    @Test
    public void canLoginStringValue() {
        Logger logger = factory.getLogger();
        logger.log("Log1");
        assertEquals("Log1", logger.getLogs().get(0));
    }

    @Test
    public void canLoginTwoStringValue() {
        Logger logger = factory.getLogger();

        logger.log("Log1");
        logger.log("Log2");
        assertEquals("Log2", logger.getLogs().get(1));
    }

    @Test
    public void canLogTwoLoggerStringValue() {
        Logger logger1 = factory.getLogger();
        Logger logger2 = factory.getLogger();
        logger1.log("Log1");
        logger2.log("Log2");

        List expectedList = new LinkedList<String>() {
            {
                add("Log1");
                add("Log2");
            }
        };

        assertArrayEquals(expectedList.toArray(), logger2.getLogs().toArray());
    }

    @Test(expected = RuntimeException.class)
    public void canLogToNotFile() {
        TextLogger logger = mock(TextLogger.class);
        doCallRealMethod().when(logger).log(any(String.class));

        logger.log("real");
    }

    @Test(expected = RuntimeException.class)
    public void canGetLogsFromNotFile() {
        TextLogger logger = mock(TextLogger.class);
        when(logger.getLogs()).thenCallRealMethod();

        logger.getLogs();
    }
}
