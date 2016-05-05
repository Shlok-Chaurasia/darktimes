package ds.graph;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public class VertexFactory<T> {
    GraphTypeEnum graphType;

    public VertexFactory(GraphTypeEnum graphType) {
        this.graphType = graphType;
    }

    public Vertex<T> createVertex(T data)
    {
        if(graphType == GraphTypeEnum.UNDIRECTED)
        {
            return new UndirectedVertex<T>(data);
        }
        return null;
    }
}
