package ds.graph;

import java.util.Set;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public interface Graph<V, E> {
    Set<Vertex<V>> getVertex();
    Set<Edge<E>> getAllEdges();
    void addEdge(Vertex<V> source, Vertex<V> destination, E weight);
    void addVertex(V vertexData);
}
