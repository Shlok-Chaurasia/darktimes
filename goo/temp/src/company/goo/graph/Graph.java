package company.goo.graph;

import java.util.*;

/**
 * Created by Shlok on 5/5/2016.
 */
public class Graph {
    Map<Integer, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<Integer, Vertex>();
    }

    public void addVertex(int data) {
        Vertex v = new Vertex(data);
        vertices.put(data, v);
    }

    public void addEdge(int source, int destination) {
        vertices.get(source).adjVertices.add(vertices.get(destination));
    }
    public boolean isCycleUnDirected(){

        for(Vertex v: vertices.values())
        {
            if(!v.visited && isCycleUtil(v, null))
                return true;
        }

        return false;
    }

    public boolean isCycleUtil(Vertex source, Vertex parent)
    {
        source.visited=true;
        for(Vertex v:source.adjVertices)
        {
            if(!v.visited)
            {
                if(isCycleUtil(v, source))
                    return true;
            }
            if(v!=parent)
                return true;
        }
        return false;
    }
    public Boolean isCycle()
    {
        Stack<Vertex> st = new Stack<Vertex>();

        for(Vertex v: vertices.values())
        {
            System.out.println(v.data);
            HashMap<Vertex, Boolean> hb = new HashMap<Vertex, Boolean>();
            if(!v.visited && topologicalSortUtil(st, v, hb))
            {
                return true;
            }
        }
        return false;
    }

    public boolean topologicalSortUtil(Stack st, Vertex v, HashMap<Vertex, Boolean> hb)
    {
        if(!v.visited)
        {
            System.out.println("vertex:"+v.data);
            v.visited=true;
            st.push(v);
            hb.put(v, true);
            for(Vertex vertex : v.adjVertices)
            {
                System.out.println("Adj: "+ vertex.data);
                if(hb.containsKey(vertex) && hb.get(vertex))
                    return true;
                else
                {   if(!v.visited && topologicalSortUtil(st, vertex, hb))
                        return true;
                }
            }
            hb.remove(v);
        }
        return false;

    }
    public boolean isRoute(int source, int destination) {
        return modifiedDfs(vertices.get(source), vertices.get(destination));
    }

    private boolean modifiedDfs(Vertex source, Vertex destination) {
        source.visited = true;
        for (Vertex v : source.adjVertices) {
            if (v.equals(destination))
                return true;
            if (!v.visited && modifiedDfs(v, destination)) {
                return true;
            }
        }
        return false;
    }
    public void bfs()
    {
        for (Vertex v : vertices.values()) {
        if (!v.visited) {
            Queue<Vertex> queue = new LinkedList<Vertex>();
            queue.add(v);
            bfsUtil(queue);
        }
    }


    }
    public void bfsUtil(Queue<Vertex> queue) {
        while (!queue.isEmpty()) {
            Vertex source = queue.remove();
            if (!source.visited) {
                source.visited = true;
                System.out.println(source.data);
                for (Vertex v : source.adjVertices) {
                    if (!v.visited) {
                        queue.add(v);
                    }
                }
            }
        }
    }

    public void dfs() {
        for (Vertex v : vertices.values()) {
            if (!v.visited) {
                dfsUtil(v);
            }
        }
    }

    private void dfsUtil(Vertex source) {
        if (!source.visited) {
            source.visited = true;
            System.out.println(source.data);
            for (Vertex v : source.adjVertices) {
                if (!v.visited) {

                    dfsUtil(v);
                }
            }
        }
    }
}
