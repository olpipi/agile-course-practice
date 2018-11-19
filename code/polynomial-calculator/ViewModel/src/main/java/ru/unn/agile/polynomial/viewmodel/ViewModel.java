package ru.unn.agile.polynomial.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;
import ru.unn.agile.polynomial.model.Polynomial;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewModel {
    private final StringProperty firstPolynomialStr = new SimpleStringProperty();
    private final StringProperty secondPolynomialStr = new SimpleStringProperty();
    private final StringProperty resultStr = new SimpleStringProperty();

    private final int GROUP_MATCH_1 = 1;// [-]?\d\.*\d*)x (-3)x^3
    private final int GROUP_MATCH_2 = 2;// x\^(\d\.*\d*) -3x^(3)
    private final int GROUP_MATCH_3 = 3;// ([-]?\d+\.*\d*)x (-5)x
    private final int GROUP_MATCH_4 = 4;// ([-]?\d+\.*\d*) (-42.0)

    public StringProperty firstPolynomialStrProperty() {
        return firstPolynomialStr;
    }

    public void setFirstPolynomialStr(String firstPolynomialStr) {
        this.firstPolynomialStr.set(firstPolynomialStr);
    }

    public StringProperty secondPolynomialStrProperty() {
        return secondPolynomialStr;
    }

    public void setSecondPolynomialStr(String secondPolynomialStr) {
        this.secondPolynomialStr.set(secondPolynomialStr);
    }

    public String getResultStr() {
        return resultStr.get();
    }

    public StringProperty resultStrProperty() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr.set(resultStr);
    }

    public ViewModel() {
        initDefaultFields();
    }

    public Polynomial parsePolynomial(final String polynomialStr) {
        Pattern pattern =
                Pattern.compile("([-]?\\d\\.*\\d*)x\\^(\\d\\.*\\d*)|([-]?\\d+\\.*\\d*)x|([-]?\\d+\\.*\\d*)");
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
        double[] coeffs = new double[array.get(0).getKey() + 1];
        for (int i = 0; i < array.size(); i++) {
            coeffs[coeffs.length - 1 - array.get(i).getKey().intValue()]
                    = array.get(i).getValue().doubleValue();
        }
        return new Polynomial(coeffs);
    }

    private void initDefaultFields() {
        firstPolynomialStr.set("");
        secondPolynomialStr.set("");
        resultStr.set("");
    }
}