package ds.lru;

import ds.linkedList.DLLNode;
import ds.linkedList.DLLNodeImpl;
import ds.queue.Queue;
import ds.queue.QueueImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public class LRUWithLinkedListImpl<T> implements LRUCache<T, T> {
    private Map<T,DLLNodeImpl<T>> pageToNode;
    private QueueImpl<T> queue;
    private int maxSize;
    public LRUWithLinkedListImpl(int size) {
        this.pageToNode = new HashMap<T, DLLNodeImpl<T>>();
        this.queue = new QueueImpl<T>();
        this.maxSize = size;
    }

    public T getData(T page) {
        if(pageToNode.containsKey(page))
        {
            System.out.println("Cache Hit for: " + page);
            DLLNodeImpl<T> dllNode = pageToNode.get(page);
            queue.removeFromQueue(dllNode);
            DLLNodeImpl<T> newDllNode = (DLLNodeImpl<T>)queue.enQueue(page);
            pageToNode.put(page, newDllNode);
            return newDllNode.getData();
        }
        else
        {
            System.out.println("Cache Miss for: " + page);
            if(queue.getSize()==maxSize)
            {
                pageToNode.remove(queue.getLast().getData());
                queue.removeFromQueue((DLLNodeImpl<T>) queue.getLast());
                pageToNode.put(page,(DLLNodeImpl<T>) queue.enQueue(page));
                return page;
            }
            else
            {
                pageToNode.put(page,(DLLNodeImpl<T>) queue.enQueue(page));
                return page;
            }
        }
    }

    public void printCache() {
        this.queue.printQueue();
    }

}
