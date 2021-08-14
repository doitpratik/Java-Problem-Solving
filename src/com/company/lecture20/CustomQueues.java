package com.company.lecture20;

import java.util.Arrays;

public class CustomQueues {
      private Integer[] data;
      private int front;
      private int rear;
      private final static int DEFAULT_SIZE = 10;

      CustomQueues(int size){
          this.data = new Integer[size] ;
          this.front = -1;
          this.rear = -1;
      }
      CustomQueues(){
          this(DEFAULT_SIZE);
      }
      public void enqueue(int value){
          if(isFull()){
              System.out.println("Queue is Full");
              return ;
          }
          this.data[++rear] = value;

      }

      private boolean isFull() {
        return (this.rear == data.length-1);
      }
      public Integer dequeue(){
          if(isEmpty()){
              System.out.println("Queue is Empty");
              return null;
          }
          int temp = this.data[0];
          for (int i = 0; i < rear; i++) {
              this.data[i] = this.data[i+1];
          }
          this.rear--;
          return temp;
      }

      private boolean isEmpty() {
        return (this.rear == -1);
      }

     @Override
     public String toString() {
        /* return "CustomQueues{" +
                 "data=" + Arrays.toString(data) +
                 '}';*/
        StringBuilder str =new StringBuilder( "Queue: ");

         for (int i = 0; i <=  rear; i++) {
             str.append(this.data[i]).append(" ");
         }
         return str.toString();
     }
}
