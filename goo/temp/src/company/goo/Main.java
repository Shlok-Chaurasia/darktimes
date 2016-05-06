package company.goo;

import company.goo.graph.Graph;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph g = new Graph();
        g.addVertex(1);
        g.addEdge(1,1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(8);
        g.addEdge(1,2);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(3,8);
        g.addEdge(8,5);
        g.addEdge(8,8);
//        g.addEdge(4,1);
//        System.out.print(g.isCycleUnDirected());
        System.out.print(g.isCycle());
//        g.addVertex(12);
//        g.addVertex(10);
//        g.addVertex(16);
//        g.addVertex(1);
//        g.addVertex(17);
//        g.addVertex(8);
//        g.addVertex(27);
//        g.addVertex(11);
//        g.addEdge(10,16);
//        g.addEdge(16,17);
//        g.addEdge(16,27);
//        g.addEdge(1,17);
//        g.addEdge(27,12);
//        g.addEdge(17,11);
//        g.addEdge(17,8);
//        g.bfs();
//        System.out.println(g.isRoute(16,8));
    }
}
