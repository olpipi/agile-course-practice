package ru.unn.agile.calculator.model;

import java.security.InvalidParameterException;

public class NumberConverter {
    public int parse(final String number)
    {
        return Integer.parseInt(getNumber(number), 2);
        /*if (number == "0b0")
        {
            return 0;
        }
        else if (number == "0b1")
        {
            return 1;
        }
        return 2;*/
        //return Integer.parseInt(number);
    }

    private String getNumber(final String number) {
        if ((number.length() < 3) || !number.substring(0, 2).equals("0b")) {
            throw new InvalidParameterException("Invalid number format");
        }
        return number.substring(2);
    }
}
