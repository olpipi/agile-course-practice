package ru.unn.agile.calculator.viewmodel;

/**
 * Created by Maria Pronina.
 */

enum Status {
    WAIT_FOR_INPUT("Please input numbers"),
    READY("Press 'Calculate' button to see result"),
    INPUT_INVALID("Please check your input"),
    SUCCESS("Success");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

