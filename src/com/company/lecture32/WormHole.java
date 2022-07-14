package com.company.lecture32;

import java.util.ArrayList;
import java.util.Scanner;

class Vertex{
    int x;
    int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class WormHole {
        public static int distance(Vertex src, Vertex dst){
            return Math.abs(dst.x - src.x) + Math.abs(dst.y - src.y);
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Vertex> vertexList = new ArrayList<>();

            int sx = sc.nextInt();
            int sy = sc.nextInt();
            vertexList.add(new Vertex(sx, sy));

            int dx= sc.nextInt();
            int dy = sc.nextInt();
            Vertex dst_node = new Vertex(dx, dy);

            int hole_count = sc.nextInt();

            int[][] graph = new int[hole_count * 2 + 2][hole_count * 2 + 2];

            for(int i = 0; i < graph.length; i++){
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = -1;
                }
            }

            int graphIndex = 1;
            for (int i = 0; i < hole_count; i++) {
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                Vertex hole_start = new Vertex(x1, y1);
                vertexList.add(hole_start);

                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                Vertex hole_end = new Vertex(x2, y2);
                vertexList.add(hole_end);

                int distance = sc.nextInt();

                graph[graphIndex][graphIndex + 1] = graph[graphIndex + 1][graphIndex] = distance;
                graphIndex += 2;
            }
            vertexList.add(dst_node);

            // for filling starting and destination
            for(int i = 0; i < graph.length; i++){
                graph[0][i] = distance(vertexList.get(0), vertexList.get(i));
                graph[graph.length-1][i] = distance(vertexList.get(graph.length-1), vertexList.get(i));
            }

            //now filling the remaining indexes of the wormholes
            for (int i = 1; i < graph.length-1; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if(i==j){
                        graph[i][j] = 0;
                    }else if(graph[i][j] == -1){
                        if(i % 2 == 1){
                            graph[i][j] = graph[i][i+1] + distance(vertexList.get(i+1), vertexList.get(j));
                        }else{
                            graph[i][j] = graph[i][i-1] + distance(vertexList.get(i-1), vertexList.get(j));
                        }
                    }
                }
            }
            graph[0][graph.length-1] = graph[graph.length-1][0] = distance(vertexList.get(0), vertexList.get(vertexList.size()-1));

            //printing the graph
            System.out.println("printing adj matrix!");
             for (int i = 0; i < graph.length; i++) {
                 for (int j = 0; j < graph.length; j++) {
                     System.out.print(graph[i][j] + "    ");
                 }
                 System.out.println();
             }
            boolean[] visited = new boolean[hole_count*2+2];

            getMinDistance(graph, 0, graph.length-1, visited, 0);
            System.out.println();
            System.out.println(ans);
        }

    private static void getMinDistance(int[][] graph, int curr_ver, int fin_ver, boolean[] visited, int curr_dis) {
            if(curr_ver == fin_ver){
                ans = Math.min(curr_dis, ans);
                return ;
            }
            if(visited[curr_ver]){
                return ;
            }
            visited[curr_ver] = true;

            for(int i = 0; i < graph.length; i++){
                getMinDistance(graph, i, fin_ver, visited, curr_dis + graph[curr_ver][i]);
            }
            visited[curr_ver] = false;
    }

    public static int ans = Integer.MAX_VALUE;

}
