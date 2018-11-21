package ru.unn.agile.polynomial.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;
import ru.unn.agile.polynomial.model.Polynomial;

import java.util.ArrayList;

public class ViewModel {
    private final StringProperty firstPolynomialStr = new SimpleStringProperty();
    private final StringProperty secondPolynomialStr = new SimpleStringProperty();
    private final StringProperty resultStr = new SimpleStringProperty();

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
        if (!polynomialStr.isEmpty()) {
            ArrayList<Pair<Integer, Double>> array = new ArrayList<>();
            String digitStr = "";
            String degreeStr = "0";
            boolean degree = false;
            for (int i = 0; i < polynomialStr.length(); i++) {
                if (polynomialStr.toCharArray()[i] == 'x') {
                    degreeStr = "1";
                } else if (Character.isDigit(polynomialStr.toCharArray()[i])
                        || polynomialStr.toCharArray()[i] == '.') {
                    if (degree) {
                        degreeStr += polynomialStr.toCharArray()[i];
                    } else {
                        digitStr += polynomialStr.toCharArray()[i];
                    }
                } else if (polynomialStr.toCharArray()[i] == '-'
                        || polynomialStr.toCharArray()[i] == '+') {
                    if (i != 0) {
                        array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
                    }
                    degree = false;
                    degreeStr = "0";
                    if (polynomialStr.toCharArray()[i] == '-') {
                        digitStr = "-";
                    } else {
                        digitStr = "";
                    }
                } else if (polynomialStr.toCharArray()[i] == '^') {
                    degree = true;
                    degreeStr = "";
                } else {
                    return null;
                }
            }
            array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
            if (!array.isEmpty()) {
                double[] coeffs = new double[array.get(0).getKey() + 1];
                for (int i = 0; i < array.size(); i++) {
                    coeffs[coeffs.length - 1 - array.get(i).getKey().intValue()]
                            = array.get(i).getValue().doubleValue();
                }
                return new Polynomial(coeffs);
            }
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
