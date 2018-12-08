package ru.unn.agile.ArraySorter.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class FakeLogger implements ILogger{
    private ArrayList<String> log = new ArrayList<>();

    @Override
    public void log(final String message_to_log) {
        log.add(message_to_log);
    }

    @Override
    public List<String> getLog() {
        return log;
    }
}
