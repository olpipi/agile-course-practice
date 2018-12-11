package ru.unn.agile.mortgagecalculator.viewmodel.legacy;
import ru.unn.agile.mortgagecalculator.viewmodel.legacy.ViewModel.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUpEmptyExample() {
        viewModel = new ViewModel();
        viewModel.setApartmentPrice("16000");
        viewModel.setInitialPayment("6000");
        viewModel.setInterestRate("20");
        viewModel.setTermMortgage("12");
    }

    @After
    public void deleteExampleViewModel() {
        viewModel = null;
    }

    @Test
    public void checkStatusInBegin() {
        viewModel = new ViewModel();
        assertEquals(Status.COUNT_WAITING, viewModel.getStatus());
    }

    @Test
    public void checkSetters() {
        viewModel.setApartmentPrice("16000");
        viewModel.setInitialPayment("6000");
        viewModel.setInterestRate("20");
        viewModel.setTermMortgage("12");

        assertEquals("16000", viewModel.getApartmentPrice());
        assertEquals("6000", viewModel.getInitialPayment());
        assertEquals("20", viewModel.getInterestRate());
        assertEquals("12", viewModel.getTermMortgage());
    }

    @Test
    public void checkStatusWhenReadyCalculate() {
        viewModel.checkCountFields();

        assertEquals(Status.READY_CALCULATE, viewModel.getStatus());
    }

    @Test
    public void checkStatusCash() {
        viewModel.checkCountFields();
        viewModel.calculateFullPriceMortgage();

        assertEquals(Status.FULL_PRICE_MORTGAGE, viewModel.getStatus());
    }

    @Test
    public void isLengthCharactersSalaryNotCorrect() {
        viewModel.setApartmentPrice("1000000000000000000000000");
        viewModel.checkCountFields();

        assertEquals(Status.BAD_APARTMENT_PRICE_FORMAT_NUMBERS, viewModel.getStatus());
    }

    @Test
    public void checkStatusWhenOneOfCountFieldEmpty() {
        viewModel.setTermMortgage("");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_TERM_FORMAT, viewModel.getStatus());
    }

    @Test
    public void checkStatusWhenCountInputWithChar() {
        viewModel.setInitialPayment("a");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_INITIAL_PAYMENT_COUNT_FORMAT, viewModel.getStatus());
    }

    @Test
    public void checkStatusWhenCountInputWithIncorrectMonth() {
        viewModel.setInterestRate("50");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_INTEREST_RATE_FORMAT_NUMBERS, viewModel.getStatus());
    }

    @Test
    public void checkStatusWhenCountInputWithIncorrectYear() {
        viewModel.setTermMortgage("400");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_TERM_FORMAT_NUMBERS, viewModel.getStatus());
    }

    @Test
    public void checkResultWithNormalParameters() {
        viewModel.checkCountFields();

        viewModel.calculateFullPriceMortgage();

        assertEquals("11083.30", viewModel.getFullPriceMortgage());
    }

    @Test
    public void checkResultWithOvertime() {
        viewModel.setInterestRate("11");
        viewModel.checkCountFields();

        viewModel.calculateFullPriceMortgage();

        assertEquals("10595.80", viewModel.getFullPriceMortgage());
    }

    @Test
    public void checkResultWithLessTime() {
        viewModel.setTermMortgage("24");
        viewModel.checkCountFields();

        viewModel.calculateFullPriceMortgage();

        assertEquals("12083.40", viewModel.getFullPriceMortgage());
    }


    @Test
    public void checkResultWithNegativeWorkedHours() {
        viewModel.setApartmentPrice("-140004");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_APARTMENT_PRICE_FORMAT_SIGN, viewModel.getStatus());
    }

    @Test
    public void checkResultWithNegativeSalary() {
        viewModel.setInitialPayment("-100");

        viewModel.checkCountFields();

        assertEquals(Status.BAD_INITIAL_PAYMENT_FORMAT_SIGN, viewModel.getStatus());
    }

    @Test
    public void checkStatusAndButtonWhenIncorrectDate() {
        viewModel.setInterestRate("35");
        viewModel.checkCountFields();

        assertEquals(Status.BAD_INTEREST_RATE_FORMAT_NUMBERS, viewModel.getStatus());
    }
}
