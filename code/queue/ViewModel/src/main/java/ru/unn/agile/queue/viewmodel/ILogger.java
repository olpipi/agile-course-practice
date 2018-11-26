package ru.unn.agile.queue.viewmodel;

import java.util.List;

public interface ILogger {
    void log(final String message);

    List<String> getLog();
}
