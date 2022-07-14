package com.company.lecture32;

public class AdjMapGraphClient {
    public static void main(String[] args) {
        AdjMapWeightGraph<Character> graph = new AdjMapWeightGraph<>();
        /*graph.addEdge('A', 'C', 2);
        graph.addEdge('A', 'B', 7);
        graph.addEdge('B', 'C', 6);
        graph.addEdge('B', 'F', 1);
        graph.addEdge('B', 'D', 4);
        graph.addEdge('D', 'F', 3);
        //graph.addEdge('C', 'F', 1);
        graph.addEdge('E', 'F', 2);*/

        // Another Graph

        graph.addEdge('A', 'B', 4);
        graph.addEdge('A', 'C', 4);
        graph.addEdge('C', 'G', 4);
        graph.addEdge('C', 'B', 2);
        graph.addEdge('G', 'H', 1);
        graph.addEdge('C', 'H', 3);
        //graph.addEdge('B', 'H', 3);
        graph.addEdge('B', 'D', 3);
        graph.addEdge('B', 'F', 6);
        graph.addEdge('B', 'E', 1);
        graph.addEdge('B', 'D', 3);
        graph.addEdge('E', 'F', 3);
        graph.addEdge('D', 'F', 2);
        System.out.println(graph.prims());
        //graph.primsTrial();
        graph.dijkstraTrial();
        System.out.println();
        graph.dijkstraTrial_2('A');


    }
}
