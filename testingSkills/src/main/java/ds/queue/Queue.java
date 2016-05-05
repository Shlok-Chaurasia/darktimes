package ds.queue;

import ds.linkedList.DLLNode;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public interface Queue<T> {
    DLLNode<T> enQueue(T data);
    T deQueue();
}
