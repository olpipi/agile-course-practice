package ru.unn.agile.ArraySorter.viewmodel;

import java.util.List;

public interface ILogger {
    void log(String message_to_log);

    List<String> getLog();
}
