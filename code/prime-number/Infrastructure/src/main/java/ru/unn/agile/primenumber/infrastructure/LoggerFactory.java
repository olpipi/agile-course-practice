package ru.unn.agile.primenumber.infrastructure;

public class LoggerFactory {

    public Logger getLogger() {
        return new InMemoryLogger();
    }
}
