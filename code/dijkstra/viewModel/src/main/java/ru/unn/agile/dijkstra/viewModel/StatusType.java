package ru.unn.agile.dijkstra.viewModel;

public enum StatusType {
    NO_INPUT("Please provide input data"),
    BAD_FORMAT("Bad format"),
    SUCCESS("Success");

    private final String defaultMessage;
    StatusType(final String name) {
        this.defaultMessage = name;
    }
    public String getDefaultMessage() {
        return defaultMessage;
    }
}
