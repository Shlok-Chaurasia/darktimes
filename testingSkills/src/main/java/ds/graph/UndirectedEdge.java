package ds.graph;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public class UndirectedEdge<T, V> implements Edge<T> {
    Vertex<V> source;
    Vertex<V> destination;
    T weight;

    public UndirectedEdge(Vertex<V> source, Vertex<V> destination, T weight) {
        this.destination=destination;
        this.source=source;
        this.weight = weight;
    }

    public Vertex<V> getDestination() {
        return destination;
    }

    public void setDestination(Vertex<V> destination) {
        this.destination = destination;
    }

    public Vertex<V> getSource() {
        return source;
    }

    public void setSource(Vertex<V> source) {
        this.source = source;
    }



    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }


}
