package ru.unn.agile.queue.viewmodel;


import ru.unn.agile.queue.model.*;


public class ViewModel {
    private String newElem;
    private String outputQueue;

    private Queue<Double> queue;

    private String state;
    private boolean isAddButtonEnabled;
    private boolean isRemoveButtonEnabled;
    private boolean isClearButtonEnabled;

    public ViewModel() {
        queue = new Queue<Double>();
        newElem = "";
        outputQueue = "";
        state = State.WAITING_FOR_INPUT;

        isAddButtonEnabled = false;
        isRemoveButtonEnabled = false;
        isClearButtonEnabled = false;
    }

    public String getNewElem() {
        return newElem;
    }

    public String getOutputQueue() {
        return outputQueue;
    }

    public void setNewElem(final String newElem) {
        if (newElem.equals(this.newElem)) {
            return;
        }

        this.newElem = newElem;
    }

    public void Add() {
        if (!parseInput()) {
            return;
        }

        queue.push(Double.parseDouble(newElem));
        outputQueue = queue.toString();
        switchEnabledButtons();
    }

    public void Remove() {
        queue.pop();
        outputQueue = queue.toString();
        switchEnabledButtons();
    }

    public void Clear() {
        queue.clear();
        outputQueue = queue.toString();
        switchEnabledButtons();
    }

    private boolean parseInput() {
        try {
            if (newElem.isEmpty()) {
                state = State.WAITING_FOR_INPUT;
                isAddButtonEnabled = true;
                return isAddButtonEnabled;
            }
            else{
                Double.parseDouble(newElem);
            }
        } catch (Exception e) {
            state = State.INVALID_FORMAT;
            isAddButtonEnabled = false;
            return isAddButtonEnabled;
        }
        state = State.READY_TO_ADD;
        isAddButtonEnabled = true;
        return isAddButtonEnabled;
    }

    public void processingAddField(final int keyCode) {
        parseInput();
    }


    public String getCurrentState() {
        return state;
    }

    public final class State {
        public static final String WAITING_FOR_INPUT = "Waiting new element";
        public static final String READY_TO_ADD = "Ready to add element";
        public static final String INVALID_FORMAT = "Invalid format";

    }

    public boolean isAddButtonEnabled() {
        return isAddButtonEnabled;
    }

    public boolean isRemoveButtonEnabled() {
        return isRemoveButtonEnabled;
    }

    public boolean isClearButtonEnabled() {
        return isClearButtonEnabled;
    }

    private void switchEnabledButtons(){
        if(queue.isEmpty()){
            isRemoveButtonEnabled = false;
            isClearButtonEnabled = false;
        }else{
            isRemoveButtonEnabled = true;
            isClearButtonEnabled = true;
        }
    }
}
