package com.company.lecture33;

import java.util.Scanner;

public class ModifiedTravellingSalesman {
    public static int ans = Integer.MAX_VALUE;
    public static int[] x = new int[20];
    public static int[] y = new int[20];
    public static int n ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            ans = Integer.MAX_VALUE;
            n = sc.nextInt();
            x[n+1] = sc.nextInt();
            y[n+1] = sc.nextInt();
            x[0] = sc.nextInt();
            y[0] = sc.nextInt();

            for(int j = 1; j <= n; j++){
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
            }

            boolean[] visited = new boolean[n+2];
            for(boolean x: visited){
                x = false;
            }

            optimalPath(0, visited, 0, 0);
            System.out.println("#" + i+1 + " " + ans);
        }
    }

    private static void optimalPath(int x, boolean[] visited, int nodes, int value) {
        if(n == nodes){
            ans = Math.min(ans, value+dist(x, n+1));
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                optimalPath(i, visited, nodes+1, value + dist(x, i));
                visited[i] = false;
            }
        }
    }

    private static int dist(int a, int i) {
        int x1 = x[a], x2 = x[i];
        int y1 = y[a], y2 = y[i];
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
