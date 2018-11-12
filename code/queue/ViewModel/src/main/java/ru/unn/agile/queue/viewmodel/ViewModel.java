package ru.unn.agile.queue.viewmodel;


import ru.unn.agile.queue.model.*;


public class ViewModel {
    private String newElem;
    private String outputQueue;

    private Queue<Double> queue;

    private String state;

    public ViewModel() {
        queue = new Queue<Double>();
        newElem = "";
        outputQueue = "";
        state = State.WAITING_FOR_INPUT;
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
    }

    public void Remove() {
        queue.pop();
        outputQueue = queue.toString();
    }

    public void Clear() {
        queue.clear();
        outputQueue = queue.toString();
    }

    private boolean parseInput() {
        try {
            if (newElem.isEmpty()) {
                state = State.WAITING_FOR_INPUT;
                return true;
            }
            else{
                Double.parseDouble(newElem);
            }
        } catch (Exception e) {
            state = State.INVALID_FORMAT;
            return false;
        }
        state = State.READY_TO_ADD;
        return true;
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

}
