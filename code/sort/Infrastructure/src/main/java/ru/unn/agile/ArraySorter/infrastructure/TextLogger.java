package ru.unn.agile.ArraySorter.infrastructure;

import ru.unn.agile.ArraySorter.viewmodel.ILogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TextLogger implements ILogger {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final BufferedWriter writer;
    private final String filename;

    public TextLogger(final String filename) {
        this.filename = filename;

        BufferedWriter logWriter = null;
        try {
            logWriter = new BufferedWriter(new FileWriter(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer = logWriter;
    }

    private static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.ENGLISH);
        return sdf.format(cal.getTime());
    }

    @Override
    public void log(final String messageToLog) {
        try {
            writer.write(getCurrentDateTime() + " > " + messageToLog);
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<String> getLog() {
        ArrayList<String> log = new ArrayList<>();
        try {
            FileReader fileReder = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReder);
            String line = reader.readLine();

            while (line != null) {
                log.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return log;
    }
}
