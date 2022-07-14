package com.company.lecture33;

import java.util.Scanner;

public class SpaceWormholes {
    public static final int LONG =1000000009;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int[] x = new int[(2*n + 2)],y = new int[(2*n + 2)];
            int[][] graph = new int[(2*n + 2)][(2*n + 2)];
            for (int i = 0; i < (2*n + 2); i++) {
                for (int j = 0; j < (2*n + 2); j++) {
                    graph[i][j] = -1;
                }
            }

            for (int i = 0; i < 2; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }

            for(int i = 2; i < (2*n + 2); i+=2){
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                x[i+1] = sc.nextInt();
                y[i+1] = sc.nextInt();
                int cost = sc.nextInt();
                graph[i][i+1] = graph[i+1][i]  = cost;

            }

            for(int i = 0; i < (2*n+2); i++){
                for (int j = i+1; j < (2*n+2); j++) {
                    if(i%2 == 0 && i >= 2 && j == i+1){
                        continue;
                    }
                    graph[i][j] = graph[j][i] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                }
            }

            //System.out.println(Arrays.deepToString(graph));
            int z = dijsktra(graph, n);
            System.out.println(z);
            t--;
        }
    }

    static int dijsktra(int[][] graph, int n){
        boolean[] visited = new boolean[2*n+2];
        int[] distance = new int[2*n+2];
        for (int i = 0; i < 2*n+2; i++) {
            visited[i] = false;
            distance[i] = LONG;
        }
        distance[0] = 0;
        for (int i = 0; i < 2*n+1; i++) {
            int u = find_min(distance, visited, n);
            visited[u] = true;
            for(int v = 0; v < 2*n+2; v++){
                if(!visited[v] && distance[u] != LONG && graph[u][v] != -1 && distance[u]+graph[u][v] < distance[v]){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        return distance[1];
    }

    private static int find_min(int[] distance, boolean[] visited, int n) {
        int val = LONG;
        int index = -1;
        for (int i = 0; i < 2*n+2; i++) {
            if(!visited[i] && distance[i] != LONG && distance[i] < val){
                index = i;
                val = distance[i];
            }
        }
        return index;
    }
}
