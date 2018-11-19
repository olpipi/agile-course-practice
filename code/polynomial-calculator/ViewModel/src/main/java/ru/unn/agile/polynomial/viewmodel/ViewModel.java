package ru.unn.agile.polynomial.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;
import ru.unn.agile.polynomial.Model.Polynomial;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewModel {
    private final StringProperty firstPolynomialStr = new SimpleStringProperty();
    private final StringProperty secondPolynomialStr = new SimpleStringProperty();
    private final StringProperty resultStr = new SimpleStringProperty();

    private static final int GROUP_MATCH_1 = 1; // [-]?\d\.*\d*)x (-3)x^3
    private static final int GROUP_MATCH_2 = 2; // x\^(\d\.*\d*) -3x^(3)
    private static final int GROUP_MATCH_3 = 3; // ([-]?\d+\.*\d*)x (-5)x
    private static final int GROUP_MATCH_4 = 4; // ([-]?\d+\.*\d*) (-42.0)

    private static final String GROUP_MORE_FIRST_DEGREE = "([-]?\\d\\.*\\d*)x\\^(\\d\\.*\\d*)";
    private static final String GROUP_FIRST_DEGREE = "([-]?\\d+\\.*\\d*)x";
    private static final String GROUP_ZERO_DEGREE = "([-]?\\d+\\.*\\d*)";

    public StringProperty firstPolynomialStrProperty() {
        return firstPolynomialStr;
    }

    public void setFirstPolynomialStr(final String firstPolynomialStr) {
        this.firstPolynomialStr.set(firstPolynomialStr);
    }

    public StringProperty secondPolynomialStrProperty() {
        return secondPolynomialStr;
    }

    public void setSecondPolynomialStr(final String secondPolynomialStr) {
        this.secondPolynomialStr.set(secondPolynomialStr);
    }

    public String getResultStr() {
        return resultStr.get();
    }

    public StringProperty resultStrProperty() {
        return resultStr;
    }

    public void setResultStr(final String resultStr) {
        this.resultStr.set(resultStr);
    }

    public ViewModel() {
        initDefaultFields();
    }

    public Polynomial parsePolynomial(final String polynomialStr) {
        Pattern pattern = Pattern.compile(GROUP_MORE_FIRST_DEGREE
                + "|" + GROUP_FIRST_DEGREE
                + "|" + GROUP_ZERO_DEGREE);
        Matcher matcher = pattern.matcher(polynomialStr);
        ArrayList<Pair<Integer, Double>> array = new ArrayList<>();
        while (matcher.find()) {
            if (matcher.group(GROUP_MATCH_1) != null && matcher.group(GROUP_MATCH_2) != null) {
                array.add(new Pair<>(Integer.valueOf(matcher.group(GROUP_MATCH_2)),
                        Double.valueOf(matcher.group(GROUP_MATCH_1))));
            } else if (matcher.group(GROUP_MATCH_3) != null) {
                array.add(new Pair<>(1, Double.valueOf(matcher.group(GROUP_MATCH_3))));
            } else if (matcher.group(GROUP_MATCH_4) != null) {
                array.add(new Pair<>(0, Double.valueOf(matcher.group(GROUP_MATCH_4))));
            }
        }
        if (!array.isEmpty()) {
            double[] coeffs = new double[array.get(0).getKey() + 1];
            for (int i = 0; i < array.size(); i++) {
                coeffs[coeffs.length - 1 - array.get(i).getKey().intValue()]
                        = array.get(i).getValue().doubleValue();
            }
            return new Polynomial(coeffs);
        }
        return null;
    }

    private void initDefaultFields() {
        firstPolynomialStr.set("");
        secondPolynomialStr.set("");
        resultStr.set("");
    }
}
