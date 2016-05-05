package ds.queue;

import ds.common.GenericNode;
import ds.common.GenericNodeImpl;
import ds.linkedList.DLL;
import ds.linkedList.DLLImpl;
import ds.linkedList.DLLNode;
import ds.linkedList.DLLNodeImpl;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public class QueueImpl<T> implements Queue<T> {
    DLLImpl<T> dll;

    public int getSize() {
        return dll.getSize();
    }

    public QueueImpl() {
        dll = new DLLImpl<T>();
    }

    public DLLNode<T> enQueue(T data) {
        return dll.addToHead(data);

    }

    public T deQueue() {
        return dll.removeTail();
    }

    public DLLNodeImpl<T> removeFromQueue(DLLNodeImpl<T> dllNode)
    {
        dll.removeNode(dllNode);
        return dllNode;
    }

    public DLLNode<T> getFirst() {
        return dll.getHead();
    }

    public DLLNode<T> getLast() {
        return dll.getTail();
    }

    public void printQueue()
    {
        this.dll.printDLL();
    }
}
