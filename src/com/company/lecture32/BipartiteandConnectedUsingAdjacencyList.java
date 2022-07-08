package com.company.lecture32;

import java.util.*;

public class BipartiteandConnectedUsingAdjacencyList<E> {
    HashMap<E, Vertex> vertexmap = new HashMap<>();
    private class Vertex{
        E value;
        LinkedList<Vertex> neighbours;

        public Vertex(E value) {
            this.value = value;
            this.neighbours = new LinkedList<>();
        }

        @Override
        public String toString() {
            return value+"";
        }
    }

    public void addVertex(E value){
        if(find(value) == null){
            vertexmap.put(value, new Vertex(value));
        }
    }

    private Vertex find(E value) {
        return vertexmap.get(value);
    }

    public void addEdge(E value1, E value2){
         Vertex first = vertexmap.get(value1);
         Vertex second = vertexmap.get(value2);
        if(first == null){
            addVertex(value1);
            first = vertexmap.get(value1);
        }
        if(second == null){
            addVertex(value2);
            second = vertexmap.get(value2);
        }

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public void dft(E start){
        Vertex starti = vertexmap.get(start);
        Stack<Vertex> stk = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        List<E> list = new ArrayList<>();
        stk.push(starti);
        visited.add(starti);
        while(!stk.isEmpty()){
            Vertex curr_Ver = stk.pop();
            list.add(curr_Ver.value);
            for (Vertex neighbour: curr_Ver.neighbours) {
                if(!visited.contains(neighbour)){
                    stk.push(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        for (E val: list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public void bft(E start){
        Vertex startii = vertexmap.get(start);
        Queue<Vertex> que = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        List<E> printing = new ArrayList<>();

        que.add(startii);
        visited.add(startii);

        while(!que.isEmpty()){
            Vertex curr_ver = que.remove();
            printing.add(curr_ver.value);

            for(Vertex neighbour: curr_ver.neighbours){
                if(!visited.contains(neighbour)){
                    que.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        for (E val: printing) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public boolean dfs(E start, E val){
        Vertex starti = vertexmap.get(start);
        Stack<Vertex> stk = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        //List<E> list = new ArrayList<>();
        stk.push(starti);
        visited.add(starti);
        while(!stk.isEmpty()){
            Vertex curr_Ver = stk.pop();
            //list.add(curr_Ver.value);
            if(curr_Ver.value.equals(val)){
                return true;
            }
            for (Vertex neighbour: curr_Ver.neighbours) {
                if(!visited.contains(neighbour)){
                    stk.push(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return false;
    }

    public boolean bfs(E start, E val){
         Vertex startii = vertexmap.get(start);
        Queue<Vertex> que = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        //List<E> printing = new ArrayList<>();

        que.add(startii);
        visited.add(startii);

        while(!que.isEmpty()){
            Vertex curr_ver = que.remove();
            //printing.add(curr_ver.value);
            if(curr_ver.value.equals(val)){
                return true;
            }
            for(Vertex neighbour: curr_ver.neighbours){
                if(!visited.contains(neighbour)){
                    que.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        /*for (E val: printing) {
            System.out.print(val + " ");
        }
        System.out.println();*/
        return false;
    }

    public List<LinkedList<E>> connectedComponents(){
        //Solving using dfs approach (bfs can be done just by replacing the stack to queue)
        List<LinkedList<E>> list = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        //Stack<Vertex> stack = new Stack();
        for(Vertex start: vertexmap.values()){
            if(!visited.contains(start)){
                LinkedList<E> templist = new LinkedList<>();
                Stack<Vertex> stk = new Stack<>();
                stk.push(start);
                visited.add(start);
                while(!stk.isEmpty()){
                    Vertex curr_Ver = stk.pop();
                    templist.add(curr_Ver.value);
                    for (Vertex neighbour: curr_Ver.neighbours) {
                        if(!visited.contains(neighbour)){
                            stk.push(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }
                list.add(templist);
            }
        }
        return list;
    }
    public boolean isConnected(){
        return this.connectedComponents().size() <= 1;
    }

    public boolean isBipartite(){
        //Solving using dfs approach (bfs can be done just by replacing the stack to queue)
        Set<Vertex> red = new HashSet<>();
        Set<Vertex> blue = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        for(Vertex vertex: vertexmap.values()){
            if(!red.contains(vertex) && !blue.contains(vertex)){
                stack.push(vertex);
                red.add(vertex); // we can put in the blue as well just have to maintain the code further according to that
                while(!stack.isEmpty()){
                    Vertex curr_ver = stack.pop();
                    for(Vertex neighbour: curr_ver.neighbours){
                        if(red.contains(curr_ver)){
                            if(red.contains(neighbour)){
                                return false;
                            }else if(!blue.contains(neighbour)){
                                stack.push(neighbour);
                                blue.add(neighbour);
                            }
                        }else{
                            if(blue.contains(neighbour)){
                                return false;
                            }else if(!red.contains(neighbour)){
                                stack.push(neighbour);
                                red.add(neighbour);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void print() {
        for (Vertex vertex: vertexmap.values()) {
            System.out.println(vertex + "->" + vertex.neighbours);
        }
    }
}
