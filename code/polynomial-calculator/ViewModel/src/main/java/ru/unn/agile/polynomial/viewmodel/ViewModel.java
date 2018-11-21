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
        ArrayList<Pair<Integer, Double>> array = new ArrayList<>();
        String digitStr = "";
        String degreeStr = "";
        boolean degree = false;
        int i = 0;
        if (!polynomialStr.isEmpty()) {
            while (i < polynomialStr.length()) {
                if (polynomialStr.toCharArray()[i] == 'x') {
                    degreeStr = "1";
                    i++;
                } else if (Character.isDigit(polynomialStr.toCharArray()[i])
                        || polynomialStr.toCharArray()[i] == '.') {
                    if (degree) {
                        degreeStr += polynomialStr.toCharArray()[i];
                    } else {
                        digitStr += polynomialStr.toCharArray()[i];
                    }

                    if (i < polynomialStr.length())
                        i++;
                    else
                        break;
                    continue;
                } else if (polynomialStr.toCharArray()[i] == '+') {
                    array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
                    degreeStr = "0";
                    degree = false;
                    digitStr = "";
                    i++;
                } else if (polynomialStr.toCharArray()[i] == '-') {
                    if (i != 0)
                        array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
                    degree = false;
                    degreeStr = "0";
                    digitStr = "-";
                    i++;
                } else if (polynomialStr.toCharArray()[i] == '^') {
                    degree = true;
                    degreeStr = "";
                    i++;
                } else
                    return null;
            }
            if (!degreeStr.isEmpty())
                array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
            else
                array.add(new Pair<>(0, Double.valueOf(digitStr)));
            if (!array.isEmpty()) {
                double[] coeffs = new double[array.get(0).getKey() + 1];
                for (int j = 0; j < array.size(); j++) {
                    coeffs[coeffs.length - 1 - array.get(j).getKey().intValue()]
                            = array.get(j).getValue().doubleValue();
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
