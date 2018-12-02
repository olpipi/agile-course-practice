package ru.unn.agile.InfixToPostfixNotationConverter.infrastructure;

import ru.unn.agile.InfixToPostfixNotationConverter.viewmodel.ILogger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileLogger implements ILogger {
    private List<String> messages = new ArrayList<>();
    private BufferedWriter stream;

    public FileLogger(final String filePath) throws IOException {
        stream = Files.newBufferedWriter(
                FileSystems.getDefault().getPath(filePath));
    }

    public void log(final String message) {
        try {
            messages.add(message);
            stream.append(message);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getMessages() {
        return messages;
    }

    public void close() {
        try {
            messages.clear();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
