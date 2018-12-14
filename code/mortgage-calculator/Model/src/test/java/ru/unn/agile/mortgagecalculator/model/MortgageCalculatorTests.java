package ru.unn.agile.mortgagecalculator.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MortgageCalculatorTests {

    private static final double  EPSILON = 0.1;
    private MortgageCalculator myMortgageCalculator;

    @Before
    public void setUpEmptyExample() {
        myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setFullCostOfApartment(1000);
        myMortgageCalculator.setDateOfMortgage(12);
        myMortgageCalculator.setInterestRate(20);
    }

    @After
    public void deleteExampleViewModel() {
        myMortgageCalculator = null;
    }

    @Test
    public void checkThatFullCostOfApartmentCorrectInitialized() {
        myMortgageCalculator.setFullCostOfApartment(100000.12);

        assertEquals(100000.12, myMortgageCalculator.getFullCostOfApartment(), EPSILON);
    }

    @Test(expected = NullPointerException.class)
    public void checkIfFullCostOfApartmentIsZero() {
        myMortgageCalculator.setFullCostOfApartment(0);

    }

    @Test(expected = NullPointerException.class)
    public void checkIfFullCostOfApartmentIsNegative() {
        myMortgageCalculator.setFullCostOfApartment(-300);
    }

    @Test
    public void checkInitialPaymentCorrectInitialized() {
        myMortgageCalculator.setFullCostOfApartment(51000);
        myMortgageCalculator.setInitialPayment(50000.50);

        assertEquals(50000.50, myMortgageCalculator.getInitialPayment(), EPSILON);
    }

    @Test
    public void checkThatInitialPaymentIsZero() {
        myMortgageCalculator.setInitialPayment(0);

        assertEquals(0, myMortgageCalculator.getInitialPayment(), EPSILON);
    }

    @Test(expected = NullPointerException.class)
    public void checkInitialPaymentIsNegative() {
        myMortgageCalculator.setInitialPayment(-10000);

    }

    @Test(expected = NullPointerException.class)
    public void checkInitialPaymentIsMoreThenFullCost() {
        myMortgageCalculator.setInitialPayment(100001);

    }

    @Test
    public void checkDateOfMortgageInMonths() {
        myMortgageCalculator.setDateOfMortgage(10);

        assertEquals(10, myMortgageCalculator.getDateOfMortgage());
    }

    @Test(expected = NullPointerException.class)
    public void checkDateOfMortgageInMonthsIsNegative() {
        myMortgageCalculator.setDateOfMortgage(-2);

    }

    @Test(expected = NullPointerException.class)
    public void checkDateOfMortgageInMonthsIsZero() {
        myMortgageCalculator.setDateOfMortgage(0);

    }

    @Test
    public void checkInterestRate() {
        myMortgageCalculator.setInterestRate(50.0);

        assertEquals(50.0, myMortgageCalculator.getInterestRate(), EPSILON);
    }

    @Test(expected = NullPointerException.class)
    public void checkInterestRateIsNegative() {
        myMortgageCalculator.setInterestRate(-50.0);
    }

    @Test
    public void checkPrincipalDebtInOneMonth() {
        this.myMortgageCalculator.setInitialPayment(0);

        assertEquals(83.3, myMortgageCalculator.getPrincipalDebt(), EPSILON);
    }

    @Test
    public void checkPrincipalDebtInOneMonthWithInitialPayment() {
        myMortgageCalculator.setInitialPayment(100);

        assertEquals(75, myMortgageCalculator.getPrincipalDebt(), EPSILON);
    }

    @Test
    public void checkInterestCharges() {
        assertEquals(16.67, myMortgageCalculator.
                getAccruedInterest(myMortgageCalculator.getFullCostOfApartment()), EPSILON);
    }

    @Test
    public void checkFullPriceInFirstMonthOfDate() {
        assertEquals(100.0, myMortgageCalculator.
                getFullPrice(myMortgageCalculator.getFullCostOfApartment()), EPSILON);
    }

    @Test
    public void checkPrincipalDebtIsCorrect() {
        myMortgageCalculator.setFullCostOfApartment(500.02);
        myMortgageCalculator.setDateOfMortgage(myMortgageCalculator.getDateOfMortgage() - 6);

        assertEquals(83.33, myMortgageCalculator.getPrincipalDebt(), EPSILON);
    }

    @Test
    public void checkAccruedInterestIsCorrectInMiddleOfDate() {
        myMortgageCalculator.setFullCostOfApartment(500.02);
        myMortgageCalculator.setDateOfMortgage(myMortgageCalculator.getDateOfMortgage() - 6);

        assertEquals(8.33, myMortgageCalculator.
                getAccruedInterest(myMortgageCalculator.getFullCostOfApartment()), EPSILON);
    }

    @Test
    public void checkAccruedInterestIsCorrectInLastMonth() {
        myMortgageCalculator.setFullCostOfApartment(83.37);
        myMortgageCalculator.setDateOfMortgage(myMortgageCalculator.getDateOfMortgage() - 11);

        assertEquals(1.39, myMortgageCalculator.
                getAccruedInterest(myMortgageCalculator.getFullCostOfApartment()), EPSILON);
    }

    @Test
    public void checkAccruedInterestInTableView() {
        double[] expectedPayments = {16.67, 15.28, 13.89, 12.50,
                11.11, 9.72, 8.33, 6.94, 5.56, 4.17, 2.78, 1.39};
        double[] actualInterest;
        myMortgageCalculator.setAccruedInterestArray();
        actualInterest = myMortgageCalculator.getAccruedInterestArray();

        assertArrayEquals(expectedPayments, actualInterest, EPSILON);
    }

    @Test
    public void checkFullPriceInTableView() {
        double[] expectedPayments = {100, 98.61, 97.22, 95.83,
                94.44, 93.05, 91.66, 90.27, 88.89, 87.50, 86.11, 84.72};
        double[] actualPayments;

        myMortgageCalculator.setFullPriceArray();
        actualPayments = myMortgageCalculator.getFullPriceArray();

        assertArrayEquals(expectedPayments, actualPayments, EPSILON);
    }

    @Test
    public void checkFullPriceForMortgage() {
        myMortgageCalculator.setFullPriceArray();

        assertEquals(1108.34, myMortgageCalculator.getFullPriceForMortgage(), EPSILON);
    }

    @Test
    public void checkFullPriceArrayStrings() {
        String[] expectedFullPriceStrings = {"100.00", "98.61", "97.22", "95.83",
                "94.44", "93.05", "91.66", "90.27", "88.89", "87.50", "86.11", "84.72"};
        String[] actualFullPriceArray;

        myMortgageCalculator.setFullPriceArray();
        actualFullPriceArray = myMortgageCalculator.getFullPriceArrayStrings();

        assertArrayEquals(expectedFullPriceStrings, actualFullPriceArray);
    }

    @Test
    public void checkAccruedInterestArrayStrings() {
        String[] expectedAccruedInterest = {"16.67", "15.28", "13.89", "12.50",
                "11.11", "9.72", "8.33", "6.94", "5.56", "4.17", "2.78", "1.39"};
        String[] actualInterestArray;

        myMortgageCalculator.setAccruedInterestArray();
        actualInterestArray = myMortgageCalculator.getAccruedInterestArrayStrings();

        assertArrayEquals(expectedAccruedInterest, actualInterestArray);
    }


}
