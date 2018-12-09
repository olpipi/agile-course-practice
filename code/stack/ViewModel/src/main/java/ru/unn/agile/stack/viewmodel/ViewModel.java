package ru.unn.agile.stack.viewmodel;

import ru.unn.agile.stack.model.Stack;

public class ViewModel {
    private Stack<Double> doubleStack;
    private String stackIsEmptyStatus;
    private String stackSize;
    private String stackTopElement;
    private String stackPopElement;
    private String addingElement;
    private String statusMessage;

    private boolean isPopButtonVisible;


    public ViewModel() {
        doubleStack = new Stack<Double>();
        stackIsEmptyStatus = "Stack is empty";
        stackSize = "0";
        stackTopElement = "None";
        stackPopElement = "None";
        addingElement = "";

        isPopButtonVisible = false;

        statusMessage = Status.WAITING_FOR_INPUT;
    }

    public String getStackIsEmptyStatus() {
        return stackIsEmptyStatus;
    }

    public String getStackSize() {
        return stackSize;
    }

    public String getStackTopElement() {
        return stackTopElement;
    }

    public String getStackPopElement() {
        return stackPopElement;
    }

    public String getAddingElement() {
        return addingElement;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public boolean isPopButtonVisible() {
        return isPopButtonVisible;
    }

    private void changePopButtonVisibleStatus() {
        if (doubleStack.empty()) {
            isPopButtonVisible = false;
        } else {
            isPopButtonVisible = true;
        }
    }

    private void changeStackEmptyStatus() {
        if (doubleStack.empty()) {
            stackIsEmptyStatus = "Stack is empty";
        } else {
            stackIsEmptyStatus = "Stack is not empty";
        }
    }

    private void changeStackSize() {
        int doubleStackSize = doubleStack.size();
        stackSize = Integer.toString(doubleStackSize);
    }

    private void changeStackTopElement() {
        if (!doubleStack.empty()) {
            stackTopElement = Double.toString((double) doubleStack.peek());
        } else {
            stackTopElement = "None";
        }
    }

    private boolean checkElement(final String addElement) {
        if (addElement.isEmpty()) {
            statusMessage = Status.WAITING_FOR_INPUT;
            return false;
        }

        try {
            Double.parseDouble(addElement);
        } catch (Exception e) {
            statusMessage = Status.INVALID_FORMAT;
            return false;
        }

        statusMessage = Status.READY_TO_ADD;
        return true;
    }

    public void addElement(final String addElement) {
        if (checkElement(addElement)) {
            addingElement = addElement;
            doubleStack.push(Double.parseDouble(addElement));
            changeStackSize();
            changePopButtonVisibleStatus();
            changeStackEmptyStatus();
            changeStackTopElement();
        }
    }

    public void popElement() {
        if (!doubleStack.empty()) {
            stackPopElement = Double.toString((double) doubleStack.pop());
            changePopButtonVisibleStatus();
            changeStackEmptyStatus();
            changeStackSize();
            changeStackTopElement();
        }
    }

    public final class Status {
        public static final String WAITING_FOR_INPUT = "Waiting for new element";
        public static final String READY_TO_ADD = "Ready to add new element";
        public static final String INVALID_FORMAT = "Invalid format of the adding element";

        private Status() {
        }
    }
}



