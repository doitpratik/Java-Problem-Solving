package com.company.lecture15;

public class Maze_AdvProb {
    public static void main(String[] args) {
        int n=4, m=3;
        int[][] maze = new int[n][m];
        int sRow = 2, sCol=1;
        int fRow=3, fCol =0;
        int[][] bombs = {{0,0},{1,2}};
        for(int[] bomb : bombs){
            maze[bomb[0]][bomb[1]] = 1;
        }
        maze_prob(maze, sRow, sCol, fRow, fCol, "");
    }

    private static void maze_prob(int[][] maze, int sRow, int sCol, int fRow, int fCol, String solution) {
        if(sRow < 0 || sRow >= maze.length || sCol < 0 || sCol >= maze[0].length){
            return;
        }
        if(maze[sRow][sCol] == 1){
            return;
        }
        if(sRow == fRow && sCol == fCol){
            System.out.println(solution);
            return;
        }
        maze[sRow][sCol] = 1;
        maze_prob(maze, sRow-1, sCol, fRow, fCol, solution+'N');
        maze_prob(maze, sRow, sCol+1, fRow, fCol, solution+'E');
        maze_prob(maze, sRow+1, sCol, fRow, fCol, solution+'S');
        maze_prob(maze, sRow, sCol-1, fRow, fCol, solution+'W');
        maze[sRow][sCol] = 0;
    }
}
