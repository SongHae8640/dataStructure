package tree;

public class BinaryTree {

    private Node root;

    public BinaryTree(Node root){
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void printInOrder(Node parentNode){
        if(parentNode == null) return;

        printInOrder(parentNode.left);
        System.out.print(parentNode.data + " ");
        printInOrder(parentNode.right);
    }

    public void printPreOrder(Node parentNode){
        if(parentNode == null) return;

        System.out.print(parentNode.data + " ");
        printPreOrder(parentNode.left);
        printPreOrder(parentNode.right);
    }

    public void printPostOrder(Node parentNode){
        if(parentNode == null) return;

        printPostOrder(parentNode.left);
        printPostOrder(parentNode.right);
        System.out.print(parentNode.data + " ");
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(Node left, int data, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
