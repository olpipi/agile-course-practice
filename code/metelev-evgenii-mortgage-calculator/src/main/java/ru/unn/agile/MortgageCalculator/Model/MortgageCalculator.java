package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private String typeOfPayment;
    private String typeOfDate;
    private double fullCostOfApartment;
    private double initialPayment;
    private int dateOfMortgage;
    private double interestRate;
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
        if (fullCostOfApartment<=0) setFullCostOfApartment(firstPayment+1);
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

    public void setInterestRate(double procent) {
        interestRate = -1;
        if (procent>=0 && procent<=100)
            interestRate = procent;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPrincipalDebt() {
        return fullCostOfApartment/dateOfMortgage;
    }
}
