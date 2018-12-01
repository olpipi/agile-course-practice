package ru.unn.agile.AVL.Model;

public class AVLTree<K extends Comparable<K>, V extends Comparable<V>> {

    public AVLTree(final Node<K, V> root) {
        this.root = root;
    }

    public void insert(final Node<K, V> node) {
        if (node == null) {
            return;
        }

        if (root == null) {
            root = node;
            return;
        }

        Node<K, V> current = root;
        Node<K, V> parent  = current;
        while (current != null) {
            parent = current;
            int cmp = node.getKey().compareTo(current.getKey());
            if (cmp < 0) {
                current = current.getLeft();
            } else if (cmp > 0) {
                current = current.getRight();
            } else {
                current.setValue(node.getValue());
                return;
            }
        }

        int cmp = node.getKey().compareTo(parent.getKey());
        if (cmp < 0) {
            parent.setLeft(node);
        } else if (cmp > 0) {
            parent.setRight(node);
        }

        root.balanceNode();
    }

    public Node<K, V> find(final K key) {
        Node<K, V> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.getKey());
            if (cmp < 0) {
                current = current.getLeft();
            } else if (cmp > 0) {
                current = current.getRight();
            } else {
                return current;
            }
        }

        return null;
    }

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(final Node<K, V> root) {
        this.root = root;
    }

    private Node<K, V> root = null;
}
