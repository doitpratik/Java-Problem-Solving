package com.company.lecture20;

import java.util.Arrays;

public class CustomQueues {
    protected Integer[] data;
    protected int front;
    protected int rear;
    protected static final int DEFFAULT_SIZE = 10;

    CustomQueues(int size){
        this.data = new Integer[size];
        this.rear = -1;
    }
    public CustomQueues(){
        this(DEFFAULT_SIZE);
    }
    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue Overflow!!!");
            return;
        }
        this.data[++rear] = value;
    }

    private boolean isFull() {
        return this.rear == this.data.length-1;
    }
    public Integer dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow!!!");
            return null;
        }
        int temp  = this.data[0];
        for (int i = 0; i < rear; i++) {
            this.data[i] = this.data[i+1];
        }
        this.rear--;
        return temp;
    }

    private boolean isEmpty() {
        return this.rear == -1;
    }

    @Override
    public String toString(){
       StringBuilder str  = new StringBuilder("Queues : ");
        for (int i = 0; i <= rear ; i++) {
            str.append(this.data[i]).append(" ");
        }
        return str.toString();
    }
}
