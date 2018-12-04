package ru.unn.agile.HashMap.Model;
import java.util.*;
public class HashMap {
    private int size;
    private ArrayList<LinkedList<Element>> array;

    public HashMap() {
        this.size = 0;
        this.array = new ArrayList<LinkedList<Element>>(128);

        for (int i = 0; i < 128; i++) {
            this.array.add(new LinkedList<Element>());
        }
    }
    public boolean maybeContainsKey (String key){
        return sizearray(key) > 0;
    }

    public boolean containsKey (String key){
        for (Element ele : GetArrayByKey(key))
            if (ele.key.equals(key)) {
                return true;
            }
        return false;
    }

    public boolean isEquals (String key) {
        return size() == 0;
    }

    public boolean isEmpty () {
        return size() == 0;
    }

    public void add (String key, Object value){
        this.remove(key);
        final LinkedList<Element> elements = GetArrayByKey(key);
        elements.add(new Element(key, value));
        size++;
    }

    public int size () {
        return size;
    }
    
    public int sizearray (String key) {

        return GetArrayByKey(key).size();
    }

    public ArrayList<LinkedList<Element>> getArray() {
        return array;
    }

   public  LinkedList<Element> GetArrayByKey (String key) {

       final LinkedList<Element> elements = this.array.get(hash(key));
       return elements;
    }

    public Object get (String key){
        for (Element ele : GetArrayByKey(key)) {
            if (ele.isEquals(key)) {
                return ele.value;
            }
        }
        throw new NoSuchElementException();
    }

    public void remove (String key){
        for (Element ele : GetArrayByKey(key)) {
            if (ele.isEquals(key)) {
                GetArrayByKey(key).remove(ele);
                size--;
                break;
            }
        }
    }

    private int hash (String key){
        return key.hashCode() % 128;
    }

    private class Element {
        public final String key;
        public final Object value;

        public Element(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public boolean isEquals (String key) {
            return this.key.equals(key);
        }

    }
};
