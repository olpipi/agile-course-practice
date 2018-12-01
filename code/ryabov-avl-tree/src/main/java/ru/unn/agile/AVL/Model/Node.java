package ru.unn.agile.AVL.Model;

public class Node<K extends Comparable<K>, V extends Comparable<V>> {

    public Node(final K key, final V value) {
        this.key = key;
        this.value = value;
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

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(final Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(final Node<K, V> right) {
        this.right = right;
    }

    public int getBalance() {
        int leftHeight  = left  != null ? left.height  : 0;
        int rightHeight = right != null ? right.height : 0;
        return rightHeight - leftHeight;
    }

    public void fixHeight() {
        int leftHeight  = left  != null ? left.height  : 0;
        int rightHeight = right != null ? right.height : 0;
        height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }

    public Node<K, V> rotateLeft() {
        Node<K, V> temp = left;
        left            = temp.right;
        temp.right      = this;
        temp.fixHeight();
        fixHeight();
        return temp;
    }

    public Node<K, V> rotateRight() {
        Node<K, V> temp = right;
        right           = temp.left;
        temp.left       = this;
        temp.fixHeight();
        fixHeight();
        return temp;
    }

    public Node<K, V> balanceNode() {
        fixHeight();

        if (getBalance() == 2) {

            if (right.getBalance() < 0) {
                right = right.rotateRight();
            }
            return rotateLeft();
        }

        final int disbalanced = -2;

        if (getBalance() == disbalanced) {
            if (left.getBalance() > 0) {
                left = left.rotateLeft();
            }
            return rotateRight();
        }

        return this;
    }

    private K          key    = null;
    private V          value  = null;
    private int        height = 0;
    private Node<K, V> left   = null;
    private Node<K, V> right  = null;
}
