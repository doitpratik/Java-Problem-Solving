package com.company.lecture33;

import java.util.Scanner;

public class EndoScopeProblem {
    public int row, col, _x, _y, _l;
    public int[][] map;
    public boolean[][] visited;
    class Node{
        int x,y,l;
        Node(int x, int y, int l){
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
    Node[] arr = new Node[1000000];
    int front, back;
    public void init(){
        front = 0;
        back = 0;
    }
    public void push(Node temp){
        arr[back++] = temp;
    }

    public Node pop(){
        return arr[front++];
    }

    public boolean isEmpty(){
        return front == back;
    }

    public boolean valid(int x, int y){
        return (x >= 0 && x < row && y >= 0 && y < col);
    }

    public boolean left(int x, int y){
        return (map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 6 || map[x][y] == 7);
    }

    public boolean right(int x, int y){
        return (map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5);
    }

    public boolean up(int x, int y){
        return (map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 7);
    }

    public boolean down(int x, int y){
        return (map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 5 || map[x][y] == 6);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            EndoScopeProblem xyz = new EndoScopeProblem();
            xyz.init();
            xyz.row = sc.nextInt();
            xyz.col = sc.nextInt();
            xyz._x = sc.nextInt();
            xyz._y = sc.nextInt();
            xyz._l = sc.nextInt();

            xyz.map = new int[xyz.row][xyz.col];
            xyz.visited = new boolean[xyz.row][xyz.col];

            for (int i = 0; i < xyz.row; i++) {
                for (int j = 0; j < xyz.col; j++) {
                    xyz.map[i][j] = sc.nextInt();
                    xyz.visited[i][j] = false;
                }
            }
            if(xyz.map[xyz._x][xyz._y] > 0){
                System.out.println(xyz.solve(xyz._x, xyz._y, xyz._l));
            }
            t--;
        }
    }

    public int solve(int x, int y, int l) {
        int ans = 0;
        push(new Node(x, y, l));
        visited[x][y] = true;
        while(!isEmpty()){
            Node cur = pop();
            int x1 = cur.x;
            int y1 = cur.y;
            int l1 = cur.l;
            if(l1 == 0){
                continue;
            }
            ans++;
            if(valid(x1, y1-1) && left(x1, y1) && right(x1, y1-1) && !visited[x1][y1-1]){
                push(new Node(x1, y1-1, l1-1));
                visited[x1][y1-1] = true;
            }

            if(valid(x1, y1+1) && right(x1, y1) && left(x1, y1+1) && !visited[x1][y1+1]){
                push(new Node(x1, y1+1, l1-1));
                visited[x1][y1+1] = true;
            }

            if(valid(x1-1, y1) && up(x1, y1) && down(x1-1, y1) && !visited[x1-1][y1]){
                push(new Node(x1-1, y1, l1-1));
                visited[x1-1][y1] = true;
            }

            if(valid(x1+1, y1) && down(x1, y1) && up(x1+1, y1) && !visited[x1+1][y1]){
                push(new Node(x1+1, y1, l1-1));
                visited[x1+1][y1] = true;
            }
        }
        return ans;
    }
}
