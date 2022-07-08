package com.company.lecture32;

import java.util.*;

public class AdjMapWeightGraph <E>{
    HashMap<E, Vertex> vertices = new HashMap<>();
    private class Vertex{
        E value;
        Map<Vertex, Integer> neighbours;

        public Vertex(E value) {
            this.value = value;
            this.neighbours = new HashMap<>();
        }
        public void addNeighbours(Vertex vertex, Integer weight){
            neighbours.put(vertex, weight);
        }

        @Override
        public String toString() {
            return (value + "");
        }
    }

    private class Edge{
        private Vertex start;
        private Vertex end;
        private Integer weight;

        public Edge(Vertex start, Vertex end, Integer weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public void addVertex(E value){
        if(!vertices.containsKey(value)){
            vertices.put(value, new Vertex(value));
        }
    }

    public void addEdge(E start, E end, Integer weight){
        Vertex first = vertices.get(start);
        Vertex second = vertices.get(end);
        if(first == null){
            addVertex(start);
            first = vertices.get(start);
        }
        if(second == null){
            addVertex(end);
            second = vertices.get(end);
        }

        first.addNeighbours(second, weight);
        second.addNeighbours(first, weight);
    }
    public int prims(){
        Vertex start = vertices.values().iterator().next();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((Comparator<Edge>) (o1, o2) -> o1.weight - o2.weight);
        visited.add(start);
        for(Vertex end : start.neighbours.keySet()){
            int weight = start.neighbours.get(end);
            pq.add(new Edge(start, end, weight));
        }
        int mstCost = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.remove();
            if(!visited.contains(edge.end)){
                mstCost += edge.weight;
                start = edge.end;
                visited.add(start);
                for(Vertex end : start.neighbours.keySet()){
                    if(!visited.contains(end)) {
                        int weight = start.neighbours.get(end);
                        pq.add(new Edge(start, end, weight));
                    }
                }
            }
        }
        return mstCost;
    }
}
