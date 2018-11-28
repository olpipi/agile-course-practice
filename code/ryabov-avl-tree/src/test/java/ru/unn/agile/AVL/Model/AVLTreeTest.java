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
}
