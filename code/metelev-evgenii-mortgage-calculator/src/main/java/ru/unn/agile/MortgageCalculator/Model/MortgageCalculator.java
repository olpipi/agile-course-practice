package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private String typeOfPayment;
    private double fullCostOfApartment;
    private double initialPayment;
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
        if (firstPayment>=0)
            initialPayment = firstPayment;
        else
            initialPayment = -1;
    }

    public double getInitialPayment() {
        return initialPayment;
    }
}
