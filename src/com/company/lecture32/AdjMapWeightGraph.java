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

    public void primsTrial(){
        Vertex abc = vertices.values().iterator().next();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((Comparator<Edge>) (o1, o2) -> o1.weight -o2.weight);
        visited.add(abc);
        for(Vertex sub : abc.neighbours.keySet()){
            int weight = abc.neighbours.get(sub);
            pq.add(new Edge(abc, sub, weight));
        }
        int mstCost = 0;
        while(!pq.isEmpty()){
            Edge xyz = pq.remove();

            if(!visited.contains(xyz.end)){
                mstCost += xyz.weight;
                visited.add(xyz.end);
                abc = xyz.end;
                for (Vertex sub: abc.neighbours.keySet()) {
                    if(!visited.contains(sub)){
                        int weight = abc.neighbours.get(sub);
                        pq.add(new Edge(abc, sub, weight));
                    }
                }
            }

        }
        System.out.println(mstCost);
    }
    public void dijkstraTrial(){
        Vertex abc = vertices.values().iterator().next();
        Map<E,Integer> dj_map = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((Comparator<Edge>) (o1, o2) -> o1.weight -o2.weight);
        visited.add(abc);
        dj_map.put(abc.value, 0);
        for(Vertex sub : abc.neighbours.keySet()){
            int weight = abc.neighbours.get(sub);
            pq.add(new Edge(abc, sub, weight));
        }
        int mstCost = 0;
        while(!pq.isEmpty()){
            Edge xyz = pq.remove();

            if(!visited.contains(xyz.end)){
                //mstCost += xyz.weight;
                dj_map.put(xyz.end.value, (dj_map.get(xyz.start.value) + xyz.weight));
                //System.out.print(xyz.end.value +" -> "+ dj_map.get(xyz.end.value) + " ");
                visited.add(xyz.end);
                abc = xyz.end;
                //System.out.print(abc + " ");
                for (Vertex sub: abc.neighbours.keySet()) {
                    if(!visited.contains(sub)){
                        int weight = abc.neighbours.get(sub);
                        pq.add(new Edge(abc, sub, weight));
                    }else{
                        int cost = dj_map.get(sub.value);
                        //System.out.print(sub.value+" -> "+dj_map.get(sub.value) + " ");
                        int cost_1 = (dj_map.get(abc.value) + abc.neighbours.get(sub));
                        if(cost > cost_1){
                            dj_map.replace(xyz.end.value, cost_1);
                            //pq.add(new Edge(abc, sub, cost_1));
                            //visited.remove(sub);
                        }
                    }
                }
                //System.out.println();
            }else{
                int cost = dj_map.get(xyz.end.value);
                int cost_1 = (dj_map.get(xyz.start.value) + xyz.weight);
                if(cost > cost_1){
                    dj_map.replace(xyz.end.value, cost_1);
                    //pq.add(new Edge(xyz.start, xyz.end, cost_1));
                    //visited.remove(xyz.end);
                }

            }

        }
        for (E val: dj_map.keySet()) {
            System.out.println(val + " -> " + dj_map.get(val));
        }
        //System.out.println(mstCost);
    }
    private class Nodes{
        Vertex a;
        int weight;
        public Nodes(Vertex a, int weight){
            this.a = a;
            this.weight = weight;
        }
    }
    public void dijkstraTrial_2(E val){
        // In the Dijkstra Deal with individual vertex not with edges other wise it will create a overhead and
        // will not check the changes values and will not update the values
        Vertex vert = vertices.get(val);
        Map<E, Integer> count_map = new HashMap<>();
        for(E value : vertices.keySet()){
            count_map.put(value, Integer.MAX_VALUE);
        }
        PriorityQueue<Nodes> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        count_map.put(vert.value, 0);
        pq.add(new Nodes(vert, 0));
        while(!pq.isEmpty()){
            Nodes node = pq.poll();
            //Vertex end = node.end;
            for(Vertex end_nei : node.a.neighbours.keySet()){
                /*if(count_map.get(end_nei.value) == null){
                    count_map.put(end_nei.value, count_map.get(node.start.value) + node.end.neighbours.get(end_nei));
                    pq.add(new Edge(node.start, end_nei, count_map.get(end_nei.value)));
                }*/
                if((count_map.get(node.a.value) + node.a.neighbours.get(end_nei)) < count_map.get(end_nei.value)){
                    count_map.replace(end_nei.value, count_map.get(node.a.value) + node.a.neighbours.get(end_nei));
                    pq.add(new Nodes(end_nei, count_map.get(end_nei.value)));
                }

            }
        }
        for (E set_val : count_map.keySet()) {
            System.out.println(set_val+" -> "+count_map.get(set_val));
        }

    }

}
