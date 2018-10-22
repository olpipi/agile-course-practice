package ru.unn.agile.MortgageCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;
public class MortgageCalculatorTest {

    @Test
    public void geTypeOfPayment() {
        MortgageCalculator myMortgageCalculator = new MortgageCalculator();

        myMortgageCalculator.setTypeOfPaymaent("Annuity");

        assertEquals("annuity",myMortgageCalculator.getTypeOfPaymaent());
    }
}
