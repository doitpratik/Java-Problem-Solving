package com.company.lecture19;

public class StackImplemtentation {
    protected Integer[] data;
    protected int top;
    private static final int DEFAULT_SIZE=10;

    StackImplemtentation() {
        this.data = new Integer[DEFAULT_SIZE];
        this.top = -1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        this.data[++top] = value;
    }

    protected boolean isFull() {
        return this.top == data.length-1 ;
    }
    public Integer pop(){
        if(isEmpty()){
            System.out.println("Stsack Underflow");
            return null;
        }
        int temp = this.data[top--];
        return temp;
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
