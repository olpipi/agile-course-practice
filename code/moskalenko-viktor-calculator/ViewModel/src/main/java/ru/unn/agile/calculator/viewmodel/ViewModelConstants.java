package ru.unn.agile.calculator.viewmodel;

import ru.unn.agile.calculator.model.NumberSystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maria Pronina.
 */
public class ViewModelConstants {
    private ViewModelConstants() {
        // no instance
    }
    public static String BINARY_SYSTEM_STR = "Binary";
    public static String OCTAL_SYSTEM_STR = "Octal";
    public static String HEXADECIMAL_SYSTEM_STR = "Hexadecimal";
    public static final Map<NumberSystem, String> systemsToFieldNames;
    static {
        Map<NumberSystem, String> aMap = new HashMap<>();
        aMap.put(NumberSystem.BINARY, BINARY_SYSTEM_STR);
        aMap.put(NumberSystem.OCTAL, OCTAL_SYSTEM_STR);
        aMap.put(NumberSystem.HEXADECIMAL, HEXADECIMAL_SYSTEM_STR);
        systemsToFieldNames = Collections.unmodifiableMap(aMap);
    }
}
