package company.goo.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shlok on 5/6/2016.
 */
public class VertexWithEdge {
    int data;
    Set<Edge> edgeSet;
    public VertexWithEdge(int data)
    {
        this.data=data;
        edgeSet= new HashSet<Edge>();
    }
}
