package ds.linkedList;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public interface DLL<T> {
    DLLNode<T> addToHead(T data);
    DLLNode<T> addToTail(T data);
    T removeHead();
    T removeTail();
    void removeData(T data);
}
