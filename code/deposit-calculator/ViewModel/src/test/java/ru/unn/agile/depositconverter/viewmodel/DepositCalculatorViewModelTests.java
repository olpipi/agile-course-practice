package ru.unn.agile.depositconverter.viewmodel;

import org.junit.Test;
import ru.unn.agile.depositconverter.model.AccruedInterest;
import ru.unn.agile.depositconverter.model.FrequencyOfCapitalization;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DepositCalculatorViewModelTests {
    private final double delta = 0.001;

    @Test
    public void byDefaultButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        assertTrue(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void byDefaultDepositAmountIs700000() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        assertEquals(700000, viewModel.getDepositAmountView(), delta);
    }

    @Test
    public void whenDepositAmountEmptyButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setDepositAmount("");
        assertFalse(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void whenDepositAmountClearButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setDepositAmount("700000");
        viewModel.setDepositAmount("");
        assertFalse(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void byDefaultTermPlacementIs12() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        assertEquals(12, viewModel.getTermPlacementView());
    }

    @Test
    public void whenTermPlacementEmptyButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setTermPlacement("");
        assertFalse(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void whenTermPlacementClearButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setTermPlacement("12");
        viewModel.setTermPlacement("");
        assertFalse(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void byDefaultInterestRateIs8() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        assertEquals(8, viewModel.getInterestRateView(), delta);
    }

    @Test
    public void whenInterestRateEmptyButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setInterestRate("");
        assertFalse(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void whenInterestRateClearButtonCalculateDisabled() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setInterestRate("12");
        viewModel.setInterestRate("");
        assertFalse(viewModel.isCalculatorButtonEnabled());
    }

    @Test
    public void accruedInterestIsAddToDeposit() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setAccruedInterest("addToDeposit");
        assertEquals(AccruedInterest.addToDeposit, viewModel.getAccruedInterest());
    }

    @Test
    public void accruedInterestIsPayment() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setAccruedInterest("payOut");
        assertEquals(AccruedInterest.payOut, viewModel.getAccruedInterest());
    }

    @Test
    public void frequencyOfCapitalizationIsOnceInMonth() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.setFrequencyOfCapitalization("onceInMonth");
        assertEquals(FrequencyOfCapitalization.onceMonth, viewModel.getFrequencyOfCapitalization());
    }

    @Test
    public void whenCalculateDefaultValuesRevenueIsCorrect() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.calculate();
        assertEquals("758099.65", viewModel.getRevenueWhenAddToDeposit());
    }

    @Test
    public void whenCalculateDefaultValuesIncomeIsCorrect() {
        DepositCalculatorViewModel viewModel = new DepositCalculatorViewModel();
        viewModel.calculate();
        assertEquals("58099.65", viewModel.getIncomeViewModel());
    }

}
