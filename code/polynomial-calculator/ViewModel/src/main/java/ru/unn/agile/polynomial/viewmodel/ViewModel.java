package ru.unn.agile.polynomial.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;
import ru.unn.agile.polynomial.model.Polynomial;

import java.util.ArrayList;

public class ViewModel {
    private StringProperty firstPolynomialStr = new SimpleStringProperty();
    private StringProperty secondPolynomialStr = new SimpleStringProperty();
    private StringProperty resultStr = new SimpleStringProperty();

    public static final String FORMAT_ERROR = "Неверный формат полинома ";

    public StringProperty firstPolynomialStrProperty() {
        return firstPolynomialStr;
    }

    public String getFirstPolynomialStr() {
        return firstPolynomialStr.get();
    }

    public void setFirstPolynomialStr(final String firstPolynomialStr) {
        this.firstPolynomialStr.set(firstPolynomialStr);
    }

    public StringProperty secondPolynomialStrProperty() {
        return secondPolynomialStr;
    }

    public String getSecondPolynomialStr() {
        return secondPolynomialStr.get();
    }

    public void setSecondPolynomialStr(final String secondPolynomialStr) {
        this.secondPolynomialStr.set(secondPolynomialStr);
    }

    public StringProperty resultStrProperty() {
        return resultStr;
    }

    public String getResultStr() {
        return resultStr.get();
    }

    public void setResultStr(final String resultStr) {
        this.resultStr.set(resultStr);
    }

    public ViewModel() {
        initDefaultFields();
    }

    public Polynomial parsePolynomial(final String polynomialStrSource) {
        String polynomialStr = polynomialStrSource.replaceAll("\\s+", "");
        if (polynomialStr.isEmpty()) {
            return null;
        }
        ArrayList<Pair<Integer, Double>> array = new ArrayList<>();
        String digitStr = "";
        String degreeStr = "0";
        boolean degreeDetected = false;
        boolean xDetected = false;
        boolean symbolPlusDetected = false;
        boolean symbolMinusDetected = false;
        boolean pointDetected = false;
        for (int i = 0; i < polynomialStr.length(); i++) {
            if (polynomialStr.toCharArray()[i] == 'x') {
                if (symbolMinusDetected) {
                    digitStr = "-1";
                } else if (symbolPlusDetected || i == 0) {
                    digitStr = "1";
                }
                symbolMinusDetected = false;
                symbolPlusDetected = false;
                xDetected = true;
                degreeStr = "1";
            } else if (Character.isDigit(polynomialStr.toCharArray()[i])
                    || polynomialStr.toCharArray()[i] == '.') {
                if (!Character.isDigit(polynomialStr.toCharArray()[i])
                        && (xDetected || symbolMinusDetected || symbolPlusDetected)) {
                    return null;
                } else {
                    xDetected = false;
                    symbolMinusDetected = false;
                    symbolPlusDetected = false;
                }

                if (polynomialStr.toCharArray()[i] == '.') {
                    pointDetected = true;
                }

                if (degreeDetected) {
                    degreeStr += polynomialStr.toCharArray()[i];
                } else {
                    digitStr += polynomialStr.toCharArray()[i];
                }
            } else if (polynomialStr.toCharArray()[i] == '-'
                    || polynomialStr.toCharArray()[i] == '+') {
                if (symbolMinusDetected || symbolPlusDetected) {
                    return null;
                }
                if (i != 0) {
                    array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
                }

                degreeDetected = false;
                degreeStr = "0";
                if (polynomialStr.toCharArray()[i] == '-') {
                    symbolMinusDetected = true;
                    digitStr = "-";
                } else {
                    symbolPlusDetected = true;
                    digitStr = "";
                }
            } else if (polynomialStr.toCharArray()[i] == '^') {
                if (xDetected) {
                    degreeDetected = true;
                    degreeStr = "";
                    xDetected = false;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        array.add(new Pair<>(Integer.valueOf(degreeStr), Double.valueOf(digitStr)));
        if (!array.isEmpty()) {
            double[] coeffs = new double[array.get(0).getKey() + 1];
            for (int i = 0; i < array.size(); i++) {
                coeffs[coeffs.length - 1 - array.get(i).getKey().intValue()]
                        += array.get(i).getValue().doubleValue();
            }
            return new Polynomial(coeffs);
        }

        return null;
    }

    public void add() {
        Polynomial p1 = parsePolynomial(getFirstPolynomialStr());
        Polynomial p2 = parsePolynomial(getSecondPolynomialStr());
        if (checkError(p1, p2)) {
            setResultStr(p1.add(p2).toString());
        }
    }

    public void subtract() {
        Polynomial p1 = parsePolynomial(getFirstPolynomialStr());
        Polynomial p2 = parsePolynomial(getSecondPolynomialStr());
        if (checkError(p1, p2)) {
            setResultStr(p1.subtract(p2).toString());
        }
    }

    public void multiply() {
        Polynomial p1 = parsePolynomial(getFirstPolynomialStr());
        Polynomial p2 = parsePolynomial(getSecondPolynomialStr());
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
