package map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTest {
    
    @Test
    public void putAndGetTest(){
        HashMap hashMap = new HashMap();
        int dataCount = 20;
        for (int i = 0; i < dataCount; i++) {
            hashMap.put(""+i, "" + i*2);
        }

        for (int i = 0; i < dataCount; i++) {
            assertEquals(""+i*2 , hashMap.get(""+i));
        }

    }

    @Test
    public void containsKeyTest(){
        HashMap hashMap = new HashMap();
        int dataCount = 10;
        for (int i = 0; i < dataCount; i++) {
            hashMap.put(""+i, "" + i*2);
        }

        Random rand = new Random();
        assertEquals(true , hashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , hashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , hashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , hashMap.containsKey(""+rand.nextInt(dataCount)));
        assertEquals(true , hashMap.containsKey(""+rand.nextInt(dataCount)));

        assertEquals(false, hashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, hashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, hashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, hashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
        assertEquals(false, hashMap.containsKey(""+(dataCount+rand.nextInt(dataCount))));
    }


    @Test
    public void containsValueTest(){
        HashMap hashMap = new HashMap();
        int dataCount = 10;
        for (int i = 0; i < dataCount; i++) {
            hashMap.put(""+i, "" + i*2);
        }

        Random rand = new Random();
        assertEquals(true , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));
        assertEquals(true , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 )));

        assertEquals(false , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
        assertEquals(false , hashMap.containsValue(""+(rand.nextInt(dataCount) * 2 - 1)));
    }

    @Test
    public void isEmptyTest(){
        HashMap hashMap = new HashMap();
        assertEquals(true , hashMap.isEmpty());

    }


    @Test
    public void removeTest(){
        HashMap hashMap = new HashMap();
        int dataCount = 10;
        for (int i = 0; i < dataCount; i++) {
            hashMap.put(""+i, "" + i);
        }

        assertEquals(null , hashMap.remove(null));
        for (int i = 0; i < dataCount; i++) {
            assertEquals(false , hashMap.isEmpty());
            assertEquals(""+i , hashMap.remove(""+i));
        }
        assertEquals(true , hashMap.isEmpty());
    }

    @Test
    public void sizeTest(){
        HashMap hashMap = new HashMap();

        int dataCount = 10;
        for (int i = 0; i < dataCount; i++) {
            hashMap.put(""+i, "" + i);
            assertEquals(i+1 , hashMap.size());
        }

        for (int i = 0; i < dataCount; i++) {
            hashMap.remove(""+i);
            assertEquals(dataCount-i-1 , hashMap.size());
        }

    }
}
