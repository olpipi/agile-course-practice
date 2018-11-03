package ru.unn.agile.salarycalculator.model;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class CalculateSalaryTests {
    private final double delta = 0.01;

    @Test
    public void checkCalculateSalaryConstructor() {
        CalculateSalary calculator = new CalculateSalary();
        LocalDate date = LocalDate.of(2010, 1, 1);
        assertEquals(0, calculator.getSalary(), delta);
        assertEquals(0, calculator.getWorkedHourInMonth());
        assertEquals(0, calculator.getLengthOfVacation());
        assertEquals(date, calculator.getStartOfVacation());
        date = LocalDate.now();
        assertEquals(date, calculator.getCountingMonth());
    }

    @Test
    public void canSetSalary() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(30000);
        assertEquals(30000, calculator.getSalary(), delta);
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetSalaryMinus() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(-1000);
    }

    @Test
    public void canSetWoredHourInMonth() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setWorkedHourInMonth(100);
        assertEquals(100, calculator.getWorkedHourInMonth());
    }

    @Test (expected = NumberFormatException.class)
    public void  canNotSetWoredHourInMonthMinus() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setWorkedHourInMonth(-100);
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetWorkedHourInMonthMoreMax() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setWorkedHourInMonth(600);
    }

    @Test
    public void canSetLenthOfVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setLengthOfVacation(1000);
        assertEquals(1000, calculator.getLengthOfVacation());
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetLenthOfVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setLengthOfVacation(-100);
    }

    @Test (expected = NumberFormatException.class)
    public void canCalculateCashWithNegativeSalary() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(-10000);
        assertEquals(0, calculator.calculate(), delta);
    }

    @Test (expected = NumberFormatException.class)
    public void inputNegativeLengthOfVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setLengthOfVacation(-14);
        assertEquals(0, calculator.calculate(), delta);
    }

    @Test (expected = NumberFormatException.class)
    public void inputNegativeWorkedHours() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setWorkedHourInMonth(-180);
        assertEquals(0, calculator.calculate(), delta);
    }

    @Test (expected = NumberFormatException.class)
    public void inputOnlyNegativeWorkedHours() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(10000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.APRIL, 1));
        calculator.setWorkedHourInMonth(-200);
        assertEquals(0, calculator.calculate(), delta);
    }

    @Test
    public void canCalculateCashInNormalMonth() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(26000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.OCTOBER, 1));
        calculator.setWorkedHourInMonth(180);
        assertEquals(22128.26, calculator.calculate(), delta);
    }

    @Test
    public void canCalculateCashInNormalMonthWithOvertime() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.OCTOBER, 1));
        calculator.setWorkedHourInMonth(200);
        assertEquals(18383.48, calculator.calculate(), delta);
    }

    @Test
    public void canCalculateCashInNormalMonthWithLessHours() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.OCTOBER, 1));
        calculator.setWorkedHourInMonth(154);
        assertEquals(13106.74, calculator.calculate(), delta);
    }

    @Test
    public void countCashInMonthWith14DaysOfVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.OCTOBER, 1));
        calculator.setWorkedHourInMonth(104);
        calculator.setStartOfVacation(LocalDate.of(2018, Month.OCTOBER, 6));
        calculator.setLengthOfVacation(14);
        assertEquals(8851.31, calculator.calculate(), delta);
    }

    @Test
    public void countCashInMonthWithStartOfVacationAndFinishInAnother() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.OCTOBER, 1));
        calculator.setWorkedHourInMonth(144);
        calculator.setStartOfVacation(LocalDate.of(2018, Month.OCTOBER, 27));
        calculator.setLengthOfVacation(14);
        assertEquals(12255.65, calculator.calculate(), delta);
    }

    @Test
    public void countCashInMonthWithEndOfVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.NOVEMBER, 1));
        calculator.setWorkedHourInMonth(120);
        calculator.setStartOfVacation(LocalDate.of(2018, Month.OCTOBER, 27));
        calculator.setLengthOfVacation(14);
        assertEquals(10677.27, calculator.calculate(), delta);
    }

    @Test
    public void countCashInMonthWhichAllInVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(10000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.OCTOBER, 1));
        calculator.setWorkedHourInMonth(0);
        calculator.setStartOfVacation(LocalDate.of(2019, Month.SEPTEMBER, 27));
        calculator.setLengthOfVacation(50);
        assertEquals(0.0, calculator.calculate(), delta);
    }

    @Test
    public void countCashInMonthWhichInYearNotEqualYearOfVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.NOVEMBER, 1));
        calculator.setWorkedHourInMonth(160);
        calculator.setStartOfVacation(LocalDate.of(2019, Month.OCTOBER, 27));
        calculator.setLengthOfVacation(14);
        assertEquals(14236.36, calculator.calculate(), delta);
    }

    @Test
    public void countCashInMonthWithOvertimeAndWithoutVacation() {
        CalculateSalary calculator = new CalculateSalary();
        calculator.setSalary(18000);
        calculator.setCountingMonth(LocalDate.of(2018, Month.NOVEMBER, 1));
        calculator.setWorkedHourInMonth(160);
        assertEquals(14236.36, calculator.calculate(), delta);
    }
}
