package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private String typeOfPayment;
    private float fullCostOfApartment;
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

    public void setFullCostOfApartment(float sum) {
        if (sum>0)
            fullCostOfApartment = sum;
        else
            fullCostOfApartment = -1;
    }

    public float getFullCostOfApartment() {
        return fullCostOfApartment;
    }
}
