package ru.unn.agile.AVL.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AVLTreeTest {
    @Test
    public void insertAndFindTheKeyInAnEmptyTree() {
        AVLTree<Integer, Integer> tree = new AVLTree<>();
        Node<Integer, Integer> nodeToInsert = new Node<>(0, 0);
        tree.insert(nodeToInsert.getKey(), nodeToInsert.getValue());

        Node<Integer, Integer> foundNode = tree.find(nodeToInsert.getKey());
        assertEquals(nodeToInsert.getValue(), foundNode != null ? foundNode.getValue() : null);
    }

    @Test
    public void FindNull() {
        AVLTree<Integer, Integer> tree = new AVLTree<>();
        assertEquals(tree.find(null), null);
    }

    @Test
    public void insertAndFindInSequence() {
        AVLTree<Integer, String> tree = new AVLTree<>();

        tree.insert(1, "A");
        tree.insert(2, "B");
        tree.insert(4, "D");
        tree.insert(5, "E");
        tree.insert(3, "C");
        tree.insert(6, "F");
        tree.insert(7, "G");
        tree.insert(8, "H");

        Node<Integer, String> found = tree.find(6);
        assertEquals("F", found != null ? found.getValue() : null);
    }


    @Test
    public void insertAndFindInSequenceEqualKeys() {
        AVLTree<Integer, String> tree = new AVLTree<>();

        Node<Integer, String> nodeToFind = new Node<>(77777, "FFFFFF");
        tree.insert(77777, "F");
        tree.insert(77777, "FF");
        tree.insert(77777, "FFF");
        tree.insert(77777, "FFFF");
        tree.insert(77777, "FFFFF");
        tree.insert(77777, "FFFFFF");
        tree.insert(77777, "FFFFFFF");
        tree.insert(77777, "FFFFFFFF");
        tree.insert(nodeToFind.getKey(), nodeToFind.getValue());
        tree.insert(977, "G");
        tree.insert(455678, "H");

        Node<Integer, String> foundNode = tree.find(nodeToFind.getKey());
        assertEquals(nodeToFind.getValue(), foundNode != null ? foundNode.getValue() : null);
    }

    @Test
    public void insertAndFindUphillNumberSequence() {
        int[] sequence = java.util.stream.IntStream.rangeClosed(0, 100).toArray();

        AVLTree<Integer, Integer> tree = new AVLTree<>();
        for (Integer number : sequence) {
            tree.insert(number, number);
        }

        for (Integer number : sequence) {
            Node<Integer, Integer> foundNode = tree.find(number);
            assertEquals(number, foundNode != null ? foundNode.getValue() : null);
        }
    }

    @Test
    public void insertAndFindDownhillNumberSequence() {
        int[] sequence = java.util.stream.IntStream.rangeClosed(100, 0).toArray();

        AVLTree<Integer, Integer> tree = new AVLTree<>();
        for (Integer number : sequence) {
            tree.insert(number, number);
        }

        for (Integer number : sequence) {
            Node<Integer, Integer> foundNode = tree.find(number);
            assertEquals(number, foundNode != null ? foundNode.getValue() : null);
        }
    }

    @Test
    public void insertAndFindSymmetricNumberSequence() {
        int[] sequence = java.util.stream.IntStream.rangeClosed(-50, 50).toArray();

        AVLTree<Integer, Integer> tree = new AVLTree<>();
        for (Integer number : sequence) {
            tree.insert(number, number);
        }

        for (Integer number : sequence) {
            Node<Integer, Integer> foundNode = tree.find(number);
            assertEquals(number, foundNode != null ? foundNode.getValue() : null);
        }
    }
}
