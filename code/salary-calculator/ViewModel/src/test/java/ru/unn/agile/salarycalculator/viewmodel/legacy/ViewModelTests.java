package ru.unn.agile.salarycalculator.viewmodel.legacy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.salarycalculator.viewmodel.legacy.ViewModel.Status;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUpEmptyExample() {
        viewModel = new ViewModel();
    }

    @After
    public void deleteExample() {
        viewModel = null;
    }

    @Test
    public void checkDefaultEmptyParameters() {
        assertEquals("", viewModel.getSalary());
        assertEquals("", viewModel.getWorkedHours());
        assertEquals("", viewModel.getCountMonth());
        assertEquals("", viewModel.getCountYear());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void checkStatusInBegin() {
        assertEquals(Status.COUNT_WAITING, viewModel.getStatus());
    }

    @Test
    public void checkSetters() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("145");
        viewModel.setCountMonth("5");
        viewModel.setCountYear("2000");

        assertEquals("10000", viewModel.getSalary());
        assertEquals("145", viewModel.getWorkedHours());
        assertEquals("5", viewModel.getCountMonth());
        assertEquals("2000", viewModel.getCountYear());
    }

    @Test
    public void checkStatusWhenInputEmpty() {
        viewModel.calculateSalary();

        assertEquals(Status.COUNT_WAITING, viewModel.getStatus());
    }

    @Test
    public void checkStatusWhenOneOfCountFieldEmpty() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("150");
        viewModel.setCountMonth("5");
        viewModel.setCountYear("");

        viewModel.calculateSalary();

        assertEquals(Status.COUNT_WAITING, viewModel.getStatus());
        assertFalse(viewModel.isCalculateButtonEnable());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void checkStatusWhenCountInputWithChar() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("a");
        viewModel.setCountMonth("5");
        viewModel.setCountYear("2000");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_COUNT_FORMAT, viewModel.getStatus());
        assertFalse(viewModel.isCalculateButtonEnable());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void checkStatusWhenCountInputWithIncorrectMonth() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("200");
        viewModel.setCountMonth("50");
        viewModel.setCountYear("2000");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_MONTH_FORMAT, viewModel.getStatus());
        assertFalse(viewModel.isCalculateButtonEnable());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void checkStatusWhenCountInputWithIncorrectYear() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("200");
        viewModel.setCountMonth("5");
        viewModel.setCountYear("19191");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_YEAR_FORMAT, viewModel.getStatus());
        assertFalse(viewModel.isCalculateButtonEnable());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void checkStatusWhenVacationInputWithIncorrectYear() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("200");
        viewModel.setCountMonth("5");
        viewModel.setCountYear("1995");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_YEAR_FORMAT, viewModel.getStatus());
        assertFalse(viewModel.isCalculateButtonEnable());
        assertEquals("", viewModel.getResult());
    }


    @Test
    public void checkResultWithNormalParameters() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("184");
        viewModel.setCountMonth("10");
        viewModel.setCountYear("2014");
        viewModel.checkCountFields();
        viewModel.calculateSalary();

        assertEquals("8700.00", viewModel.getResult());
        assertEquals(Status.CASH, viewModel.getStatus());
        assertTrue(viewModel.isCalculateButtonEnable());
    }

    @Test
    public void checkResultWithOvertime() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("200");
        viewModel.setCountMonth("10");
        viewModel.setCountYear("2014");
        viewModel.checkCountFields();
        viewModel.calculateSalary();

        assertEquals("10213.04", viewModel.getResult());
        assertEquals(Status.CASH, viewModel.getStatus());
        assertTrue(viewModel.isCalculateButtonEnable());
    }

    @Test
    public void checkResultWithLessTime() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("154");
        viewModel.setCountMonth("10");
        viewModel.setCountYear("2014");
        viewModel.checkCountFields();
        viewModel.calculateSalary();

        assertEquals("7281.52", viewModel.getResult());
        assertEquals(Status.CASH, viewModel.getStatus());
        assertTrue(viewModel.isCalculateButtonEnable());
    }


    @Test
    public void checkResultWithNegativeWorkedHours() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("-144");
        viewModel.setCountMonth("10");
        viewModel.setCountYear("2014");
        viewModel.checkCountFields();

        assertEquals(Status.BAD_WORKED_HOURS_FORMAT, viewModel.getStatus());
    }

    @Test
    public void checkResultWithNegativeSalary() {
        viewModel.setSalary("-10000");
        viewModel.setWorkedHours("144");
        viewModel.setCountMonth("10");
        viewModel.setCountYear("2014");
        viewModel.checkCountFields();

        assertEquals(Status.BAD_SALARY_FORMAT, viewModel.getStatus());
    }

    @Test
    public void checkStatusAndButtonWhenIncorrectDate() {
        viewModel.setSalary("10000");
        viewModel.setWorkedHours("144");
        viewModel.setCountMonth("35");
        viewModel.setCountYear("2014");

        viewModel.checkCountFields();

        assertEquals("", viewModel.getResult());
        assertEquals(Status.BAD_MONTH_FORMAT, viewModel.getStatus());
        assertFalse(viewModel.isCalculateButtonEnable());
    }
}
