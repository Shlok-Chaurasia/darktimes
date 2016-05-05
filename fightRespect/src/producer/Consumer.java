package producer;

import java.util.Queue;

/**
 * Created by shlok.chaurasia on 26/02/16.
 */
public class Consumer implements Runnable{
    BlockingQueueImpl queue;
    int maxSize;

    public Consumer(BlockingQueueImpl queue, int maxSize) {
        this.queue = new BlockingQueueImpl(maxSize);
        this.maxSize = maxSize;
    }

    private void consume() {
        try {
            queue.removeQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        consume();
    }
}
