package ds.linkedList;

import ds.common.GenericNode;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public interface LinkedListNode<T> extends GenericNode<T> {
    LinkedListNode<T> getNext();
    void setNext(LinkedListNode<T> next);
}
