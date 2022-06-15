package tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertValue(int value) {
        root = insertRecursive(root, value);
    }

    public Node insertRecursive(Node currentNode, int value){
        if (currentNode == null){
            return new Node(value);
        }

        if(value < currentNode.value){
            currentNode.left = insertRecursive(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insertRecursive(currentNode.right, value);
        }
        return currentNode;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        inOrder(root, sb);
        sb.append("]");
        return sb.toString();
    }

    private void inOrder(Node root, StringBuilder sb) {
        if (root == null){
            return;
        }
        inOrder(root.getLeft(), sb);
        sb.append(root.getValue());
        sb.append(", ");
        inOrder(root.getRight(), sb);
    }



    public boolean containsValue(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node currentNode, int value) {
        if(currentNode == null) return false;

        if(value < currentNode.value){
            return containsRecursive(currentNode.left, value);
        }
        else if(value > currentNode.value){
            return containsRecursive(currentNode.right, value);
        }

        return true;
    }

    public void deleteValue(int value) {
        deleteRecursive(root, value);
    }


    public Node deleteRecursive(Node currentNode, int value){
        if (currentNode == null){
            return null;
        }

        if(value < currentNode.value){
            currentNode.left = deleteRecursive(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteRecursive(currentNode.right, value);
        }
        return currentNode;
    }

    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

    }
}
