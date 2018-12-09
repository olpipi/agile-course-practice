package ru.unn.agile.stack.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.stack.model.Stack;

public class ViewModel {
    private Stack<Double> doubleStack;

    private StringProperty stackIsEmptyStatus = new SimpleStringProperty();
    private StringProperty stackSize = new SimpleStringProperty();
    private StringProperty stackTopElement = new SimpleStringProperty();
    private StringProperty stackPopElement = new SimpleStringProperty();
    private StringProperty addingElement = new SimpleStringProperty();
    private StringProperty statusMessage = new SimpleStringProperty();

    private BooleanProperty popButtonVisible = new SimpleBooleanProperty();

    public ViewModel() {
        doubleStack = new Stack<Double>();
        stackIsEmptyStatus.set("Stack is empty");
        stackSize.set("0");
        stackTopElement.set("None");
        stackPopElement.set("None");
        addingElement.set("");

        popButtonVisible.set(false);

        statusMessage.set(Status.WAITING_FOR_INPUT);
    }

    public StringProperty stackIsEmptyStatusProperty() {
        return stackIsEmptyStatus;
    }

    public final String getStackIsEmptyStatus() {
        return stackIsEmptyStatus.get();
    }

    public StringProperty stackSizeProperty() {
        return stackSize;
    }

    public String getStackSize() {
        return stackSize.get();
    }

    public StringProperty stackTopElementProperty() {
        return stackTopElement;
    }

    public String getStackTopElement() {
        return stackTopElement.get();
    }

    public StringProperty stackPopElementProperty() {
        return stackPopElement;
    }

    public String getStackPopElement() {
        return stackPopElement.get();
    }

    public StringProperty addingElementProperty() {
        return addingElement;
    }

    public String getAddingElement() {
        return addingElement.get();
    }

    public StringProperty statusMessageProperty() {
        return statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage.get();
    }

    public boolean isPopButtonVisible() {
        return popButtonVisible.get();
    }

    public BooleanProperty popButtonVisibleProperty() {
        return popButtonVisible;
    }

    private void changePopButtonVisibleStatus() {
        if (doubleStack.empty()) {
            popButtonVisible.set(false);
        } else {
            popButtonVisible.set(true);
        }
    }

    private void changeStackEmptyStatus() {
        if (doubleStack.empty()) {
            stackIsEmptyStatus.set("Stack is empty");
        } else {
            stackIsEmptyStatus.set("Stack is not empty");
        }
    }

    private void changeStackSize() {
        int doubleStackSize = doubleStack.size();
        stackSize.set(Integer.toString(doubleStackSize));
    }

    private void changeStackTopElement() {
        if (!doubleStack.empty()) {
            stackTopElement.set(Double.toString((double) doubleStack.peek()));
        } else {
            stackTopElement.set("None");
        }
    }

    private boolean checkElement(final String addElement) {
        if (addElement.isEmpty()) {
            statusMessage.set(Status.WAITING_FOR_INPUT);
            return false;
        }

        try {
            Double.parseDouble(addElement);
        } catch (Exception e) {
            statusMessage.set(Status.INVALID_FORMAT);
            return false;
        }

        statusMessage.set(Status.READY_TO_ADD);
        return true;
    }

    public void setAddingElem(final String addElem) {
        addingElement.set(addElem);
    }


    public void addElement() {
        if (checkElement(addingElement.get())) {
            doubleStack.push(Double.parseDouble(addingElement.get()));
            changeStackSize();
            changePopButtonVisibleStatus();
            changeStackEmptyStatus();
            changeStackTopElement();
        }
    }

    public void popElement() {
        if (!doubleStack.empty()) {
            stackPopElement.set(Double.toString((double) doubleStack.pop()));
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
