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

    public static final String FORMAT_ERROR = "Неверный формат полинома ";

    public String firstPolynomialStr() {
        return firstPolynomialStr.get();
    }

    public void setFirstPolynomialStr(final String firstPolynomialStr) {
        this.firstPolynomialStr.set(firstPolynomialStr);
    }

    public String secondPolynomialStr() {
        return secondPolynomialStr.get();
    }

    public void setSecondPolynomialStr(final String secondPolynomialStr) {
        this.secondPolynomialStr.set(secondPolynomialStr);
    }

    public String resultStr() {
        return resultStr.get();
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

    public void add(final String polynomialStr1, final String polynomialStr2) {
        Polynomial p1 = parsePolynomial(polynomialStr1);
        Polynomial p2 = parsePolynomial(polynomialStr2);
        if (checkError(p1, p2)) {
            setResultStr(p1.add(p2).toString());
        }
    }

    public void subtract(final String polynomialStr1, final String polynomialStr2) {
        Polynomial p1 = parsePolynomial(polynomialStr1);
        Polynomial p2 = parsePolynomial(polynomialStr2);
        if (checkError(p1, p2)) {
            setResultStr(p1.subtract(p2).toString());
        }
    }

    public void multiply(final String polynomialStr1, final String polynomialStr2) {
        Polynomial p1 = parsePolynomial(polynomialStr1);
        Polynomial p2 = parsePolynomial(polynomialStr2);
        if (checkError(p1, p2)) {
            setResultStr(p1.multiply(p2).toString());
        }
    }

    private boolean checkError(Polynomial p1, Polynomial p2) {
        if (p1 == null && p2 == null) {
            setResultStr(FORMAT_ERROR + "1 и 2");
            return false;
        } else if (p1 == null) {
            setResultStr(FORMAT_ERROR + "1");
            return false;
        } else if (p2 == null) {
            setResultStr(FORMAT_ERROR + "2");
            return false;
        }
        return true;
    }

    private void initDefaultFields() {
        firstPolynomialStr.set("");
        secondPolynomialStr.set("");
        resultStr.set("");
    }
}
