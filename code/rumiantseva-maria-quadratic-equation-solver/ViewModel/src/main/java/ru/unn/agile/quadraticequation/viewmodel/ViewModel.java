package ru.unn.agile.quadraticequation.viewmodel;

import ru.unn.agile.quadraticequation.model.QuadraticEquation;
import ru.unn.agile.quadraticequation.model.QuadraticEquationSolverException;
import javafx.beans.property.*;
import java.util.Arrays;

public class ViewModel {
    private final StringProperty a = new SimpleStringProperty();
    private final StringProperty b = new SimpleStringProperty();
    private final StringProperty c = new SimpleStringProperty();

    private final StringProperty roots = new SimpleStringProperty();

    public ViewModel() {
        a.set("0");
        b.set("0");
        c.set("0");
        roots.set("");
    }

    public void solve() {
        QuadraticEquation quadraticEquation;

        try {
            quadraticEquation = new QuadraticEquation(
                    Double.parseDouble(a.get()),
                    Double.parseDouble(b.get()),
                    Double.parseDouble(c.get()));
        }
        catch (Exception e) {
            if (e.getClass() == IllegalArgumentException.class)
            {
                roots.set("Enter quadratic coefficient");
                return;
            }

            if (e.getClass() == NumberFormatException.class)
            {
                roots.set("Coefficients must be numeric");
                return;
            }

            throw e;
        }

        double[] equationRoots;
        try {
            equationRoots = quadraticEquation.solve();
        }
        catch (QuadraticEquationSolverException e) {
            roots.set("No roots");
            return;
        }

        roots.set(Arrays.toString(equationRoots));
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
}
