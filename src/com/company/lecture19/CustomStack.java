package com.company.lecture19;
// Stack can be Implemented using arrays, arraylist, linkedlist;

public class CustomStack {
    protected Integer[] data;
    protected int top;
    public static final int DEFAULT_SIZE = 5;

    CustomStack(){
        this.data = new Integer[DEFAULT_SIZE];
        this.top = -1;
    }
    CustomStack(int size){
        this.data = new Integer[size];
        this.top = -1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("Stack is full");
            return ;
        }
        this.data[++top] = value;
    }

    protected boolean isFull() {
        return this.top == data.length-1;
    }

    public Integer pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }

        return this.data[top--];
    }

    protected boolean isEmpty() {
        return this.top == -1;
    }

    public Integer peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        return this.data[top];

    }

}
