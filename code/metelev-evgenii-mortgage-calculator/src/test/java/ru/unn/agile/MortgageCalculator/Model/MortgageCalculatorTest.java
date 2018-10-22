package ru.unn.agile.MortgageCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;
public class MortgageCalculatorTest {

    final double epsilon = 0.000000001;
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
        assertEquals("NotCorrect",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkTypeOfPaymentIsNumber() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("0");
        assertEquals("NotCorrect",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void checkTypeOfPaymentIsEmpty() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setTypeOfPayment("");
        assertEquals("NotCorrect",myMortgageCalculator.getTypeOfPayment());
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
        assertEquals(-1,myMortgageCalculator.getFullCostOfApartment(),epsilon);
    }
    @Test
    public void checkFullCostOfApartmentIsNegative() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();
        myMortgageCalculator.setFullCostOfApartment(-300);
        assertEquals(-1,myMortgageCalculator.getFullCostOfApartment(),epsilon);
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
        assertEquals(-1,myMortgageCalculator.getInitialPayment(),epsilon);
    }

}
