package ru.unn.agile.AVL.Model;

public class Node<K extends Comparable<K>, V extends Comparable<V>> {

    public Node(final K key, final V value, final int height, final Node left, final Node right) {
        this.key = key;
        this.value = value;
        this.height = height;
        this.left = left;
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(final K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(final V value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    private K         key;
    private V         value;
    private int       height;
    private Node      left;
    private Node      right;
}
