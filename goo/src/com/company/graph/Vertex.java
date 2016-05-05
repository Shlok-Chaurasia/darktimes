package com.company.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shlok on 5/5/2016.
 */
public class Vertex {
    int data;
    boolean visited;
    Set<Vertex> adjVertices;
    Vertex(int data)
    {
        this.data = data;
        this.visited=false;
        adjVertices = new HashSet<Vertex>();
    }
}
