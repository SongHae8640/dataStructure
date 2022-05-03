package List;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public void add(int index, E element){
        checkIndexRange(index);
        if(index == 0){
            addFirst(element);
            return;
        }else if(index == size){
            addLast(element);
            return;
        }
        Node<E> indexNode = node(index);
        Node<E> prevNode = indexNode.prev;

        Node<E> newNode = new Node<>(prevNode, element, indexNode);
        prevNode.next = newNode;
        indexNode.prev = newNode;
        size++;
    }

    public boolean add(E element){
        addLast(element);
        return true;
    }

    public void addFirst(E element){
        Node<E> oldFirst = first;
        Node<E> newNode = new Node<E>(null, element ,first);
        first = newNode;

        if(oldFirst == null){
            last = newNode;
        }else{
            oldFirst.prev = newNode;
        }
        size++;
    }

    public void addLast(E element){
        Node<E> oldLast = last;
        Node<E> newNode = new Node<E>(last, element,null);
        last = newNode;

        if(oldLast == null){
            first = newNode;
        }else {
            oldLast.next = newNode;
        }
        size++;

    }

    public void clear(){
        first = null;
        last = null;
        size = 0;

    }

    public E get(int index){
        checkIndexRange(index);
        return node(index).item;
    }

    private Node<E> node(int index) {
        Node<E> indexNode;
        if(size/2 >= index){
            indexNode = first;
            for (int i = 0; i < index; i++) {
                indexNode = indexNode.next;
            }

            return indexNode;
        }


        indexNode = last;
        for (int i = size - 1; i > index; i--) {
            indexNode = indexNode.prev;
        }

        return indexNode;
    }

    private void checkIndexRange(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
    }

    public E getFirst(){
        checkHasElement();
        return first.item;
    }

    public E getLast(){
        checkHasElement();
        return last.item;
    }

    private void checkHasElement() {
        if(size < 1) throw new NoSuchElementException();
    }

    public int indexOf(E element){
        Node<E> indexNode = first;
        if(element == null){
            for (int i = 0; i < size; i++) {
                if(indexNode.item ==null) return i;

                indexNode = indexNode.next;
            }
        }

        for (int i = 0; i < size; i++) {
            if(element.equals(indexNode.item)) return i;
            indexNode = indexNode.next;
        }

        return -1;
    }

    public E remove(int index){
        checkIndexRange(index);
        Node<E> indexNode = node(index);
        unLink(indexNode);
        return indexNode.item;
    }



    public boolean remove(E element){
        checkHasElement();
        Node<E> indexNode = first;
        if(element == null){
            for (int i = 0; i < size; i++) {
                if(indexNode.item == null){
                    unLink(indexNode);
                    return true;
                }
                indexNode = indexNode.next;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(element.equals(indexNode.item)){
                    unLink(indexNode);
                    return true;
                }
                indexNode = indexNode.next;
            }
        }
        return false;
    }

    public E removeFirst(){
        checkHasElement();
        Node<E> firstNode = first;
        unLink(firstNode);
        return firstNode.item;
    }

    public E removeLast(){
        checkHasElement();
        Node<E> lastNode = last;
        unLink(lastNode);
        return lastNode.item;
    }

    public E set(int index, E element){
        checkIndexRange(index);
        Node<E> indexNode = node(index);
        E originElement = indexNode.item;
        indexNode.item = element;

        return originElement;
    }

    public int size(){
        return size;
    }

    private void unLink(Node<E> node) {

        Node<E> nextNode = node.next;
        Node<E> prevNode = node.prev;

        if(nextNode == null){
            last = node.prev;
        }else{
            nextNode.prev = prevNode;
        }

        if(prevNode == null){
            first = node.next;
        }else {
            prevNode.next = nextNode;
        }

        size--;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

}
