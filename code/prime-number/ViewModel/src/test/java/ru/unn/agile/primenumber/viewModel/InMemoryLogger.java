package ru.unn.agile.primenumber.viewModel;

import ru.unn.agile.primenumber.infrastructure.Logger;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLogger implements Logger {

    private final ArrayList<String> logs = new ArrayList<>();

    @Override
    public void log(final String s) {
        logs.add(s);
    }

    @Override
    public List<String> getLogs() {
        return logs;
    }
}
