package ds.heap;

/**
 * Created by shlok.chaurasia on 17/02/16.
 */
public class HeapNode implements Comparable {
    private Integer data;
    public int compareTo(Object o) {
        HeapNode heapNode = (HeapNode) o;
        return (this.data - heapNode.data);
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
