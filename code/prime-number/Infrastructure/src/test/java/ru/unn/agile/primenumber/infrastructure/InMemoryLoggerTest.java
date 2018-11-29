package ru.unn.agile.primenumber.infrastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InMemoryLoggerTest {

    @Test
    public void canLogString() {
        Logger logger = new InMemoryLogger();
        logger.log("1");

        assertEquals("1", logger.getLogs().get(0));
    }

    @Test
    public void canLogEmptyString() {
        Logger logger = new InMemoryLogger();
        logger.log("");

        assertEquals("", logger.getLogs().get(0));
    }

    @Test
    public void canLogTwoString() {
        Logger logger = new InMemoryLogger();
        logger.log("1");
        logger.log("2");

        assertEquals("2", logger.getLogs().get(1));
    }

    @Test
    public void defaultLoggerIsEmptyString() {
        Logger logger = new InMemoryLogger();
        assertTrue(logger.getLogs().isEmpty());
    }
}
