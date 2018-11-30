package ru.unn.agile.primenumber.infrastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

}
