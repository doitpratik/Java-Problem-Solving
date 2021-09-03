package com.company.lecture23;

import com.company.lecture22.CustomLinkedList;
// you have to write doubly LL coe and Circular LL too;
public class CustomDoublyLinkedList {
   Node Head;

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            //It is not necessary to declare next to null by default it is Null
            //this.next = null;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }

    public void insertFirst(int value){
        Node node = new Node(value, Head);
        //node.next = Head;
        this.Head = node;
    }
    public void insertLast(int value){
        if(this.Head == null){
               /* Node node = new Node(value);
                this.Head = node;*/
            insertFirst(value);
            return ;
        }
        Node node = new Node(value);
        Node temp = this.Head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;

    }
    public void insertSpecific(int value, int index){
        if(index == 0){
            insertFirst(value);
            return ;
        }
        int count = 1;

        Node temp = this.Head;
        while(count < index && temp.next != null){ // in this case we can write temp.next as temp
            temp = temp.next;
            count++;
        }
        Node node = new Node(value, temp.next);
        //node.next = temp.next; // this is because we have updated thw next in the above line
        temp.next = node;
    }

    public Integer deletion(){
        int num = this.Head.value;
        this.Head = this.Head.next;
        return num;
    }
    public Integer deleteLast(){
        if(this.Head == null || this.Head.next == null){
            return deletion();
        }
        Node temp = this.Head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        int delnum = temp.next.value;
        temp.next = null;
        return delnum;
    }
    public Integer deletespecific(int index){
        if(index == 0){
            return deletion();
        }
        int count = 1;
      Node temp = this.Head;
        while(count < index && temp.next != null ){
            temp = temp.next;
            count++;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        return val;

    }

    public int size(){
        return -1;
    }
    public void reverse(){

        Node current = this.Head;
        Node prev = null;
        Node ahead ;
        while(current != null){
            ahead = current.next;
            current.next = prev;
            prev = current;
            current = ahead;
        }
        this.Head = prev;
    }
    public Integer midEle(){
        if(this.Head ==null){
            return null;
        }
        Node fastPoint = this.Head;
        Node slowPoint = this.Head;
        while(fastPoint.next != null && fastPoint.next.next != null){
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
        }
        int num = slowPoint.value;
        return num;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("List: ");
        Node temp = this.Head;
        while (temp.next != null) { // In case of temp we can write temp.next != null it works same
            res.append(temp.value).append(" -> ");
            temp = temp.next;
        }
        res.append(temp.value);
        return res.toString();
    }
}
