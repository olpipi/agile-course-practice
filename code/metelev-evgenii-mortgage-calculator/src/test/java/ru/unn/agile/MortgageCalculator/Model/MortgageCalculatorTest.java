package ru.unn.agile.MortgageCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;
public class MortgageCalculatorTest {

    @Test
    public void geTypeOfPaymentIsAnnuity() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setTypeOfPayment("Annuity");

        assertEquals("Annuity",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void geTypeOfPaymentIsDifferentiated() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setTypeOfPayment("Differentiated");

        assertEquals("Differentiated",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void geTypeOfPaymentIsNotCorrect() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setTypeOfPayment("NotCorrectType");

        assertEquals("NotCorrect",myMortgageCalculator.getTypeOfPayment());
    }
    @Test
    public void geTypeOfPaymentIsNumber() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setTypeOfPayment("0");

        assertEquals("NotCorrect",myMortgageCalculator.getTypeOfPayment());
    }
}
