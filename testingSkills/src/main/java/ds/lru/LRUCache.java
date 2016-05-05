package ds.lru;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public interface LRUCache<T, V> {
    T getData(V atIndex);
}
