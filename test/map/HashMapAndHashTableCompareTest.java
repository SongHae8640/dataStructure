package map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class HashMapAndHashTableCompareTest {

    @Test
    public void putTest(){
        int dataSizeLimit = 10000000;
        int dataSize = 1;

        System.out.println("put running time test\n");
        while (dataSize <= dataSizeLimit){
            System.out.print("dataSize = "+ String.format("%10d",dataSize) );

            Map hashtable = new Hashtable();
            System.out.print(", hashTable = " + String.format("%10s", putData(hashtable, dataSize)) );

            Map hashMap = new HashMap();
            System.out.print(", hashMap = " + String.format("%10s", putData(hashMap, dataSize)) );

            dataSize *=10;
            System.out.println();
        }
    }
    /**
     * put running time test
     *
     * dataSize =          1, hashTable =          3, hashMap =          0
     * dataSize =         10, hashTable =          0, hashMap =          0
     * dataSize =        100, hashTable =          0, hashMap =          0
     * dataSize =       1000, hashTable =          2, hashMap =          1
     * dataSize =      10000, hashTable =         10, hashMap =          9
     * dataSize =     100000, hashTable =         61, hashMap =         31
     * dataSize =    1000000, hashTable =        339, hashMap =        302
     *
     * dataSize 가 10000000 이 넘으면 hashTable 에서 OOM 발생
     *
     * hashTable과 hashMap의 순서를 반대로 했을때
     * dataSize =          1, hashMap =          4, hashTable =          0
     * dataSize =         10, hashMap =          1, hashTable =          0
     * dataSize =        100, hashMap =          1, hashTable =          1
     * dataSize =       1000, hashMap =          4, hashTable =          2
     * dataSize =      10000, hashMap =         10, hashTable =          9
     * dataSize =     100000, hashMap =         73, hashTable =         39
     * dataSize =    1000000, hashMap =        421, hashTable =        277
     * dataSize =   10000000, hashMap =       3751
     */


    @Test
    public void getTest(){

        int dataSizeLimit = 1000000;
        int dataSize = 1;
        int getCount = 100000000;

        System.out.println("get running time test");
        System.out.printf("get count = %d\n\n", getCount);
        while (dataSize <= dataSizeLimit){
            System.out.print("dataSize = "+ String.format("%10d",dataSize) );

            Map hashtable = new Hashtable();
            putData(hashtable, dataSize);
            System.out.print(", hashTable = " + String.format("%10s", getHashValue(hashtable, getCount)) );

            Map hashMap = new HashMap();
            putData(hashMap, dataSize);
            System.out.print(", hashMap = " + String.format("%10s", getHashValue(hashMap, getCount)) );

            dataSize *=10;
            System.out.println();
        }
    }
    /**
     * get running time test
     * get count = 100000000
     *
     * dataSize =          1, hashTable =       5962, hashMap =       4699
     * dataSize =         10, hashTable =       8385, hashMap =       5922
     * dataSize =        100, hashTable =       7280, hashMap =       5671
     * dataSize =       1000, hashTable =       7567, hashMap =       6099
     * dataSize =      10000, hashTable =       7421, hashMap =       7106
     * dataSize =     100000, hashTable =       8895, hashMap =       7870
     * dataSize =    1000000, hashTable =      11130, hashMap =       9818
     *
     *
     * hashTable과 hashMap의 순서를 반대로 했을때
     * dataSize =          1, hashMap =       4882, hashTable =       6114
     * dataSize =         10, hashMap =       5122, hashTable =       7393
     * dataSize =        100, hashMap =       5271, hashTable =       6416
     * dataSize =       1000, hashMap =       5185, hashTable =       6534
     * dataSize =      10000, hashMap =       6143, hashTable =       8745
     * dataSize =     100000, hashMap =       7551, hashTable =       9024
     * dataSize =    1000000, hashMap =       9270, hashTable =      11956
     */



    @Test
    public void removeKeyTest(){
        int dataSizeLimit = 1000000;
        int dataSize = 1;

        System.out.println("remove running time test\n");
        while (dataSize <= dataSizeLimit){
            System.out.print("dataSize = "+ String.format("%10d",dataSize) );

            Map hashtable = new Hashtable();
            putData(hashtable, dataSize);
            System.out.print(", hashTable = " + String.format("%10s", removeKey(hashtable, dataSize)) );


            Map hashMap = new HashMap();
            putData(hashMap, dataSize);
            System.out.print(", hashMap = " + String.format("%10s", removeKey(hashMap, dataSize)) );
            dataSize *=10;
            System.out.println();
        }
    }

    /**
     * remove running time test
     *
     * dataSize =          1, hashTable =          0, hashMap =          0
     * dataSize =         10, hashTable =          0, hashMap =          0
     * dataSize =        100, hashTable =          0, hashMap =          0
     * dataSize =       1000, hashTable =          2, hashMap =          1
     * dataSize =      10000, hashTable =          5, hashMap =          4
     * dataSize =     100000, hashTable =         20, hashMap =         17
     * dataSize =    1000000, hashTable =        169, hashMap =        156
     *
     * hashTable과 hashMap의 순서를 반대로 했을때
     * dataSize =          1, hashMap =          1, hashTable =          0
     * dataSize =         10, hashMap =          0, hashTable =          0
     * dataSize =        100, hashMap =          0, hashTable =          1
     * dataSize =       1000, hashMap =          2, hashTable =          1
     * dataSize =      10000, hashMap =          7, hashTable =          4
     * dataSize =     100000, hashMap =         18, hashTable =         25
     * dataSize =    1000000, hashMap =        167, hashTable =        270
     */

    private String removeKey(Map map, int dataSize) {
        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        for (int i = 0; i < dataSize; i++) {
            map.remove("key"+i);
        }
        return new AtomicLong(System.currentTimeMillis() - startTime.get()).toString();
    }

    private String getHashValue(Map map, int dataSize) {
        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        for (int i = 0; i < dataSize; i++) {
            map.get("key"+i);
        }
        return new AtomicLong(System.currentTimeMillis() - startTime.get()).toString();
    }

    private String putData(Map map, int dataSize) {
        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        for (int i = 0; i < dataSize; i++) {
            map.put("key"+i, i);
        }
        return new AtomicLong(System.currentTimeMillis() - startTime.get()).toString();
    }
}
