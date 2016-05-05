package ds.linkedList;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public class DLLNodeImpl<T> implements DLLNode<T> {

    DLLNode<T> prev;
    DLLNode<T> next;
    T data;

    public DLLNodeImpl(T data) {
        this.data = data;
    }

    public DLLNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DLLNode<T> prev) {
        this.prev = prev;
    }

    public DLLNode<T> getNext() {
        return next;
    }

    public void setNext(DLLNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
