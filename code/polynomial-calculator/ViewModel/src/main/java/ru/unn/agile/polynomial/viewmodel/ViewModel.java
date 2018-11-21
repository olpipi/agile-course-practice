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

    public Polynomial parsePolynomial2(final String polynomialStr) {
        ArrayList<Pair<Integer, Double>> array = new ArrayList<>();
        double currentCoeff = 0;
        int currentDegree = 0;
        String digitStr = "";
        int i = 0;
        while (i < polynomialStr.length()) {
            if (polynomialStr.toCharArray()[i] == 'x') {
                currentCoeff = Double.valueOf(digitStr);
                currentDegree = 1;
                i++;
            } else if (Character.isDigit(polynomialStr.toCharArray()[i])
                    || polynomialStr.toCharArray()[i] == '.') {
                digitStr += polynomialStr.toCharArray()[i];
                if (i < polynomialStr.length())
                    i++;
                else
                    break;
                continue;
            } else if (polynomialStr.toCharArray()[i] == '+') {
                array.add(new Pair<>(currentDegree, currentCoeff));
                currentDegree = 0;
                currentCoeff =0.0;
                digitStr = "";
                i++;
            } else
                return null;
        }
        array.add(new Pair<>(currentDegree, Double.valueOf(digitStr)));
        if (!array.isEmpty()) {
            double[] coeffs = new double[array.get(0).getKey() + 1];
            for (int j = 0; j < array.size(); j++) {
                coeffs[coeffs.length - 1 - array.get(j).getKey().intValue()]
                        = array.get(j).getValue().doubleValue();
            }
            return new Polynomial(coeffs);
        }
        return null;
    }

    public String add(final String polynomialStr1, final String polynomialStr2) {
        return parsePolynomial(polynomialStr1).add(parsePolynomial(polynomialStr2)).toString();
    }

    public String subtract(final String polynomialStr1, final String polynomialStr2) {
        return parsePolynomial(polynomialStr1).subtract(parsePolynomial(polynomialStr2)).toString();
    }

    public String multiply(final String polynomialStr1, final String polynomialStr2) {
        return parsePolynomial(polynomialStr1).multiply(parsePolynomial(polynomialStr2)).toString();
    }

    private void initDefaultFields() {
        firstPolynomialStr.set("");
        secondPolynomialStr.set("");
        resultStr.set("");
    }
}
