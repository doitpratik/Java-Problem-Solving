package com.company.lecture20;

public class CustomCirQueue {
    protected Integer[] data;
    protected int front;
    protected int rear;
    protected int size;
    protected static final int DEFAULT_SIZE = 10;

    CustomCirQueue(int size){
        this.data = new Integer[size];
        this.rear = -1;
        this.front = 0;
        this.size = 0;

    }
    CustomCirQueue(){
        this(DEFAULT_SIZE);
    }
    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue Overflow!!!");
            return;
        }
        this.rear = (this.rear + 1) % this.data.length;
        this.data[this.rear] = value;
        this.size++;
    }

    protected boolean isFull() {
        return this.size == this.data.length;
    }
    public Integer dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow!!!");
            return null;
        }
        int temp  = this.data[this.front];
        this.front = (this.front+1) % this.data.length;
        this.size--;
        return temp;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString(){
        StringBuilder str  = new StringBuilder("Queues : ");
        for (int i = 0; i < size ; i++) {
            str.append(this.data[(front + i)% data.length]).append(" ");
        }
        return str.toString();
    }
}
