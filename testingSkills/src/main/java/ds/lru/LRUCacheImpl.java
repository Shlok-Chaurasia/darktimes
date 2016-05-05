package ds.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public class LRUCacheImpl<T> implements LRUCache<T, T> {

    private Map<T, T> dataMap;
    private Queue<T> lruQueue;
    private Integer lruSize;

    public LRUCacheImpl(int lruSize) {
        this.dataMap = new HashMap<T, T>();
        this.lruQueue = new LinkedList<T>();
        this.lruSize = lruSize;
    }

    public T getData(T page) {
        // if page in LRU.
        System.out.println("Looking for page in cache.." + page);
        if (dataMap.containsKey(page)) {
            System.out.println("Cache hit!!!");
            T element = dataMap.get(page);
            lruQueue.remove(element);
            lruQueue.add(element);
            return lruQueue.peek();
        } else {
            System.out.println("Cache Miss!!!");
            if (dataMap.size() == lruSize) {
                T data = lruQueue.remove();
                lruQueue.add(page);
                dataMap.remove(data);
                dataMap.put(page, page);
                return lruQueue.peek();
            } else {
                lruQueue.add(page);
                dataMap.put(page, page);
                return lruQueue.peek();
            }
        }
    }

    public void printCache() {
        System.out.println(this.lruQueue);
    }

}
