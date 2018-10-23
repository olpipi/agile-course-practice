package ru.unn.agile.MortgageCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;
public class MortgageCalculatorTest {

    final double epsilon = 0.000000001;
    final double isNotCorrectNum = -1;
    final String isNotCorrect = "NotCorrect";
    @Test
    public void checkTypeOfPaymentIsAnnuity() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("Annuity");
        assertEquals("Annuity",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkTypeOfPaymentIsDifferentiated() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("Differentiated");
        assertEquals("Differentiated",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkTypeOfPaymentIsNotCorrect() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("NotCorrectType");
        assertEquals(isNotCorrect,myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkTypeOfPaymentIsNumber() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("0");
        assertEquals(isNotCorrect,myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkTypeOfPaymentIsEmpty() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("");
        assertEquals(isNotCorrect,myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkFullCostOfApartment() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setFullCostOfApartment(100000.12);
        assertEquals(100000.12,myMortgageCalculator.getFullCostOfApartment(),epsilon);
    }
    @Test
    public void checkFullCostOfApartmentIsZero() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setFullCostOfApartment(0);
        assertEquals(isNotCorrectNum,myMortgageCalculator.getFullCostOfApartment(),epsilon);
    }
    @Test
    public void checkFullCostOfApartmentIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setFullCostOfApartment(-300);
        assertEquals(isNotCorrectNum,myMortgageCalculator.getFullCostOfApartment(),epsilon);
    }
    @Test
    public void checkInitialPayment() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setInitialPayment(50000.50);
        assertEquals(50000.50,myMortgageCalculator.getInitialPayment(),epsilon);
    }
    @Test
    public void checkInitialPaymentIsZero() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setInitialPayment(0);
        assertEquals(0,myMortgageCalculator.getInitialPayment(),epsilon);
    }
    @Test
    public void checkInitialPaymentIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setInitialPayment(-10000);
        assertEquals(isNotCorrectNum,myMortgageCalculator.getInitialPayment(),epsilon);
    }
    @Test
    public void checkInitialPaymentIsMoreThenFullCost() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setFullCostOfApartment(100000);
        myMortgageCalculator.setInitialPayment(100001);
        assertEquals(isNotCorrectNum,myMortgageCalculator.getInitialPayment(),epsilon);
    }

    @Test
    public void checkTypeOfDateIsYears() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfDate("Years");
        assertEquals("Years",myMortgageCalculator.getTypeOfDate());
    }
    @Test
    public void checkTypeOfDateIsMonths() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfDate("Months");
        assertEquals("Months",myMortgageCalculator.getTypeOfDate());
    }
    @Test
    public void checkTypeOfDateIsNotCorrect() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfDate("Something");
        assertEquals(isNotCorrect,myMortgageCalculator.getTypeOfDate());
    }
    @Test
    public void checkDateOfMortgage() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setDateOfMortgage(10);
        assertEquals(10,myMortgageCalculator.getDateOfMortgage());
    }
    @Test
    public void checkDateOfMortgageIs12() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setDateOfMortgage(12);
        assertEquals(12,myMortgageCalculator.getDateOfMortgage());
    }
    @Test
    public void checkDateOfMortgageIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setDateOfMortgage(-10);
        assertEquals(-1,myMortgageCalculator.getDateOfMortgage());
    }
}
