package ds.graph;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public class EdgeFactory<E, V> {
    GraphTypeEnum graphType;

    public EdgeFactory(GraphTypeEnum graphType) {
        this.graphType = graphType;
    }

    public Edge<E> createEdge(Vertex<V> source, Vertex<V> destination, E weight)
    {
        if(graphType == GraphTypeEnum.UNDIRECTED)
        {
            return new UndirectedEdge<E, V>(source, destination, weight);
        }

        return null;
    }

}
