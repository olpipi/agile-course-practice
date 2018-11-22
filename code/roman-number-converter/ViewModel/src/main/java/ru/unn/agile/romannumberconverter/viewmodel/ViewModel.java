package ru.unn.agile.romannumberconverter.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.romannumberconverter.model.RomanNumberConverter;
import ru.unn.agile.romannumberconverter.model.errorhandling.RomanIncorrectValueExeption;

public class ViewModel {
    private static final String ERR_WRONG_ROMAN_VALUE = "Римское число введено неверно!";
    private static final String ERR_WRONG_ARABIC_VALUE = "Арабское число введено неверно!";
    private static final String SUCCESSFUL_STATUS = "Успешно";

    private StringProperty arabicValueStr = new SimpleStringProperty();
    private StringProperty romanValueStr = new SimpleStringProperty();
    private StringProperty convertStatus = new SimpleStringProperty();

    public String getArabicValueStr() {
        return arabicValueStr.get();
    }
    public void setArabicValueStr(final String arabicNewVal) { arabicValueStr.set(arabicNewVal); }

    public String getRomanValueStr() { return romanValueStr.get(); }
    public void setRomanValueStr(final String romanNewVal) { romanValueStr.set(romanNewVal); }

    public String getConvertStatus() { return convertStatus.get(); }

    public ViewModel() {
        initialize();
    }

    private void initialize() {
        arabicValueStr.set("");
        romanValueStr.set("");
    }

    public void convertArabicToRoman() {
        try {
            int intArabic = Integer.parseInt(getArabicValueStr());
            setRomanValueStr(RomanNumberConverter.convertToRoman(intArabic));
            convertStatus.set(SUCCESSFUL_STATUS);
        }
        catch(NumberFormatException ex) {
            convertStatus.set(ERR_WRONG_ARABIC_VALUE);
        }
    }

    public void convertRomanToArabic() {
        try {
            int intArabic = RomanNumberConverter.convertToArabic(getRomanValueStr());
            setArabicValueStr(Integer.toString(intArabic));
            convertStatus.set(SUCCESSFUL_STATUS);
        }
        catch(RomanIncorrectValueExeption ex) {
            convertStatus.set(ERR_WRONG_ROMAN_VALUE);
        }
    }
}
