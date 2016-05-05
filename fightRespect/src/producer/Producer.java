package producer;

import java.util.Queue;

/**
 * Created by shlok.chaurasia on 26/02/16.
 */
public class Producer implements Runnable {
    BlockingQueueImpl queue;
    int maxSize;
    String message;

    public Producer(BlockingQueueImpl queue, int maxSize, String message) {
        this.queue = new BlockingQueueImpl(maxSize);
        this.maxSize = maxSize;
        this.message = message;
    }

    private void produce() {
        try {
            queue.insertQueue(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        produce();
    }
}
