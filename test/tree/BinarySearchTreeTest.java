package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void insertValueTest() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertValue(5);
        tree.insertValue(3);
        tree.insertValue(7);
        tree.insertValue(2);
        tree.insertValue(4);
        tree.insertValue(6);
        tree.insertValue(8);
        tree.insertValue(1);
        tree.insertValue(9);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, ]", tree.toString());
    }


    @Test
    public void containsValueTest() {
        BinarySearchTree tree = new BinarySearchTree();
        int treeSize = 10;
        for (int i = 0; i < treeSize; i++) {
            tree.insertValue(i);
        }
        System.out.println(tree.toString());

        for (int i = 0; i < treeSize; i++) {
            assertTrue(tree.containsValue(i));
            assertFalse(tree.containsValue(i+treeSize));
        }

    }


    @Test
    public void deleteValueTest() {
        BinarySearchTree tree = new BinarySearchTree();
        int treeSize = 10;
        for (int i = 0; i < treeSize; i++) {
            tree.insertValue(i);
        }
        System.out.println(tree.toString());

        for (int i = 0; i < treeSize; i++) {
            tree.deleteValue(i);
        }

    }

}