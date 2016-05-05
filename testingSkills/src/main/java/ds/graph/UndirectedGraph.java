package ds.graph;

import ds.union.Subset;
import ds.union.UnionFindDSByRankImpl;

import java.util.*;

/**
 * Created by shlok.chaurasia on 10/02/16.
 */
public class UndirectedGraph<V, E> implements Graph<V, E> {
    Set<Vertex<V>> vertices;
    Map<Vertex<V>, Set<Edge<E>>> vertexToEdge;
    UnionFindDSByRankImpl<V> unionFindDSByRank;
    EdgeFactory<E, V> edgeFactory;
    VertexFactory vertexFactory;

    public UndirectedGraph() {
        this.vertices = new HashSet<Vertex<V>>();
        this.vertexToEdge = new HashMap<Vertex<V>, Set<Edge<E>>>();
        this.edgeFactory = new EdgeFactory<E, V>(GraphTypeEnum.UNDIRECTED);
        this.vertexFactory = new VertexFactory(GraphTypeEnum.UNDIRECTED);
        unionFindDSByRank = new UnionFindDSByRankImpl<V>();
    }

    public Set<Vertex<V>> getVertex() {
        return vertices;
    }

    public Set<Edge<E>> getAllEdges() {
        Set<Edge<E>> listEdges = new HashSet<Edge<E>>();
        for(Set<Edge<E>> edges : vertexToEdge.values())
        {
            listEdges.addAll(edges);
        }
        return listEdges;
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, E weight) {
        final Edge<E> edge = this.edgeFactory.createEdge(source, destination, weight);
        addEdgeToVertex(source, edge);
        addEdgeToVertex(destination, edge);
    }

    private void addEdgeToVertex(Vertex<V> vertex, final Edge<E> edge) {
        if (vertexToEdge.containsKey(vertex)) {
            vertexToEdge.get(vertex).add(edge);
        } else {
            vertexToEdge.put(vertex, new HashSet<Edge<E>>() {{
                add(edge);
            }});
        }
    }

    public void addVertex(V vertexData) {
        Vertex<V> vertex = this.vertexFactory.createVertex(vertexData);
        vertices.add(vertex);
    }

    public boolean isCyclic()
    {
        int count = 0;
        Subset<V> subset = null;
        for(Edge edge: this.getAllEdges())
        {
            if(checkIfSubsetAlreadyHas((UndirectedEdge<E, V>) edge, subset))
                return true;
            Vertex<V> source = ((UndirectedEdge<E, V>) edge).getSource();
            Vertex<V> destination = ((UndirectedEdge<E, V>) edge).getDestination();
            Subset<V> subset1 = new Subset<V>(source);
            Subset<V> subset2 = new Subset<V>(destination);
            Subset<V> subsetToMerge = unionFindDSByRank.union(subset1,subset2);
            if(count==0)
                {count++; subset = subsetToMerge; continue; }
            subset = unionFindDSByRank.union(subsetToMerge, subset);
        }
        return false;
    }

    private boolean checkIfSubsetAlreadyHas(UndirectedEdge<E, V> edge, Subset<V> subset)
    {
        if (subset == null) return false;
        Vertex<V> source = ((UndirectedEdge<E, V>) edge).getSource();
        Vertex<V> destination = ((UndirectedEdge<E, V>) edge).getDestination();
        return (subset.getNodes().contains(source) || subset.getNodes().contains(destination));
    }
}
