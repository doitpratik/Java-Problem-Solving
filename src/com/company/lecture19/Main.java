package com.company.lecture19;

import com.company.lecture20.CustomCirQueue;
import com.company.lecture20.CustomQueues;
import com.company.lecture20.DyanamicQueue;

import javax.crypto.CipherInputStream;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
/*        StackImplemtentation stack = new StackImplemtentation();
        stack.push(12);
        stack.push(13);
        stack.push(23);
        stack.push(17);
        System.out.println(stack.pop());
        stack.push(25);
        System.out.println(stack.pop());
        stack.push(1000);
        System.out.println(stack.peek());*/
        DynamicStack stack = new DynamicStack();
        for (int i = 0; i < 101; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println();

        CustomQueues queue = new CustomQueues();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i+1);
        }
        queue.dequeue();
        queue.enqueue(12);
        System.out.println(queue.dequeue());
        queue.enqueue(15);

        System.out.println(queue);


        DyanamicQueue sirque = new DyanamicQueue();
        for (int i = 0; i < 5; i++) {
            sirque.enqueue(i);
          }
        sirque.dequeue();
        sirque.enqueue(13);
        sirque.enqueue(23);
        sirque.enqueue(23);
        sirque.enqueue(23);
        sirque.enqueue(23);
        sirque.enqueue(24);
        sirque.enqueue(25);

        System.out.println(sirque);
    }
}
