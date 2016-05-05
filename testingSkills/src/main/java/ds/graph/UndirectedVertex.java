package ds.graph;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public class UndirectedVertex<T> implements Vertex<T>, Comparable<T> {
    T data;

    public UndirectedVertex(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public int compareTo(T o) {
        return this.data.equals(o) ? 0 : -1;
    }
}
