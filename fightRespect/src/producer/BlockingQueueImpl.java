package producer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shlok.chaurasia on 26/02/16.
 */
public class BlockingQueueImpl {
    Queue<String> list = new LinkedList<>();
    int maxSize;

    public BlockingQueueImpl(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void insertQueue(String data) throws InterruptedException {
            while (list.size() == maxSize) {
                wait();
                System.out.println("Max Queue Size reached. Waiting!!!");
            }
            System.out.println("Adding element");
            list.add(data);
            notify();
    }

    public synchronized String removeQueue() throws InterruptedException {
        while (true) {
            while (list.isEmpty()) {
                wait();
                System.out.println("Empty Queue. Waiting!!!");
            }
            System.out.println("Removing!!!");
            String s = list.remove();
            notifyAll();
            System.out.print(s);
        }
    }
}
