package ru.unn.agile.ArraySorter.viewmodel;

import ru.unn.agile.arraysorter.model.ArraySorter;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private String elemArray;
    private String outputArray;
    private String outputSourceArray;
    private String status;

    private boolean isAddButtonEnabled;
    private boolean isClearButtonEnabled;
    private boolean isSortButtonEnabled;

    private List<Double> array = new ArrayList<Double>();
    private List<Double> sourceArray = new ArrayList<Double>();

    public ViewModel() {
        elemArray = "";
        outputArray = "";
        outputSourceArray = "";
        status = Status.WAITING;

        isAddButtonEnabled = false;
        isClearButtonEnabled = false;
        isSortButtonEnabled = false;
    }

    public String getOutputArray() {
        return outputArray;
    }

    public String getOutputSourceArray() {
        return outputSourceArray;
    }

    public String getElemArray() {
        return elemArray;
    }

    public void setElemArray(final String elemArray) {
        if (elemArray.equals(this.elemArray)) {
            return;
        }

        this.elemArray = elemArray;
    }

    public void add() {
        if (!parseInput()) {
            return;
        }

        double value = Double.parseDouble(elemArray);
        array.add(value);
        sourceArray.add(value);
        changeEnabledButtons();

        outputSourceArray = array.toString();
    }

    public void clear() {
        array.clear();
        sourceArray.clear();
        changeEnabledButtons();

        outputArray = array.toString();
        outputSourceArray = sourceArray.toString();
    }

    public void sort() {
        Double[] nativeArray = new Double[array.size()];
        array.toArray(nativeArray);

        ArraySorter.sort(nativeArray);

        for (int i = 0; i < nativeArray.length; i++) {
            array.set(i, nativeArray[i]);
        }

        changeEnabledButtons();
        status = Status.SUCCESSFUL;

        outputArray =  array.toString();
    }

    public String getCurrentState() {
        return status;
    }

    public final class Status {
        public static final String WAITING = "Waiting new element";
        public static final String READY = "Ready to add new element";
        public static final String BAD_FORMAT = "Bad format";
        public static final String SUCCESSFUL = "Sort of array is successful";

        private Status() { }
    }

    public void processingAddField(final int keyCode) {
        parseInput();
    }

    private boolean parseInput() {
        try {
            if (elemArray.isEmpty()) {
                status = Status.WAITING;
                isAddButtonEnabled = false;
                return isAddButtonEnabled;
            } else {
                Double.parseDouble(elemArray);
                status = Status.READY;
                isAddButtonEnabled = true;
            }
        } catch (Exception e) {
            status = Status.BAD_FORMAT;
            isAddButtonEnabled = false;
            return isAddButtonEnabled;
        }

        return isAddButtonEnabled;
    }

    public boolean isAddButtonEnabled() {
        return isAddButtonEnabled;
    }

    public boolean isClearButtonEnabled() {
        return isClearButtonEnabled;
    }

    public boolean isSortButtonEnabled() {
        return isSortButtonEnabled;
    }

    private void changeEnabledButtons() {
        if (array.isEmpty()) {
            isSortButtonEnabled = false;
            isClearButtonEnabled = false;
        } else {
            isSortButtonEnabled = true;
            isClearButtonEnabled = true;
        }
    }
}
