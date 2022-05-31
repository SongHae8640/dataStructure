package tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }
    public Node insertNode(int key){
        Node newNode = new Node(key);
        if (root == null){
            root = newNode;
            return root;
        }

        Node current = root;
        Node parent;
        while (true){
            parent = current;
            if (key < current.getKey()){
                current = current.getLeft();
                if (current == null){
                    parent.setLeft(newNode);
                    return newNode;
                }
            } else {
                current = current.getRight();
                if (current == null){
                    parent.setRight(newNode);
                    return newNode;
                }
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        preOrder(root, sb);
        sb.append("]");
        return sb.toString();
    }

    private void preOrder(Node root, StringBuilder sb) {
        if (root == null){
            return;
        }
        sb.append(root.getKey());
        sb.append(", ");
        preOrder(root.getLeft(), sb);
        preOrder(root.getRight(), sb);
    }

    private class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
