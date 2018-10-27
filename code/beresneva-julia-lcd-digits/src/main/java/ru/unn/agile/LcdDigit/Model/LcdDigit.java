package ru.unn.agile.LcdDigit.Model;

import java.util.Objects;

public class LcdDigit {
    private int number;
    private String lcd;

    public LcdDigit(final int incomingNumber) {
        this.number = incomingNumber;
        this.lcd = "";
    }

    private String convertToLcd(final int incomingNumber) {
        String stringNumber = String.valueOf(incomingNumber);

        String firstLine = "";
        String secondLine = "";
        String thirdLine = "";

        for (char ch: stringNumber.toCharArray()) {
            firstLine = firstLine + toHeadOfLcd(ch) + " ";
        }

        for (char ch: stringNumber.toCharArray()) {
            secondLine = secondLine + toMiddleOFLcd(ch) + " ";
        }

        for (char ch: stringNumber.toCharArray()) {
            thirdLine = thirdLine + toBottomOfLcd(ch) + " ";
        }

        return firstLine + "\n" + secondLine + "\n" + thirdLine + "\n";
    }

    private String toHeadOfLcd(final char digit) {
        String head = "";
        switch (digit) {
            case '1':
            case '4':
                head = "...";
                break;
            default:
                head = "._.";
                break;
        }
        return head;
    }

    private String toMiddleOFLcd(final char digit) {
        String mid = "";
        switch (digit) {
            case '0':
                mid = "|.|";
                break;
            case '1':
            case '7':
                mid = "..|";
                break;
            case '2':
            case '3':
                mid = "._|";
                break;
            case '5':
            case '6':
                mid = "|_.";
                break;
            default: // in case 4,8,9
                mid = "|_|";
                break;
        }
        return mid;
    }

    private String toBottomOfLcd(final char digit) {
        String bottom = "";
        switch (digit) {
            case '0':
            case '6':
            case '8':
                bottom = "|_|";
                break;
            case '2':
                bottom = "|_.";
                break;
            case '3':
            case '5':
                bottom = "._|";
                break;
            default: //in case of 1,4,7,9
                bottom = "..|";
                break;
        }
        return bottom;
    }

    public void printIt() {
        String str = getLcd();
        System.out.print(str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, lcd);
    }

    public boolean equals(final Object object) {
        LcdDigit other = (LcdDigit) object;
        return other.getNumber() == getNumber() && other.getLcd().equals(getLcd());
    }

    public void setNumber(final int incomingNumber) {
        this.number = incomingNumber;
    }

    public int getNumber() {
        return number;
    }

    private void setLcd() {
        this.lcd = convertToLcd(number);
    }

    public String getLcd() {
        this.lcd = convertToLcd(number);
        return lcd;
    }
}
