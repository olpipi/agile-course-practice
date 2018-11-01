package ru.unn.agile.salarycalculator.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateSalaryTests {
    private final double delta = 0.001;

    @Test
    public void canSetSalary() {
        CalculateSalary calcSalary = new CalculateSalary();
        calcSalary.setSalary(30000);
        assertEquals(30000, calcSalary.getSalary(), delta);
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetSalaryMinus() {
        CalculateSalary calcSalary = new CalculateSalary();
        calcSalary.setSalary(-1000);
    }

    @Test
    public void canSetWoredHourInMonth() {
        CalculateSalary calcSalary = new CalculateSalary();
        calcSalary.setWorkedHourInMonth(100);
        assertEquals(100, calcSalary.getWorkedHourInMonth());
    }

    @Test (expected = NumberFormatException.class)
    public void  canNotSetWoredHourInMonthMinus() {
        CalculateSalary calcSalary = new CalculateSalary();
        calcSalary.setWorkedHourInMonth(-100);
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetWorkedHourInMonthMoreMax() {
        CalculateSalary calcSalary = new CalculateSalary();
        calcSalary.setWorkedHourInMonth(600);
    }

    @Test
    public void canSetLenthOfVacation() {
        CalculateSalary calsSalary = new CalculateSalary();
        calsSalary.setLengthOfVacation(1000);
        assertEquals(1000, calsSalary.getLengthOfVacation());
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetLenthOfVacation() {
        CalculateSalary calsSalary = new CalculateSalary();
        calsSalary.setLengthOfVacation(-100);
    }
}
