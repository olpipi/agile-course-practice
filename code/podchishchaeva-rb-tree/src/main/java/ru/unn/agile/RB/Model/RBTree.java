package ru.unn.agile.RB.Model;

public class RBTree<K extends Comparable<K>, V extends Comparable<V>> {

    private RBNode<K, V> root = null;

    public void insert(final K key, final V value) {
        if (root == null) {
            root = new RBNode<>(key, value, RBNode.COLOR.BLACK);
            return;
        }

        RBNode<K, V> parent = root;
        RBNode<K, V> current = root;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.getKey());
            if (cmp < 0) {
                current = current.getLeft();
            } else if (cmp > 0) {
                current = current.getRight();
            } else {
                current.setVal(value);
                return;
            }
        }

        RBNode<K, V> node = new RBNode<>(key, value);
        node.setParent(parent);
        int cmp = key.compareTo(parent.getKey());
        if (cmp < 0) {
            parent.setLeft(node);
        } else if (cmp > 0) {
            parent.setRight(node);
        }

        fixTree(node);
    }

    private void fixTree(final RBNode<K, V> node) {
        if ((node.getParent() == null) || (node.getParent().getColor() == RBNode.COLOR.BLACK)) {
            return;
        }

        RBNode<K, V> uncle = getUncle(node);
        RBNode<K, V> parent = node.getParent();
        //case 1: Uncle Red
        if (isRedUncle(uncle)) {
            //if uncle is red, implies uncle is not-null && grandparent exists
            parent.setColor(RBNode.COLOR.BLACK);
            parent.getParent().setColor(RBNode.COLOR.RED);
            uncle.setColor(RBNode.COLOR.BLACK);
            fixTree(parent.getParent());
        } else if (isUncleTheRightChild(node)) {
            //case 3: if node also the right child
            if (parent.getRight() == node) {
                rotateLeft(node);
            }
            //case 2: fix colors
            parent.setColor(RBNode.COLOR.BLACK);
            parent.getParent().setColor(RBNode.COLOR.RED);
            rotateRight(parent);
        } else {
            //case 3: if node also the left child
            if (parent.getLeft() == node) {
                rotateRight(node);
            }
            //case 2: fix colors
            parent.setColor(RBNode.COLOR.BLACK);
            parent.getParent().setColor(RBNode.COLOR.RED);
            rotateLeft(parent);
        }

        root.setColor(RBNode.COLOR.BLACK);

    }

    private void rotateRight(final RBNode<K, V> node) {
        RBNode<K, V> x = node;
        RBNode<K, V> y = x.getParent();
        RBNode<K, V> g = y.getParent();
        RBNode<K, V> beta = x.getRight();

        x.setParent(g);
        if (g != null) {
            if (isLeftChild(y)) {
                g.setLeft(x);
            } else {
                g.setRight(x);
            }
        } else {
            this.root = x;
        }

        x.setRight(y);

        y.setParent(x);
        y.setLeft(beta);

        if (beta != null) {
            beta.setParent(y);
        }
    }

    private void rotateLeft(final RBNode<K, V> node) {
        RBNode<K, V> y = node;
        RBNode<K, V> x = node.getParent();
        RBNode<K, V> g = x.getParent();
        RBNode<K, V> beta = y.getLeft();

        y.setParent(g);

        if (g != null) {
            if (isLeftChild(x)) {
                g.setLeft(y);
            } else {
                g.setRight(y);
            }
        } else {
            this.root = y;
        }

        y.setLeft(x);
        x.setParent(y);

        x.setRight(beta);
        if (beta != null) {
            beta.setParent(x);
        }
    }

    private boolean isLeftChild(final RBNode<K, V> node) {
        return node.getParent().getLeft() == node;
    }

    private boolean isUncleTheRightChild(final RBNode<K, V> node) {
        return node.getParent() == node.getParent().getParent().getLeft();
    }

    private boolean isRedUncle(final RBNode<K, V> uncle) {
        return uncle != null && uncle.getColor() == RBNode.COLOR.RED;
    }

    private RBNode<K, V> getUncle(final RBNode<K, V> node) {
        if ((node.getParent() == null) || (node.getParent().getParent() == null)) {
            return null;
        }

        RBNode<K, V> parent = node.getParent();
        RBNode<K, V> grandParent = parent.getParent();

        return (parent == grandParent.getLeft()) ? grandParent.getRight() : grandParent.getLeft();
    }

    public RBNode<K, V> find(final K key) {
        RBNode<K, V> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.getKey());
            if (cmp < 0) {
                node = node.getLeft();
            } else if (cmp > 0) {
                node = node.getRight();
            } else if (cmp == 0) {
                return node;
            }
        }
        return null;
    }
}
