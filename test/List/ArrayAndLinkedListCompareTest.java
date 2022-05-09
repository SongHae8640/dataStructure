package List;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayAndLinkedListCompareTest {

    @Test
    public void compareAddTest() {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        int caseNumber = 10000000;


        //순차 추가
        System.out.println("addAsc(arrayList)   :: " + addAsc(arrayList, caseNumber));
        System.out.println("addAsc(linkedList)  :: " + addAsc(linkedList, caseNumber));

        System.out.println();

        //중간 추가
        System.out.println("addInMiddle(arrayList)  :: " + addInMiddle(arrayList, caseNumber));
        System.out.println("addInMiddle(linkedList) :: " + addInMiddle(linkedList, caseNumber));

        System.out.println();

        //역순 추가
        System.out.println("addDesc(arrayList)  :: " + addDesc(arrayList, caseNumber));
        System.out.println("addDesc(linkedList) :: " + addDesc(linkedList, caseNumber));

        System.out.println();

        //랜덤 추가
        System.out.println("addRandom(arrayList)    :: " + addRandom(arrayList, caseNumber));
        System.out.println("addRandom(linkedList)   :: " + addRandom(linkedList, caseNumber));


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



    @Test
    public void compareRemoveTest(){
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        int caseNumber = 100000;


        //순차 삭제
        addAsc(arrayList, caseNumber);
        addDesc(linkedList, caseNumber);
        System.out.println("removeAsc(arrayList)    :: "+removeAsc(arrayList));
        System.out.println("removeAsc(linkedList)   :: "+removeAsc(linkedList));

        System.out.println();


        //역순 삭제
        addAsc(arrayList, caseNumber);
        addDesc(linkedList, caseNumber);
        System.out.println("removeDesc(arrayList)   :: "+removeDesc(arrayList));
        System.out.println("removeDesc(linkedList)  :: "+removeDesc(linkedList));

        System.out.println();

        //랜덤 삭제
        addAsc(arrayList, caseNumber);
        addDesc(linkedList, caseNumber);
        System.out.println("removeRandom(arrayList)     :: "+removeRandom(arrayList));
        System.out.println("removeRandom(linkedList)    :: "+removeRandom(linkedList));

    }
    /**
     * removeAsc(arrayList)    :: 519
     * removeAsc(linkedList)   :: 3
     *
     * removeDesc(arrayList)   :: 5
     * removeDesc(linkedList)  :: 4
     *
     * removeRandom(arrayList)     :: 797
     * removeRandom(linkedList)    :: 11459
     */



    @Test
    public void getTest(){
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        int caseNumber = 100000;

        addAsc(arrayList, caseNumber);
        addAsc(linkedList, caseNumber);

        //순차 조회
        System.out.println("getAsc(arrayList)   :: "+getAsc(arrayList));
        System.out.println("getAsc(linkedList)  :: "+getAsc(linkedList));

        System.out.println();

        //iterator 순차 조회
        System.out.println("getAscIterator (arrayList)   :: "+getAscIterator(arrayList));
        System.out.println("getAscIterator(linkedList)  :: "+getAscIterator(linkedList));

        System.out.println();


        //역차 조회
        System.out.println("getDesc(arrayList)  :: "+getDesc(arrayList));
        System.out.println("getDesc(linkedList) :: "+getDesc(linkedList));

        System.out.println();

        //iterator 역차 조회
        System.out.println("getDescIterator (arrayList)   :: "+getDescIterator(arrayList));
        System.out.println("getDescIterator(linkedList)  :: "+getDescIterator(linkedList));

        System.out.println();

        //순차 조회
        System.out.println("getRandom(arrayList)    :: "+getRandom(arrayList));
        System.out.println("getRandom(linkedList)   :: "+getRandom(linkedList));


    }



    /**
     * getAsc(arrayList)   :: 7
     * getAsc(linkedList)  :: 10553
     *
     * getAscIterator (arrayList)   :: 4
     * getAscIterator(linkedList)  :: 4
     *
     * getDesc(arrayList)  :: 2
     * getDesc(linkedList) :: 10335
     *
     * getDescIterator (arrayList)   :: 5
     * getDescIterator(linkedList)  :: 5
     *
     * getRandom(arrayList)    :: 9
     * getRandom(linkedList)   :: 15035
     *
     * Process finished with exit code 0
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

    private long getDescIterator(List<String> list) {
        long startTime = System.currentTimeMillis();
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            String previous = iterator.previous();
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

    private long getAscIterator(List<String> list) {
        long startTime = System.currentTimeMillis();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
        }
        return System.currentTimeMillis() - startTime;

    }

    private long removeRandom(List<String> list) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < list.size(); i++) {
            randomIndex = random.nextInt(list.size());
            list.remove(randomIndex);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long removeDesc(List<String> list) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(list.size()-1);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long removeAsc(List<String> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(0);
        }
        return System.currentTimeMillis() - startTime;
    }


    private long addRandom(List<String> list, int caseNumber) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < caseNumber; i++) {
            randomIndex = random.nextInt(list.size());
            list.add(randomIndex,""+i);
        }
        return System.currentTimeMillis() - startTime;
    }



    private long addDesc(List<String> list, int caseNumber) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < caseNumber; i++) {
            list.add(0,""+i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private long addInMiddle(List<String> list , int caseNumber) {
        int midIndex;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < caseNumber; i++) {
            midIndex = list.size()/2;
            list.add(midIndex,""+i);
        }
        return System.currentTimeMillis() - startTime;
    }


    private long addAsc(List<String> list, int caseNumber) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < caseNumber; i++) {
            list.add(""+i);
        }
        return System.currentTimeMillis() - startTime;
    }
}
