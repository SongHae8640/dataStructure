package map;

import java.util.LinkedList;

public class MyHashMap {

    private static final int DEFAULT_CAPACITY = 16;

    private LinkedList<Node>[] table;
    private int capacity;
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity){
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    static class Node{
        String key;
        String value;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }

    }

    public String put(String key, String value) {

        Node newNode = new Node(key, value);

        int hashCode = getTableIndex(key);

        if(table[hashCode] == null){
            LinkedList<Node> list = new LinkedList<>();
            table[hashCode] = list;
        }

        return addNode(table[hashCode], newNode);
    }

    public String get(String key) {
        int hashCode = getTableIndex(key);

        LinkedList<Node> list = table[hashCode];

        if(list == null) return null;

        for (Node node: list) {
            if(node.key.equals(key)) return (String) node.value;
        }

        return null;
    }

    public boolean containsKey(String key){
        int hashCode = getTableIndex(key);
        LinkedList<Node> list = table[hashCode];

        if(list == null) return false;

        for (Node node: list) {
            if(node.key.equals(key)) return true;
        }

        return false;
    }

    public boolean containsValue(String value){


        for (int i = 0; i < table.length; i++) {
            LinkedList<Node> list = table[i];
            if(list == null) continue;

            for (Node node: list) {
                if(node.value.equals(value)) return true;
            }
        }

        return false;
    }

    public boolean isEmpty(){

        for (int i = 0; i < table.length; i++) {
            if(table[i] != null && !table[i].isEmpty()) return false;
        }

        return true;
    }

    public String remove(String key){
        int hashCode = getTableIndex(key);

        LinkedList<Node> list = table[hashCode];
        for (Node node: list) {
            if(node.key.equals(key)) {
                String oldValue= node.value;
                list.remove(node);
                size--;
                return oldValue;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    private String addNode(LinkedList<Node> nodes, Node newNode) {
        size++;
        for (Node oldNode: nodes) {
            if(oldNode.key.equals(newNode.key)){
                String oldValue = (String) oldNode.value;
                oldNode.value = newNode.value;
                return oldValue;
            }
        }

        nodes.add(newNode);
        return null;
    }

    private int getTableIndex(String key) {
        return (key ==null) ? 0 : Math.abs(key.hashCode()) % capacity;
    }


}
