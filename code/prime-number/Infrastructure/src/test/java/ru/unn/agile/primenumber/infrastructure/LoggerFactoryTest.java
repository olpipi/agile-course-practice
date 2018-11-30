package ru.unn.agile.primenumber.infrastructure;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoggerFactoryTest {

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
    public void canInitiateTextLogger() {
        Logger logger = factory.getLogger();

        assertTrue(logger instanceof TextLogger);
    }

    @Test
    public void canInitiateTextLoggerBuilder() throws IOException {
        Logger logger = new TextLogger
                .TextLoggerBuilder()
                .setFileName("build/logs.log")
                .build();
        assertTrue(logger.getLogs().isEmpty());
    }

    @Test(expected = FileNotFoundException.class)
    public void canInitiateTextLoggerBuilderWithEmptyString() throws IOException {
            new TextLogger
                    .TextLoggerBuilder()
                    .setFileName("")
                    .build();
    }

    @Test(expected = FileNotFoundException.class)
    public void canInitiateTextLoggerBuilderWithIncorrectString() throws IOException {
        new TextLogger
                .TextLoggerBuilder()
                .setFileName("  ")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void canInitiateTextLoggerBuilderWithoutFileName() {
        new TextLogger
                .TextLoggerBuilder()
                .build();
    }

    @Test
    public void canInitiateTextLoggerBuilderWithoutFileNameMessage() {
        try {
            new TextLogger
                    .TextLoggerBuilder()
                    .build();
        } catch (IllegalStateException e) {
            assertEquals("File name should be set", e.getMessage());
        }
    }
}
