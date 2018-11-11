package ru.unn.agile.ArraySorter.viewmodel;

import ru.unn.agile.arraysorter.model.ArraySorter;

import java.util.ArrayList;

public class ViewModel {
    private String newElem;
    private String outputArray;

    ArrayList<Double> Array = new ArrayList<Double>();

    public ViewModel() {
        newElem = "";
        outputArray = "";

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
}
