package ru.unn.agile.ArraySorter.viewmodel;

import ru.unn.agile.arraysorter.model.ArraySorter;

import java.util.ArrayList;

public class ViewModel {
    private String newElem;
    private String outputArray;
    private String status;

    ArrayList<Double> Array = new ArrayList<Double>();

    public ViewModel() {
        newElem = "";
        outputArray = "";
        status = Status.WAITING;

    }

    public String getOutputArray()
    {
        return outputArray;
    }

    public String getNewElem() {
        return newElem;
    }

    public void setNewElem(final String newElem){
        if (newElem.equals(this.newElem)) {
            return;
        }

        this.newElem = newElem;
    }

    public void Add()
    {
        double value = Double.parseDouble(newElem);
        Array.add(value);

        outputArray = Array.toString();
    }

    public void Clear()
    {
        Array.clear();

        outputArray = Array.toString();
    }

    public void Sort()
    {
        Double[] nativeArray = new Double[Array.size()];
        Array.toArray(nativeArray);

        ArraySorter.sort(nativeArray);

        for (int i = 0; i < nativeArray.length; i++)
            Array.set(i, nativeArray[i]);

        outputArray =  Array.toString();
    }

    public String getCurrentState() { return status; }

    public final class Status {
        public static final String WAITING = "Waiting new element";
        public static final String READY = "Ready to add new element";
        public static final String BAD_FORMAT = "Bad format";
        public static final String SUCCESSFUL = "Sort of array is successful";

        private Status() { }
    }
}
