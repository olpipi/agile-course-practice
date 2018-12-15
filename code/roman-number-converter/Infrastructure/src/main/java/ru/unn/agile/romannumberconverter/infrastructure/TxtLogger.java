package ru.unn.agile.romannumberconverter.infrastructure;

import ru.unn.agile.romannumberconverter.viewmodel.ILogger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TxtLogger implements ILogger {
    private static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
    private final String fileName;
    private final BufferedWriter writer;

    private static String getCurrentDateTime() {
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date());
    }

    public TxtLogger(final String fileName) {
        this.fileName = fileName;
        BufferedWriter logWriter = null;
        try {
            logWriter = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer = logWriter;
    }

    @Override
    public void log(final String message) {
        try {
            writer.write(getCurrentDateTime() + " -> " + message);
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getLog() {
        BufferedReader reader;
        List<String> logList = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                logList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logList;
    }
}