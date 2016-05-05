package ds.linkedList;

import ds.common.GenericNode;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public interface DLLNode<T>{
    DLLNode<T> getNext();
    void setNext( DLLNode<T> next);
    DLLNode<T> getPrev();
    void setPrev(DLLNode<T> prev);
    void setData(T data);
    T getData();
}
