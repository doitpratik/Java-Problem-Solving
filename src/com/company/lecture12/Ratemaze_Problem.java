package com.company.lecture12;

import java.util.Arrays;

public class Ratemaze_Problem {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        int[][] sol = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length ; j++) {
                sol[i][j] = 0;
            }
        }
        maze_Solu(maze, sol, 0,0);
        //System.out.println(Arrays.deepToString(sol));

    }

    private static void maze_Solu(int[][] maze, int[][] sol, int i, int i1) {
        if(i == maze.length-1 && i1== maze[0].length-1 && maze[i][i1]==1){
            sol[i][i1]=1;
            System.out.println(Arrays.deepToString(sol));
            return;
        }
        if(issafe(maze,i,i1)){
            sol[i][i1]=1;
            maze_Solu(maze,sol, i+1, i1);
            maze_Solu(maze,sol,i,i1+1);
            sol[i][i1]=0;
        }

    }

    private static boolean issafe(int[][] maze, int i, int i1) {
        return (i>=0 && i< maze.length && i1>=0 && i1<maze[0].length && maze[i][i1]==1);
    }
}
