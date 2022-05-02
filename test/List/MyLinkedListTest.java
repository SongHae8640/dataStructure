package List;

import org.junit.jupiter.api.Test;

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

    private void printLinkedList(MyLinkedList linkedList) {
        String printString = "";
        for (int i = 0; i < linkedList.size(); i++) {
            printString += ", "+ linkedList.get(i);
        }
        System.out.println(printString.substring(2));
    }

}