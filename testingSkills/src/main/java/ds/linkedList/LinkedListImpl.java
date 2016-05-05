package ds.linkedList;

/**
 * Created by shlok.chaurasia on 03/03/16.
 */
public class LinkedListImpl<T> implements LinkedListNode<T> {

    public T data;
    public LinkedListImpl<T> nextNode;

    public LinkedListNode getNext() {
        return nextNode;
    }

    public void setNext(LinkedListNode<T> nextNode) {
        this.nextNode=(LinkedListImpl<T>) nextNode;
    }

    public T getData() {
        return data;
    }

    private void setData(T data)
    {
        this.data=data;
    }
}
