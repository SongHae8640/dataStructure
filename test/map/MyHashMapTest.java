package map;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    
    @Test
    public void putAndGetTest(){
        MyHashMap myHashMap = new MyHashMap();
        int dataCount = 20;
        for (int i = 0; i < dataCount; i++) {
            myHashMap.put(""+i, "" + i*2);
        }

        for (int i = 0; i < dataCount; i++) {
            assertEquals(""+i*2 , myHashMap.get(""+i));
        }

    }

    @Test
    public void containsKeyTest(){
        MyHashMap myHashMap = new MyHashMap();
        int dataCount = 10;
        for (int i = 0; i < dataCount; i++) {
            myHashMap.put(""+i, "" + i*2);
        }

        Random rand = new Random();
        assertEquals(true , myHashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , myHashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , myHashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , myHashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , myHashMap.containsKey(""+rand.nextInt(dataCount)));

        assertEquals(false, myHashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, myHashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, myHashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, myHashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, myHashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
    }


    @Test
    public void containsValueTest(){
        MyHashMap myHashMap = new MyHashMap();
        int dataCount = 10;
        for (int i = 0; i < dataCount; i++) {
            myHashMap.put(""+i, "" + i*2);
        }

        Random rand = new Random();
        assertEquals(true , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));

        assertEquals(false , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , myHashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
    }

    @Test
    public void isEmptyTest(){
        MyHashMap myHashMap = new MyHashMap();
        assertEquals(true , myHashMap.isEmpty());

    }


    @Test
    public void removeTest(){

    }

}