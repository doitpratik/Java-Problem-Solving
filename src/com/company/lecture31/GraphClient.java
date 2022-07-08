package com.company.lecture31;

import com.company.lecture32.BipartiteandConnectedUsingAdjacencyList;

public class GraphClient {
    public static void main(String[] args) {
        /*AdjacenyListGraph<Character> graph = new AdjacenyListGraph<>();
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'B');
        graph.addEdge('C', 'D');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');

        graph.dft('B');
        graph.bft('B');
        System.out.println();
        graph.dft('A');
        graph.bft('A');
        System.out.println();
        graph.print();
        System.out.println();
        System.out.println(graph.bfs('A', 'D'));*/

        BipartiteandConnectedUsingAdjacencyList<Character> graph = new BipartiteandConnectedUsingAdjacencyList<>();
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'B');
        //graph.addEdge('C','D');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'F');
        graph.addVertex('G');

        System.out.println(graph.connectedComponents()) ;
        System.out.println(graph.isConnected());
        System.out.println();
        System.out.println(graph.isBipartite());
    }
}
