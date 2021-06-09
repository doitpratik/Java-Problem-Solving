package com.company.lecture15;

import java.util.concurrent.atomic.AtomicLong;

public class Gold_Count {
    public static void main(String[] args) {
        int[][] maze = {{1,0,7},
                        {2,0,6},
                        {3,4,5},
                        {0,3,0},
                        {9,0,20}};
        //int sRow = 0, sCol = 1 ;
        int max = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                int res = maze_prob(maze, i, j, 0);
                if(res > max){
                    max = res;
                }
            }
        }
        System.out.println(max);
    }

    private static int maze_prob(int[][] maze, int sRow, int sCol, int total) {
        if(sRow < 0 || sRow >= maze.length || sCol < 0 || sCol >= maze[0].length){
            return total;
        }
        if(maze[sRow][sCol] == 0){
            return total;
        }
        int value = maze[sRow][sCol];
        maze[sRow][sCol]=0;
        int top = maze_prob(maze, sRow-1, sCol, total+value);
        int topright = maze_prob(maze, sRow-1, sCol+1, total+value);
        int right = maze_prob(maze, sRow, sCol+1, total+value);
        int rightbottom = maze_prob(maze, sRow+1, sCol+1, total+value);
        int bottom = maze_prob(maze, sRow+1, sCol, total+value);
        int leftbottom = maze_prob(maze, sRow+1, sCol-1, total+value);
        int left  = maze_prob(maze, sRow, sCol-1, total+value);
        int topleft = maze_prob(maze, sRow-1, sCol-1, total+value);
        maze[sRow][sCol]=value;
        return Math.max(Math.max(Math.max(topright, leftbottom), Math.max(rightbottom, topleft)),Math.max(Math.max(top, bottom), Math.max(right, left)));
        //return Math.max(Math.max(top, bottom), Math.max(right, left));
    }
}
