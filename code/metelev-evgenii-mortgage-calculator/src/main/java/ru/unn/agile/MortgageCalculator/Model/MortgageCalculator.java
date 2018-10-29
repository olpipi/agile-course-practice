package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private String typeOfPayment;
    private String typeOfDate = "Months";
    private double fullCostOfApartment;
    private double initialPayment = 0;
    private int dateOfMortgage = 12;
    private double interestRate;
    private double[] fullPriceInTableView;
    private double[] accruedInterestInTableView;

    private static final int MONTHS_IN_YEAR = 12;
    private static final double IS_PERCENT = 0.01;
    MortgageCalculator(){
        setTypeOfPayment("");
    }
    MortgageCalculator(String typeOfPaymentParam){
        setTypeOfPayment(typeOfPaymentParam);
    }
    public void setTypeOfPayment(String AnnuityOrDifferentiated) {
        switch (AnnuityOrDifferentiated){
            case "Annuity":
                typeOfPayment = AnnuityOrDifferentiated;
                break;
            case "Differentiated":
                typeOfPayment = AnnuityOrDifferentiated;
                break;
            default:
                typeOfPayment = "NotCorrect";
                break;
        }

    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setFullCostOfApartment(double sum) {
        if (sum>0)
            fullCostOfApartment = sum;
        else
            fullCostOfApartment = -1;
    }

    public double getFullCostOfApartment() {
        return fullCostOfApartment;
    }

    public void setInitialPayment(double firstPayment) {
      //  if (fullCostOfApartment<=0) setFullCostOfApartment(firstPayment+1);
        if (firstPayment>=0 && firstPayment<=fullCostOfApartment)
            initialPayment = firstPayment;
        else
            initialPayment = -1;
    }

    public double getInitialPayment() {
        return initialPayment;
    }

    public void setTypeOfDate(String yearsOrMonths) {
        typeOfDate = "NotCorrect";
        if (yearsOrMonths == "Years" || yearsOrMonths == "Months")
            typeOfDate = yearsOrMonths;
    }

    public String getTypeOfDate() {
        return typeOfDate;
    }

    public void setDateOfMortgage(int date) {
        if (date>0)
            dateOfMortgage = date;
        else
            dateOfMortgage = -1;
    }

    public int getDateOfMortgage() {
        return dateOfMortgage;
    }

    public void setInterestRate(double percent) {
        interestRate = -1;
        if (percent>=0 && percent<=100)
            interestRate = percent;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPrincipalDebt() {
        return Math.round(fullCostOfApartment/dateOfMortgage*100)/100.00;
    }

    public double getAccruedInterest(double balanceOfFullCost) {
        return Math.round(balanceOfFullCost * interestRate*IS_PERCENT/MONTHS_IN_YEAR*100)/100.00;
    }

    public double getFullPrice(double balanceOfFullCost) {
        return Math.round((getPrincipalDebt() + getAccruedInterest(balanceOfFullCost))*100)/100.00;
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
}
