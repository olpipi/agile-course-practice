package ru.unn.agile.RB.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class RBTreeTest {
    @Test
    public void canCreateRBTree() {
        RBTree<String, Integer> tree = new RBTree<>();

        assertNotNull(tree);
    }

    @Test
    public void canInsertNewNode() {
        RBTree<String, Integer> tree = new RBTree<>();

        tree.insert("B", 1);

        assertNotNull(tree.find("B"));
    }

    @Test
    public void canInsertNewNodes() {
        RBTree<String, Integer> tree = new RBTree<>();

        tree.insert("A", 1);
        tree.insert("B", 1);
        tree.insert("C", 1);
        tree.insert("D", 1);

        assertNotNull(tree.find("D"));
    }

    @Test
    public void canInsertNodesWithEqualKeys() {
        RBTree<String, Integer> tree = new RBTree<>();

        tree.insert("A", 1);
        tree.insert("A", 2);

        assertNotNull(tree.find("A"));
        assertEquals(new Integer(2), tree.find("A").getVal());
    }

    @Test
    public void canNotFindNodeWithNotExistingKey() {
        RBTree<String, Integer> tree = new RBTree<>();

        tree.insert("A", 1);
        tree.insert("B", 2);
        tree.insert("C", 3);

        assertNull(tree.find("D"));
    }


}

