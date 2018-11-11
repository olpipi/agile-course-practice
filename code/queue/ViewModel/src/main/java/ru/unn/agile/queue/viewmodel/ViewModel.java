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
        this.newElem = newElem;
    }

    public void Add() {
        queue.push(Double.parseDouble(newElem));
        outputQueue = queue.toString();
    }

}
