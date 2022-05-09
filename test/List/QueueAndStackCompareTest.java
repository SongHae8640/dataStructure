package List;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class QueueAndStackCompareTest {

    @Test
    public void addDataTest(){
        int dataCount = 50000000;
        System.out.println("dataCount = "+ dataCount);

        Queue<Integer> queue = new LinkedList<>();
        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            queue.add(i);
        }
        AtomicLong endTime = new AtomicLong(System.currentTimeMillis() - startTime.get());
        System.out.println("queue add running time = "+ endTime);

        //

        queue.clear();
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            queue.offer(i);
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("queue offer running time = "+ endTime);

        //

        Deque<Integer> dequeue = new ArrayDeque<>();
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.add(i);
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue add running time = "+ endTime);

        //

        dequeue.clear();
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.offer(i);
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue offer running time = "+ endTime);

        //

        Stack<Integer> stack = new Stack<>();
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            stack.push(i);
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("stack push running time = "+ endTime);


    }

    /**
     *
     * dataCount = 50000000
     * queue add running time = 14121
     * queue offer running time = 15009
     * dequeue add running time = 3795
     * dequeue offer running time = 1893
     * stack push running time = 3074
     */


    @Test
    public void removeDataTest(){

        int dataCount = 50000000;
        System.out.println("dataCount = "+ dataCount);

        Queue<Integer> queue = new LinkedList<>();
        addData(queue, dataCount);

        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        for (int i = 0; i < queue.size(); i++) {
            queue.remove();
        }
        AtomicLong endTime = new AtomicLong(System.currentTimeMillis() - startTime.get());
        System.out.println("queue remove running time = "+ endTime);

        //

        addData(queue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            queue.poll();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("queue poll running time = "+ endTime);

        //

        Deque<Integer> dequeue = new ArrayDeque<>();
        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.remove();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue remove(removeFirst) running time = "+ endTime);

        //

        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.poll();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue poll(pollFirst) running time = "+ endTime);

        //
        System.out.println();
        //

        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.removeLast();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue removeLast running time = "+ endTime);

        //

        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.pollLast();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue pollLast running time = "+ endTime);

        //

        Stack<Integer> stack = new Stack<>();
        addData(stack, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            stack.pop();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("stack pop running time = "+ endTime);


    }
    /**
     * dataCount = 50000000
     * queue remove running time = 1288
     * queue poll running time = 2302
     * dequeue remove(removeFirst) running time = 424
     * dequeue poll(pollFirst) running time = 151
     *
     * dequeue removeLast running time = 411
     * dequeue pollLast running time = 305
     * stack pop running time = 398
     */

    private void addData(Queue<Integer> queue, int dataCount) {
        queue.clear();
        for (int i = 0; i < dataCount; i++) {
            queue.add(i);
        }
    }

    private void addData(Stack<Integer> stack, int dataCount) {
        stack.clear();
        for (int i = 0; i < dataCount; i++) {
            stack.push(i);
        }
    }


}
