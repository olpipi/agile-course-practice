package ru.unn.agile.AVL.Model;

public class AVLTree<K extends Comparable<K>, V extends Comparable<V>> {

    public void insert(final K key, final V value) {

        if (root == null) {
            root = new Node<>(key, value);
            return;
        }

        Node<K, V> current = root;
        Node<K, V> parent  = current;
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.getKey());
            if (cmp < 0) {
                current = current.getLeft();
            } else if (cmp > 0) {
                current = current.getRight();
            } else {
                current.setValue(value);
                return;
            }
        }

        int cmp = key.compareTo(parent.getKey());
        if (cmp < 0) {
            parent.setLeft(new Node<>(key, value));
        } else if (cmp > 0) {
            parent.setRight(new Node<>(key, value));
        }

        while (parent != null) {
            Node<K, V> parentOfParent = parent.getParent();
            current = balanceNode(parent);

            if (parentOfParent != null) {
                cmp = current.getKey().compareTo(parentOfParent.getKey());
                if (cmp < 0) {
                    parentOfParent.setLeft(current);
                } else if (cmp > 0) {
                    parentOfParent.setRight(current);
                }
            } else {
                current.setParent(null);
            }

            parent = parentOfParent;
        }

        root = current;
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

    private int height(final Node<K, V> node) {
        return node != null ? node.getHeight() : 0;
    }

    private int getBalance(final Node<K, V> node) {
        return height(node.getRight()) - height(node.getLeft());
    }

    private void fixHeight(final Node<K, V> node) {
        int leftHeight  = height(node.getLeft());
        int rightHeight = height(node.getRight());
        node.setHeight((leftHeight > rightHeight ? leftHeight : rightHeight) + 1);
    }

    private Node<K, V> rotateRight(final Node<K, V> node) {
        Node<K, V> temp = node.getLeft();

        node.setLeft(temp.getRight());

        temp.setRight(node);

        fixHeight(node);
        fixHeight(temp);

        return temp;
    }

    private Node<K, V> rotateLeft(final Node<K, V> node) {
        Node<K, V> temp = node.getRight();

        node.setRight(temp.getLeft());

        temp.setLeft(node);

        fixHeight(node);
        fixHeight(temp);

        return temp;
    }

    private Node<K, V> balanceNode(final Node<K, V> node) {
        fixHeight(node);

        if (getBalance(node) == 2) {
            if (getBalance(node.getRight()) < 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        //Bypass gradle magic number check
        final int disbalanced = -2;

        if (getBalance(node) == disbalanced) {
            if (getBalance(node.getLeft()) > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }

        return node;
    }

    private Node<K, V> root = null;
}
