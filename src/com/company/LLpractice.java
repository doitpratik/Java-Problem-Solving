package com.company;

public class LLpractice {
    Node head;
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }
    public void insertLast(int value){
        if(this.head == null){
            insertFirst(value);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(value);
        temp.next = newNode;
    }
    public void insertFirst(int value){
        Node newNode = new Node(value, head);
        this.head = newNode;
    }
    public void insertSpecific(int value, int index){
        if(index == 1){
           insertFirst(value);
           return;
        } else if(index <= 0){
            System.out.println("Enter the valid index");
            return;
        }
        int count = 1;
        Node temp  = this.head;
        while(count < index-1 && temp.next != null){
            temp = temp.next;
            count++;
        }
        Node newNode = new Node(value, temp.next);
        temp.next = newNode;

    }

    @Override
    public String toString() {
        StringBuilder finalstr = new StringBuilder("List: ");
        Node temp = this.head;
        while(temp.next != null){
            finalstr.append(temp.value).append("->");
            temp = temp.next;
        }
        finalstr.append(temp.value);
        return finalstr.toString();
    }
}
