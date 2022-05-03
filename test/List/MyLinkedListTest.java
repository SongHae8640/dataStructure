package List;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    public void add(){
        MyLinkedList linkedList = new MyLinkedList();

        //add test
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(0, 0);
        printLinkedList(linkedList);
        assertEquals(1, linkedList.get(1));
        assertEquals(5, linkedList.get(5));

        //addFirst test
        linkedList.addFirst(-1);
        printLinkedList(linkedList);
        assertEquals(0, linkedList.get(1));
        assertEquals(4, linkedList.get(5));

        //addLast test
        linkedList.addLast(6);
        printLinkedList(linkedList);
        assertEquals(6, linkedList.get(linkedList.size()-1));


        //indexOutBound test
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(linkedList.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
    }

    @Test
    public void getTest(){
        MyLinkedList linkedList = new MyLinkedList();

        assertThrows(NoSuchElementException.class, () -> linkedList.getFirst());
        assertThrows(NoSuchElementException.class, () -> linkedList.getLast());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        assertEquals(5, linkedList.get(5));
        assertEquals(0, linkedList.getFirst());
        assertEquals(9, linkedList.getLast());
    }

    @Test
    public void indexOfTest(){
        MyLinkedList linkedList = new MyLinkedList();
        int listSize = 10;
        for (int i = 0; i < listSize; i++) {
            linkedList.add(i);
        }

        for (int i = 0; i < linkedList.size(); i++) {
            assertEquals(i, linkedList.indexOf(i));
        }


    }

    @Test
    public void removeElementTest(){
        MyLinkedList<Integer> linkedList = new MyLinkedList();
        int listSize = 10;
        linkedList.add(null);
        for (int i = 0; i < listSize-2; i++) {
            if(listSize / 2 == i){
                linkedList.add(null);
            }else{
                linkedList.add(i);
            }

        }
        linkedList.add(null);
        printLinkedList(linkedList);

        boolean isRemove = linkedList.remove(null);
        assertEquals(true, isRemove);
        assertEquals(--listSize, linkedList.size());

        isRemove = linkedList.remove(null);
        assertEquals(true, isRemove);
        assertEquals(--listSize, linkedList.size());

        isRemove = linkedList.remove(null);
        assertEquals(true, isRemove);
        assertEquals(--listSize, linkedList.size());


        isRemove = linkedList.remove(null);
        assertEquals(false, isRemove);
        assertEquals(listSize, linkedList.size());
    }

    @Test
    public void removeIndexTest(){
        MyLinkedList<Integer> linkedList = new MyLinkedList();

        int listSize = 10;
        linkedList.add(null);
        for (int i = 0; i < listSize-2; i++) {
            if(listSize / 2 == i){
                linkedList.add(null);
            }else{
                linkedList.add(i);
            }

        }
        linkedList.add(null);
        printLinkedList(linkedList);


        Integer removeInteger = linkedList.remove(0);
        assertEquals(null, removeInteger);
        assertEquals(--listSize, linkedList.size());

        removeInteger = linkedList.remove(linkedList.size()-1);
        assertEquals(null, removeInteger);
        assertEquals(--listSize, linkedList.size());

        removeInteger = linkedList.removeFirst();
        assertEquals(0, removeInteger);
        assertEquals(--listSize, linkedList.size());

        removeInteger = linkedList.removeLast();
        assertEquals(7, removeInteger);
        assertEquals(--listSize, linkedList.size());
    }

    @Test
    public void removeErrorTest(){
        MyLinkedList<Integer> linkedList = new MyLinkedList();

        //indexOutBound test
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(linkedList.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
    }

    @Test
    public void setTest(){
        MyLinkedList<Integer> linkedList = new MyLinkedList();

        //indexOutBound test
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(linkedList.size() , 1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-1, 1));

        int listSize = 10;
        for (int i = 0; i < listSize; i++){
            linkedList.add(i);
        }

        for (int i = 0; i < listSize; i++){
            Integer oldElement = linkedList.set(i, i * 2);
            assertEquals(i, oldElement);
        }

        for (int i = 0; i < listSize; i++){
            assertEquals(i * 2, linkedList.get(i));
        }

    }

    private void printLinkedList(MyLinkedList linkedList) {
        String printString = "";
        for (int i = 0; i < linkedList.size(); i++) {
            printString += ", "+ linkedList.get(i);
        }
        System.out.println(printString.substring(2));
    }

}