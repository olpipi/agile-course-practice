package ru.unn.agile.ArraySorter.viewmodel;

import ru.unn.agile.arraysorter.model.ArraySorter;

import java.util.ArrayList;

public class ViewModel {
    private String ElemArray;
    private String outputArray;
    private String status;

    ArrayList<Double> Array = new ArrayList<Double>();

    public ViewModel() {
        ElemArray = "";
        outputArray = "";
        status = Status.WAITING;

    }

    public String getOutputArray()
    {
        return outputArray;
    }

    public String getElemArray() {
        return ElemArray;
    }

    public void setElemArray(final String ElemArray){
        if (ElemArray.equals(this.ElemArray)) {
            return;
        }

        this.ElemArray = ElemArray;
    }

    public void Add()
    {
        if (!parseInput()) {
            return;
        }

        double value = Double.parseDouble(ElemArray);
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

        status = Status.SUCCESSFUL;

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

    public void processingAddField(final int keyCode) {
        parseInput();
    }

    private boolean parseInput() {
        try {
            if (ElemArray.isEmpty()) {
                status = Status.WAITING;
                return true;
            }
            else{
                Double.parseDouble(ElemArray);
            }
        } catch (Exception e) {
            status = Status.BAD_FORMAT;
            return false;
        }
        status = Status.READY;
        return true;
    }
}
