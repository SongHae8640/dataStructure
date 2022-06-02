package tree;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    
    /*          (1)
     *         /   \
     *      (2)    (3)
     *     /   \
     *  (4)     (5)
     */
    private BinaryTree getTestTree() {
        Node node4 = new Node(null, 4, null);
        Node node5 = new Node(null, 5, null);
        Node node2 = new Node(node4, 2, node5);
        Node node3 = new Node(null, 3, null);
        Node node1 = new Node(node2, 1, node3);

        BinaryTree tree = new BinaryTree(node1);
        return tree;
    }

    @Test
    public void orderPrintTest(){
        BinaryTree tree = getTestTree();
        tree.printInOrder(tree.getRoot());
        System.out.println();

        tree.printPreOrder(tree.getRoot());
        System.out.println();

        tree.printPostOrder(tree.getRoot());
    }
    /*
     * 4 2 5 1 3
     * 1 2 4 5 3
     * 4 5 2 3 1
     */



}