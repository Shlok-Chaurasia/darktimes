package com.company;

import com.company.graph.Graph;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph g = new Graph();
        g.addVertex(12);
        g.addVertex(10);
        g.addVertex(16);
        g.addVertex(1);
        g.addVertex(17);
        g.addVertex(27);
        g.addEdge(10,16);
        g.addEdge(16,17);
        g.addEdge(16,27);
        g.addEdge(1,17);
        g.addEdge(27,12);
        System.out.println(g.isRoute(12,10));
    }
}
