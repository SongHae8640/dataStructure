package List;

import java.util.Arrays;

public class MyArrayList{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public boolean add(int index, Object element) {
        rangeCheckForAdd(index);

        resizeCapacity(size+1);

        for(int i = size ; i >= index ; i --){
            elementData[i+1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
    }

    public boolean add(Object o) {
        resizeCapacity(size+1);
        elementData[size] = o;
        size++;
        return true;
    }

    public void clear(){
        for (int i = 0; i <elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if(elementData[i] == null) return true;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(o.equals(elementData[i])) return true;
            }
        }

        return false;
    }


    public void ensureCapacity(int minCapacity) {
        if(minCapacity > elementData.length){
            resizeCapacity(minCapacity);
        }
    }

    public Object get(int index){
        return elementData[index];
    }

    public Object indexOf(Object o){
        for (int i = 0; i < size; i++) {
            if(elementData[i].equals(o)) return i;
        }

        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int lastIndexOf(Object o) {
        if(o ==null){
            for (int i = size-1; i >= 0 ; i--) {
                if(elementData[i] == null) return i;
            }
        }else{
            for (int i = size-1; i >= 0 ; i--) {
                if(o.equals(elementData[i])) return i;
            }

        }
        return -1;
    }


    public boolean remove(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if(elementData[i] == null){
                    remove(i);
                    return true;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(o.equals(elementData[i])){
                    remove(i);
                    return true;
                }
            }

        }
        return false;
    }


    public Object remove(int index) {
        Object removedObject = elementData[index];

        for(int i = index ; i < size-1 ; i++){
            elementData[i] = elementData[i+1];
        }

        size--;
        elementData[size] = null;

        return removedObject;
    }

    public Object set(int index, Object element) {
        Object oldElement = elementData[index];
        elementData[index] = element;
        return oldElement;
    }


    public int size(){
        return size;
    }


    public Object[] toArray() {
        return elementData;
    }


    private void resizeCapacity(int capacity) {
        if(capacity <= elementData.length) return;

        Object[] resizedElementData = new Object[capacity];
        for (int i = 0; i < elementData.length; i++) {
            resizedElementData[i] = elementData[i];
        }
        elementData = resizedElementData;
    }

    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("index : "+ index + ", size : " + size);
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
