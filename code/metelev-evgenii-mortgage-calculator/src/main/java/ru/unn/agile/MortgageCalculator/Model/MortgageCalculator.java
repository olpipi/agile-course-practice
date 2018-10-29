package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private double fullCostOfApartment;
    private double initialPayment = 0;
    private int dateOfMortgage = MONTHS_IN_YEAR;
    private double interestRate;
    private double[] fullPriceInTableView;
    private double[] accruedInterestInTableView;

    private static final int MONTHS_IN_YEAR = 12;
    private static final double IS_PERCENT = 0.01;
    private static final double HUNDRED = 100;

    public void setFullCostOfApartment(final double sum) {
        if (sum > 0) {
            fullCostOfApartment = sum;
        }
        else {
            fullCostOfApartment = -1;
        }
    }

    public double getFullCostOfApartment() {
        return fullCostOfApartment;
    }

    public void setInitialPayment(final double firstPayment) {
        if (firstPayment >= 0 && firstPayment <= fullCostOfApartment){
            initialPayment = firstPayment;
        }
        else {
            initialPayment = -1;
        }
    }

    public double getInitialPayment() {
        return initialPayment;
    }

    public void setDateOfMortgage(int date) {
        if (date > 0) {
            dateOfMortgage = date;
        }
        else {
            dateOfMortgage = -1;
        }
    }

    public int getDateOfMortgage() {
        return dateOfMortgage;
    }

    public void setInterestRate(double percent) {
        interestRate = -1;
        if (percent >= 0 && percent <= 100) {
            interestRate = percent;
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPrincipalDebt() {
        fullCostOfApartment -= initialPayment;
        return round(fullCostOfApartment/dateOfMortgage);
    }

    public double getAccruedInterest(double balanceOfFullCost) {
        return round(balanceOfFullCost * interestRate*IS_PERCENT/MONTHS_IN_YEAR);
    }

    public double getFullPrice(double balanceOfFullCost) {
        return round(getPrincipalDebt() + getAccruedInterest(balanceOfFullCost));
    }

    public void setAccruedInterestInTableView() {
        accruedInterestInTableView = new double[dateOfMortgage];
        double balance = 0;
        for (int curMonth = 0; curMonth<dateOfMortgage; curMonth++){
            accruedInterestInTableView[curMonth] = getAccruedInterest(fullCostOfApartment-balance);
            balance+=getPrincipalDebt();
        }
    }

    public double[] getAccruedInterestInTableView() {
        return accruedInterestInTableView;
    }

    public double[] getFullPriceInTableView() {
        setAccruedInterestInTableView();
        fullPriceInTableView = new double[dateOfMortgage];
        for (int curMonth = 0; curMonth < dateOfMortgage; curMonth++){
            fullPriceInTableView[curMonth] = accruedInterestInTableView[curMonth] + getPrincipalDebt();
        }
        return fullPriceInTableView;
    }
    private double round(double roundedNum){
        return Math.round(roundedNum * HUNDRED) / HUNDRED;
    }
}
