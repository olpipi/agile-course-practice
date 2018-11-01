package ru.unn.agile.salarycalculator.model;

import java.time.LocalDate;

public class CalculateSalary {
    private static final double NDS = 0.87;
    private static final int WORK_HOUR_IN_DAY = 8;
    private static final int DEFAULT_VACATION_YEAR = 2010;
    private static final int MAX_HOUR_IN_MONTH = 500;
    private static final double MAX_SALARY = 1000000000;

    private double salary;
    private  int workedHourInMonth;
    private int lengthOfVacation;
    private LocalDate startOfVacation;
    private LocalDate countingMonth;

    public CalculateSalary() {
        this.salary = 0;
        this.workedHourInMonth = 0;
        this.lengthOfVacation = 0;
        this.startOfVacation = LocalDate.of(DEFAULT_VACATION_YEAR, 1, 1);
        this.countingMonth = LocalDate.now();
    }

    public void setSalary(final double inSalary) {
        if (inSalary < 0) {
            throw new NumberFormatException("Отрицательнная зарплата");
        }
        if (inSalary > MAX_SALARY) {
            throw new NumberFormatException("Не допустимое значение");
        }
        this.salary = inSalary;
    }

    public void setWorkedHourInMonth(final int inWorkedHourInMonth) {
        if (inWorkedHourInMonth < 0) {
            throw new NumberFormatException("Отрицательное значение");
        }
        if (inWorkedHourInMonth > MAX_HOUR_IN_MONTH) {
            throw new NumberFormatException("Превышено максимальное");
        }
        this.workedHourInMonth = inWorkedHourInMonth;
    }

    public void setLengthOfVacation(final int inLengthOfVacation) {
        if (inLengthOfVacation < 0) {
            throw new NumberFormatException("Отрицательная длина отпуска");
        }
        this.lengthOfVacation = inLengthOfVacation;
    }
    public void setStartOfVacation(final LocalDate inStartOfVacation) {
        this.startOfVacation = inStartOfVacation;
    }

    public void setCountingMonth(final LocalDate isCountingMonth) {
        this.countingMonth = isCountingMonth;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getWorkedHourInMonth() {
        return this.workedHourInMonth;
    }

    public int getLengthOfVacation() {
        return this.lengthOfVacation;
    }

    public LocalDate getStartOfVacation() {
        return  this.startOfVacation;
    }
}
