package ds.linkedList;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public class DLLImpl<T> implements DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public DLLNode<T> addToHead(T data) {
        if (head == null) {
            head = new DLLNodeImpl<T>(data);
            tail = head;
        } else {
            DLLNode<T> newHead = new DLLNodeImpl<T>(data);
            newHead.setNext(head);
            head.setPrev(newHead);
            head = newHead;
        }
        size++;
        return head;
    }

    public DLLNode<T> addToTail(T data) {
        if (tail != null) {
            DLLNode<T> newTail = new DLLNodeImpl<T>(data);
            newTail.setPrev(tail);
            tail.setNext(newTail);
            tail = newTail;
        } else {
            head = new DLLNodeImpl<T>(data);
            tail = head;
        }
        size++;
        return tail;
    }

    public T removeHead() {
        if (head == null)
            return null;
        DLLNode<T> oldHead = head;
        DLLNode<T> oldHeadNext = head.getNext();
        if (oldHeadNext == null) {
            head = null;
            tail = null;
            size--;
            return oldHead.getData();
        }
        oldHeadNext.setPrev(null);
        oldHead.setNext(null);
        head = oldHeadNext;
        size--;
        return oldHead.getData();
    }

    public T removeTail() {
        if (tail == null)
            return null;
        DLLNode<T> oldTail = tail;
        DLLNode<T> oldTailPrev = tail.getPrev();
        if (oldTailPrev == null) {
            head = null;
            tail = null;
            size--;
            return oldTail.getData();
        }
        size--;
        oldTailPrev.setNext(null);
        oldTail.setPrev(null);
        tail = oldTailPrev;
        return oldTail.getData();
    }

    public void removeData(T data) {
        DLLNode<T> nodeToDelete = findNode(data);
        removeNode(nodeToDelete);
    }

    public void removeNode(DLLNode<T> nodeToDelete) {
        if (nodeToDelete == head) {
            removeHead();
            return;
        }
        if (nodeToDelete == tail) {
            removeTail();
            return;
        }
        DLLNode<T> nodeToDeletePrev = nodeToDelete.getPrev();
        DLLNode<T> nodeToDeleteNext = nodeToDelete.getNext();
        if (nodeToDeletePrev != null)
            nodeToDeletePrev.setNext(nodeToDeleteNext);
        if (nodeToDeleteNext != null)
            nodeToDeleteNext.setPrev(nodeToDeletePrev);
        size--;
    }

    private DLLNode<T> findNode(T data) {
        DLLNode<T> headNode = this.head;
        while (headNode != null) {
            if (headNode.getData().equals(data))
                return headNode;
            headNode = headNode.getNext();
        }
        return null;
    }

    public void printDLL() {
        DLLNode<T> headNode = this.head;
        String print = "";
        while (headNode != null) {
            print = print + headNode.getData() + " <=> ";
            headNode = headNode.getNext();
        }
        System.out.println(print + "NULL");
    }

    public DLLNode<T> getHead() {
        return head;
    }

    public void setHead(DLLNode<T> head) {
        this.head = head;
    }

    public DLLNode<T> getTail() {
        return tail;
    }

    public void setTail(DLLNode<T> tail) {
        this.tail = tail;
    }
}
