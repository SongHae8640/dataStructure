package List;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedListCompareTest {

    @Test
    public void compareAddTest(){
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        int caseNumber = 100000;


        //순차 추가
        System.out.println("addAsc(arrayList)   :: "+addAsc(arrayList, caseNumber));
        System.out.println("addAsc(linkedList)  :: "+addAsc(linkedList, caseNumber));

        System.out.println();

        //중간 추가
        System.out.println("addInMiddle(arrayList)  :: "+addInMiddle(arrayList, caseNumber));
        System.out.println("addInMiddle(linkedList) :: "+addInMiddle(linkedList, caseNumber));

        System.out.println();

        //역순 추가
        System.out.println("addDesc(arrayList)  :: "+addDesc(arrayList, caseNumber));
        System.out.println("addDesc(linkedList) :: "+addDesc(linkedList, caseNumber));

        System.out.println();

        //랜덤 추가
        System.out.println("addRandom(arrayList)    :: "+addRandom(arrayList, caseNumber));
        System.out.println("addRandom(linkedList)   :: "+addRandom(linkedList, caseNumber));


    }
    /**
     * addAsc(arrayList)   :: 8
     * addAsc(linkedList)  :: 5
     *
     * addInMiddle(arrayList)  :: 1028
     * addInMiddle(linkedList) :: 25473
     *
     * addDesc(arrayList)  :: 3567
     * addDesc(linkedList) :: 6
     *
     * addRandom(arrayList)    :: 2552
     * addRandom(linkedList)   :: 64172
     */



    private long getRandom(List list) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < list.size(); i++) {
            randomIndex = random.nextInt(list.size());
            list.get(randomIndex);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long getDesc(List list) {
        long startTime = System.currentTimeMillis();
        for (int i = list.size() -1; i >= 0 ; i--) {
            list.get(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long getAsc(List list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long removeRandom(List list) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < list.size(); i++) {
            randomIndex = random.nextInt(list.size());
            list.remove(randomIndex);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long removeDesc(List list) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(list.size()-1);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long removeAsc(List list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(0);
        }
        return System.currentTimeMillis() - startTime;
    }


    private long addRandom(List list, int caseNumber) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < caseNumber; i++) {
            randomIndex = random.nextInt(list.size());
            list.add(randomIndex,i);
        }
        return System.currentTimeMillis() - startTime;
    }



    private long addDesc(List list, int caseNumber) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < caseNumber; i++) {
            list.add(0,i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long addInMiddle(List list , int caseNumber) {
        int midIndex;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < caseNumber; i++) {
            midIndex = list.size()/2;
            list.add(midIndex,i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long addAsc(List list, int caseNumber) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < caseNumber; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - startTime;
    }
}
