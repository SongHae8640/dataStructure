package List;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {


    @Test
    public void add(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList.toString());

        arrayList.add(0, 0);
        System.out.println(arrayList.toString());

        assertEquals(1, arrayList.get(1));
        assertEquals(5, arrayList.get(5));

    }

    @Test
    public void addOutOfIndexError(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        assertThrows(Exception.class, () -> arrayList.add(-1, -1));
        assertThrows(Exception.class, () -> arrayList.add(100, 100));

    }

    @Test
    public void addMoreDefaultCapacity(){
        ArrayList arrayList = new ArrayList();
        int capacity = 11;
        for (int i = 0; i < capacity; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.toString());

        assertNotNull(arrayList.get(capacity-1));
    }

    @Test
    public void remove(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList.toString());

        arrayList.remove(0);
        System.out.println(arrayList.toString());

        assertEquals(1, arrayList.get(0));
        assertEquals(null, arrayList.get(5));

        arrayList.add(6);
        assertEquals(6, arrayList.get(5));
        System.out.println(arrayList.toString());

        assertEquals(false,arrayList.remove(null));

    }

    @Test
    public void getSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList.toString());
        assertEquals(6, arrayList.size());

        arrayList.remove(0);
        System.out.println(arrayList.toString());
        assertEquals(5, arrayList.size());


        arrayList.add(6);
        System.out.println(arrayList.toString());
        assertEquals(6, arrayList.size());

    }

    @Test
    public void indexOf(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.toString());
        assertEquals(6, arrayList.indexOf(6));

    }

    @Test
    public void isEmpty(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < 10; i++) {
            arrayList.remove(0);
        }
        System.out.println(arrayList.toString());
        assertEquals(true, arrayList.isEmpty());
    }

    @Test
    public void clear(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.clear();

        System.out.println(arrayList.toString());
        assertEquals(0, arrayList.size());


    }

    @Test
    public void ensureCapacity(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        int minCapacity = 20;
        arrayList.ensureCapacity(20);
        Object[] myArray = arrayList.toArray();

        System.out.println(arrayList.toString());
        assertEquals(minCapacity, myArray.length);

        Object[] objects = Arrays.copyOf(myArray, minCapacity);
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + ", ");
        }
        assertEquals(minCapacity, objects.length);

    }

    @Test
    public void lastIndexOf(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i%2);
        }

        assertEquals(9, arrayList.lastIndexOf(1));
    }

    @Test
    public void set(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        assertEquals(5, arrayList.set(5,10));
        assertEquals(10, arrayList.get(5));
    }

    @Test
    public void contains(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        assertEquals(true , arrayList.contains(1));
        assertEquals(false , arrayList.contains(100));
    }

}