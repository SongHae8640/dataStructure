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
        System.out.println("dequeue remove running time = "+ endTime);

        //

        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.poll();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue poll running time = "+ endTime);

        //
        System.out.println();
        //

        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.removeFirst();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue removeFirst running time = "+ endTime);

        //

        addData(dequeue, dataCount);
        startTime.set(System.currentTimeMillis());
        for (int i = 0; i < dataCount; i++) {
            dequeue.pollFirst();
        }
        endTime.set(System.currentTimeMillis() - startTime.get());
        System.out.println("dequeue pollFirst running time = "+ endTime);

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
     * queue remove running time = 1021
     * queue poll running time = 1972
     * dequeue remove running time = 367
     * dequeue poll running time = 191
     *
     * dequeue removeFirst running time = 356
     * dequeue pollFirst running time = 212
     * stack pop running time = 262
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
