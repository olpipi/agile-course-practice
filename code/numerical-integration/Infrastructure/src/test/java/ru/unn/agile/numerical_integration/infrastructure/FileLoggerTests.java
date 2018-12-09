package ru.unn.agile.numerical_integration.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class FileLoggerTests {
    private static final String LOG_NAME = "numerical_integration.log";
    private static final Path LOG_PATH = FileSystems.getDefault().getPath(LOG_NAME);
    private FileLogger logger;

    @After
    public void tearDown() throws IOException {
        logger.close();
        logger = null;
        Files.deleteIfExists(LOG_PATH);
    }

    @Test
    public void canCreateFile()  throws IOException {
        logger = new FileLogger(LOG_NAME);

        assertTrue(Files.exists(LOG_PATH));
    }

    @Test
    public void canCreateFileLoggerIfFileAlreadyExists()  throws IOException {
        logger = new FileLogger(LOG_NAME);
        logger.close();
        logger = null;
        logger = new FileLogger(LOG_NAME);

        assertTrue(Files.exists(LOG_PATH));
    }

    @Test
    public void canLogMessage() throws IOException {
        logger = new FileLogger(LOG_NAME);

        logger.log("Ololo");

        BufferedReader br = Files.newBufferedReader(LOG_PATH);

        assertTrue(br.readLine().contains("Ololo"));
    }

    @Test
    public void canLogMessageIfFileAlreadyExists() throws IOException {
        logger = new FileLogger(LOG_NAME);
        logger.close();
        logger = null;
        logger = new FileLogger(LOG_NAME);

        logger.log("Ololo");

        BufferedReader br = Files.newBufferedReader(LOG_PATH);

        assertTrue(br.readLine().contains("Ololo"));
    }

    @Test
    public void canGetLog() throws  IOException {
        logger = new FileLogger(LOG_NAME);
        logger.log("Ololo");
        assertTrue(logger.getLog().get(0).contains("Ololo"));
    }
}
