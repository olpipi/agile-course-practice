package ru.unn.agile.salarycalculator.viewmodel.legacy;

import ru.unn.agile.salarycalculator.model.SalaryCalculator;

import java.time.LocalDate;
import java.util.Locale;

public class ViewModel {
    private static final int MAX_MONTH = 12;
    private static final int MAX_YEAR = 2019;
    private static final int MIN_YEAR = 2000;
    private static final int MAX_WORKED_HOURS = 500;
    private String salary;
    private String workedHours;
    private String countMonth;
    private String countYear;
    private String result;
    private String status;
    private boolean isCalculateButtonEnabled;

    public ViewModel() {
        salary = "";
        workedHours = "";
        countMonth = "";
        countYear = "";
        result = "";
        status = Status.COUNT_WAITING;
        isCalculateButtonEnabled = false;
    }

    public final class Status {
        public static final String COUNT_WAITING = "Please provide salary and count period";
        public static final String READY_CALCULATE = "Press 'Calculate' button";
        public static final String BAD_SALARY_FORMAT = "Salary must be more 0";
        public static final String BAD_COUNT_FORMAT = "Wrong format of count input";
        public static final String BAD_MONTH_FORMAT = "Month must be between 1 and 12";
        public static final String BAD_YEAR_FORMAT = "Year must be between 2000 and 2019";
        public static final String BAD_WORKED_HOURS_FORMAT =
                "Worked houses must be between 1 and 500";
        public static final String CASH = "This your cash";

        private Status() {
        }
    }

    public void checkCountFields() {
        status = Status.READY_CALCULATE;
        isCalculateButtonEnabled = isCountInputAvailable()
                && isDateCorrect()
                && isWorkedHoursCorrect()
                && isSalaryCorrect();
    }

    private boolean isSalaryCorrect() {
        if (Double.parseDouble(salary) < 0) {
            status = Status.BAD_SALARY_FORMAT;
            return false;
        }
        return true;
    }

    public void calculateSalary() {
        if (!isCalculateButtonEnabled) {
            return;
        }
        SalaryCalculator countPeriod = new SalaryCalculator();

        countPeriod.setSalary(Double.parseDouble(salary));

        countPeriod.setWorkedHourInMonth(Integer.parseInt(workedHours));

        countPeriod.setCountingMonth(LocalDate.of(Integer.parseInt(countYear),
                Integer.parseInt(countMonth),
                1));
        result = getMoneyFormatInCashValue(countPeriod);
        status = Status.CASH;
    }

    private String getMoneyFormatInCashValue(final SalaryCalculator countPeriod) {
        return String.format(Locale.ROOT, "%.2f", countPeriod.calculateSalaryWithNDS());
    }

    public boolean isCalculateButtonEnable() {
        return isCalculateButtonEnabled;
    }

    public void setSalary(final String inSalary) {
        if (inSalary.equals(this.salary)) {
            return;
        }
        this.salary = inSalary;
    }


    public void setWorkedHours(final String inWorkedHours) {
        if (inWorkedHours.equals(this.workedHours)) {
            return;
        }
        this.workedHours = inWorkedHours;
    }

    public void setCountMonth(final String inCountMonth) {
        if (inCountMonth.equals(this.countMonth)) {
            return;
        }
        this.countMonth = inCountMonth;
    }

    public void setCountYear(final String inCountYear) {
        if (inCountYear.equals(this.countYear)) {
            return;
        }
        this.countYear = inCountYear;
    }

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    private boolean isWorkedHoursCorrect() {
        int hours = Integer.parseInt(workedHours);
        if (hours <= MAX_WORKED_HOURS && hours > 0) {
            return true;
        }
        status = Status.BAD_WORKED_HOURS_FORMAT;
        return false;
    }

    private boolean isDateCorrect() {
        int checkingValue = Integer.parseInt(countMonth);
        if (!isCurrentMonthNumber(checkingValue)) {
            status = Status.BAD_MONTH_FORMAT;
            return false;
        }
        checkingValue = Integer.parseInt(countYear);
        if (!isCurrentYearNumber(checkingValue)) {
            status = Status.BAD_YEAR_FORMAT;
            return false;
        }
        return true;
    }

    private boolean isCurrentMonthNumber(final int checkingMonth) {
        return checkingMonth <= MAX_MONTH && checkingMonth > 0;
    }

    private boolean isCurrentYearNumber(final int checkingYear) {
        return checkingYear <= MAX_YEAR && checkingYear > MIN_YEAR;
    }


    private boolean isCountInputAvailable() {
        try {
            Double.parseDouble(salary);
            Integer.parseInt(workedHours);
            Integer.parseInt(countMonth);
            Integer.parseInt(countYear);
        } catch (NumberFormatException e) {
            status = Status.BAD_COUNT_FORMAT;
            return false;
        }
        return true;
    }

    public String getSalary() {
        return salary;
    }

    public String getWorkedHours() {
        return workedHours;
    }

    public String getCountMonth() {
        return countMonth;
    }

    public String getCountYear() {
        return countYear;
    }
}
