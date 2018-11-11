package ru.unn.agile.queue.viewmodel;


import ru.unn.agile.queue.model.*;


public class ViewModel {
    private String newElem;
    private String outputQueue;

    private Queue<Double> queue;

    public ViewModel() {
        queue = new Queue<Double>();
        newElem = "";
        outputQueue = "";
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
            if (!newElem.isEmpty()) {
                Double.parseDouble(newElem);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
