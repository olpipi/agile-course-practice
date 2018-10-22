package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private String typeOfPayment;
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
}
