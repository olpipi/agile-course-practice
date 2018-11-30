package ru.unn.agile.primenumber.infrastructure;

import java.io.IOException;

public class LoggerFactory {
    private static final String PATH_LOG_FILE = "build/logs.log";

    public Logger getLogger() {
        try {

            return new TextLogger
                    .TextLoggerBuilder()
                    .setFileName(PATH_LOG_FILE)
                    .build();

        } catch (IOException e) {
            throw new RuntimeException("Log File con not be allocated");
        }
    }
}
