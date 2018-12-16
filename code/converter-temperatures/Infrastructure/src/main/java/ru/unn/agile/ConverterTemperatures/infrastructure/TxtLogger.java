package ru.unn.agile.ConverterTemperatures.infrastructure;

import java.io.*;
import java.util.*;

import ru.unn.agile.ConverterTemperatures.viewmodel.ILogger;

public class TxtLogger implements ILogger {
    private final BufferedWriter writer;
    private final String filename;

    public TxtLogger(final String filename) {
        this.filename = filename;

        BufferedWriter logWriter = null;
        try {
            logWriter = new BufferedWriter(new FileWriter(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer = logWriter;
    }

    @Override
    public void log(final String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public List<String> getLog() {
        BufferedReader bufferReader;
        ArrayList<String> log = new ArrayList<String>();
        try {
            bufferReader = new BufferedReader(new FileReader(filename));
            String line = bufferReader.readLine();

            while (line != null) {
                log.add(line);
                line = bufferReader.readLine();
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        return log;
    }
}
