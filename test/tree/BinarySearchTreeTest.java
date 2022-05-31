package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(2);
        tree.insertNode(4);
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(1);
        tree.insertNode(9);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", tree.toString());
    }

}