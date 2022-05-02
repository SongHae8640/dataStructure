package List;

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

    public E getFirst(int index){
        checkIndexRange(index);
        return first.item;
    }

    public E getLast(int index){
        checkIndexRange(index);
        return last.item;
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
        Node<E> nextNode = indexNode.next;
        Node<E> prevNode = indexNode.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        return indexNode.item;
    }

    public boolean remove(E element){
        return true;
    }

    public E removeFirst(){
        return null;
    }

    public E removeLast(){
        return null;
    }

    public E set(int index, E element){
        return null;
    }

    public int size(){
        return size;
    }

    public E[] 	toArray(){
        return null;
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
