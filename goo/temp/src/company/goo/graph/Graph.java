package company.goo.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shlok on 5/5/2016.
 */
public class Graph {
    Map<Integer, Vertex> vertices;
    public Graph()
    {
        vertices = new HashMap<Integer, Vertex>();
    }
    public void addVertex(int data)
    {
        Vertex v = new Vertex(data);
        vertices.put(data, v);
    }
    public void addEdge(int source, int destination)
    {
        vertices.get(source).adjVertices.add(vertices.get(destination));
    }

    public boolean isRoute(int source, int destination)
    {
        return modifiedDfs(vertices.get(source), vertices.get(destination));
    }

    private boolean modifiedDfs(Vertex source, Vertex destination)
    {
        source.visited=true;
        for(Vertex v : source.adjVertices)
        {
            if(v.equals(destination))
                return true;
            if(!v.visited && modifiedDfs(v, destination))
            {
                return true;
            }
        }
        return false;
    }

    public void dfs()
    {
        for(Vertex v :vertices.values())
        {
            if(!v.visited)
            {
                dfsUtil(v);
            }
        }
    }

    private void dfsUtil(Vertex source)
    {
        if(!source.visited)
        {
            source.visited=true;
            System.out.println(source.data);
            for(Vertex v : source.adjVertices)
            {
                if(!v.visited)
                {

                    dfsUtil(v);
                }
            }
        }
    }
}
