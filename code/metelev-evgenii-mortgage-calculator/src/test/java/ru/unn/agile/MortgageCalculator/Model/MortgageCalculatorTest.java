package ru.unn.agile.MortgageCalculator.Model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MortgageCalculatorTest {
    @Test
    public void test()
    {
        MortgageCalculator calc = new MortgageCalculator();
        assertEquals(1, calc.testFunc());
    }
}
