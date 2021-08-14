package com.company.lecture19;

import com.company.lecture20.CustomCirQueue;
import com.company.lecture20.CustomQueues;
import com.company.lecture20.DyanamicQueue;



public class Main {
    public static void main(String[] args) {
        System.out.println("Stack implementation checking");

        CustomStack stack = new CustomStack(5);
        stack.push(12);
        stack.push(23);
        stack.push(24);
        System.out.println(stack.pop());
        stack.push(56);
        stack.push(71);
        System.out.println(stack.pop());
        stack.push(80);
        stack.push(83);


        System.out.println(stack.peek());


        System.out.println(" Dynamic Stack Working");
        DynamicStack dStack = new DynamicStack();
        dStack.push(12);
        dStack.push(13);
        dStack.push(14);
        System.out.println("pop " +dStack.pop());
        dStack.push(15);
        dStack.push(16);
        System.out.println("pop " +dStack.pop());
        dStack.push(17);
        dStack.push(18);
        System.out.println("peek " +dStack.peek());
        dStack.push(19);
        System.out.println("peek " +dStack.peek());


    }
}
