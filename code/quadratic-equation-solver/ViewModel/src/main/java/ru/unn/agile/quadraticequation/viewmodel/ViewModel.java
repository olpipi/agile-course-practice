package ru.unn.agile.quadraticequation.viewmodel;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import ru.unn.agile.quadraticequation.model.QuadraticEquation;
import ru.unn.agile.quadraticequation.model.QuadraticEquationSolverException;
import javafx.beans.property.*;

import java.util.Arrays;
import java.util.List;

public class ViewModel {
    public static final String NO_QUADRATIC_COEFFICIENT_ERR = "Enter quadratic coefficient";
    public static final String NON_NUMERIC_COEFFICIENTS_ERR = "Coefficients must be numeric";
    public static final String EMPTY_COEFFICIENTS_ERR = "Coefficients must be not empty";
    public static final String NO_ROOTS_MESSAGE = "No roots";

    public static final String SOLVE_WAS_PRESSED = "Solved. ";

    private final StringProperty a = new SimpleStringProperty();
    private final StringProperty b = new SimpleStringProperty();
    private final StringProperty c = new SimpleStringProperty();

    private ILogger logger;

    public String getLogs() {
        return logs.get();
    }

    public StringProperty logsProperty() {
        return logs;
    }

    private final StringProperty logs = new SimpleStringProperty();

    private final StringProperty roots = new SimpleStringProperty();

    public final void setLogger(final ILogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger parameter can't be null");
        }
        this.logger = logger;
    }

    public ViewModel() {
        init();
    }

    private void init() {
        a.set("1");
        b.set("0");
        c.set("0");
        roots.set("");
    }

    public ViewModel(final ILogger logger) {
        a.set("0");
        b.set("0");
        c.set("0");
        roots.set("");

        if (logger == null) {
            throw new IllegalArgumentException("Logger parameter can't be null");
        }
        this.logger = logger;
    }

    public String getA() {
        return aProperty().get();
    }

    public String getB() {
        return bProperty().get();
    }

    public String getC() {
        return cProperty().get();
    }

    public String getRoots() {
        return rootsProperty().get();
    }

    public void setA(final String value) {
        aProperty().set(value);
    }

    public void setB(final String value) {
        bProperty().set(value);
    }

    public void setC(final String value) {
        cProperty().set(value);
    }

    public void solve() {
        QuadraticEquation quadraticEquation;
        if (a.get().isEmpty() || b.get().isEmpty() || c.get().isEmpty()) {
            roots.set(EMPTY_COEFFICIENTS_ERR);
            StringBuilder message = new StringBuilder(EMPTY_COEFFICIENTS_ERR);
            logger.log(message.toString());
            updateLogs();
            return;
        }
        try {
            quadraticEquation = new QuadraticEquation(
                    Double.parseDouble(a.get()),
                    Double.parseDouble(b.get()),
                    Double.parseDouble(c.get()));
        } catch (NumberFormatException e) {
            roots.set(NON_NUMERIC_COEFFICIENTS_ERR);
            StringBuilder message = new StringBuilder(NON_NUMERIC_COEFFICIENTS_ERR);
            logger.log(message.toString());
            updateLogs();
            return;
        } catch (IllegalArgumentException e) {
            roots.set(NO_QUADRATIC_COEFFICIENT_ERR);
            StringBuilder message = new StringBuilder(NO_QUADRATIC_COEFFICIENT_ERR);
            logger.log(message.toString());
            updateLogs();
            return;
        }
        double[] equationRoots;
        try {
            equationRoots = quadraticEquation.solve();
        } catch (QuadraticEquationSolverException e) {
            roots.set(NO_ROOTS_MESSAGE);
            StringBuilder message = new StringBuilder(NO_ROOTS_MESSAGE);
            logger.log(message.toString());
            updateLogs();
            return;
        }
        roots.set(Arrays.toString(equationRoots));

        StringBuilder message = new StringBuilder(SOLVE_WAS_PRESSED);
        message.append("Arg: a = ").append(a.get())
                .append("; b = ").append(b.get())
                .append("; c = ").append(c.get())
                .append("; roots = ").append(roots.get());
        logger.log(message.toString());
        updateLogs();
    }

    public StringProperty aProperty() {
        return a;
    }

    public StringProperty bProperty() {
        return b;
    }

    public StringProperty cProperty() {
        return c;
    }

    public StringProperty rootsProperty() {
        return roots;
    }

    public List<String> getLog() {
        return logger.getLog();
    }

    private void updateLogs() {
        List<String> fullLog = logger.getLog();
        String record = new String("");
        for (String log : fullLog) {
            record += log + "\n";
        }
        logs.set(record);
    }


    private class ValueCachingChangeListener implements ChangeListener<String> {
        private String prevValue = new String("");
        private String curValue = new String("");

        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            if (oldValue.equals(newValue)) {
                return;
            }
            //status.set(getInputStatus().toString());
            curValue = newValue;
        }

        public boolean isChanged() {
            return !prevValue.equals(curValue);
        }

        public void cache() {
            prevValue = curValue;
        }
    }
}
