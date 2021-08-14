package com.company.lecture20;

public class RunQueue {
    public static void main(String[] args) {
        CustomQueues queue = new CustomQueues(5);
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        System.out.println("Dequeue "+queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(0);
        System.out.println(queue);


        CustomCirQueue cqueue = new CustomCirQueue(5);
        cqueue.enqueue(5);
        cqueue.enqueue(4);
        System.out.println("Dequeue "+ cqueue.dequeue());
        cqueue.enqueue(3);
        cqueue.enqueue(2);
        cqueue.enqueue(1);
        cqueue.enqueue(0);
        System.out.println(cqueue);


        System.out.println("Dynamic circular queue");
        DyanamicQueue dqueue = new DyanamicQueue();
        dqueue.enqueue(5);
        dqueue.enqueue(3);
        dqueue.enqueue(2);
        dqueue.enqueue(1);
        dqueue.enqueue(4);
        dqueue.enqueue(7);
        System.out.println(dqueue);






    }
}
