package ru.unn.agile.AVL.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AVLTreeTest {
    @Test
    public void insertAndFindTheKeyInAnEmptyTree() {
        AVLTree<Integer, Integer> tree = new AVLTree<>(null);
        Node<Integer, Integer> nodeToInsert = new Node<Integer, Integer>(0, 0);
        tree.insert(nodeToInsert);


        assertEquals(tree.find(nodeToInsert.getKey()), nodeToInsert);
    }

    @Test
    public void insertAndFindNull() {
        AVLTree<Integer, Integer> tree = new AVLTree<>(null);
        tree.insert(null);

        assertEquals(tree.find(null), null);
    }

    @Test
    public void insertAndFindInSequence() {
        AVLTree<Integer, String> tree = new AVLTree<>(null);

        Node<Integer, String> nodeToFind = new Node<>(6, "F");
        tree.insert(new Node<Integer, String>(1, "A"));
        tree.insert(new Node<Integer, String>(2, "B"));
        tree.insert(new Node<Integer, String>(3, "C"));
        tree.insert(new Node<Integer, String>(4, "D"));
        tree.insert(new Node<Integer, String>(5, "E"));
        tree.insert(nodeToFind);
        tree.insert(new Node<Integer, String>(7, "G"));
        tree.insert(new Node<Integer, String>(8, "H"));

        assertEquals(tree.find(nodeToFind.getKey()), nodeToFind);
    }


    @Test
    public void insertAndFindInSequenceEqualKeys() {
        AVLTree<Integer, String> tree = new AVLTree<>(null);

        Node<Integer, String> nodeToFind = new Node<>(77777, "FFFFFF");
        tree.insert(new Node<Integer, String>(77777, "F"));
        tree.insert(new Node<Integer, String>(77777, "FF"));
        tree.insert(new Node<Integer, String>(77777, "FFF"));
        tree.insert(new Node<Integer, String>(77777, "FFFF"));
        tree.insert(new Node<Integer, String>(77777, "FFFFF"));
        tree.insert(new Node<Integer, String>(77777, "FFFFFF"));
        tree.insert(new Node<Integer, String>(77777, "FFFFFFF"));
        tree.insert(new Node<Integer, String>(77777, "FFFFFFFF"));
        tree.insert(nodeToFind);
        tree.insert(new Node<Integer, String>(977, "G"));
        tree.insert(new Node<Integer, String>(455678, "H"));

        assertEquals(tree.find(nodeToFind.getKey()).getValue(), nodeToFind.getValue());
    }
}
