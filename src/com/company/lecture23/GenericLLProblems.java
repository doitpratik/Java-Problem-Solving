package com.company.lecture23;

import java.util.* ;

public class GenericLLProblems<T extends Comparable<T>>{
    Node Head;

    class Node{
        T value;
        Node next;
        Node(T value){
            this.value = value;
            //It is not necessary to declare next to null by default it is Null
            //this.next = null;
        }

        Node(T value, Node next){
            this.value = value;
            this.next = next;
        }

    }

    public void insertFirst(T value){
        Node node = new Node(value, Head);
        //node.next = Head;
        this.Head = node;
    }
    public void insertLast(T value){
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
    public void insertSpecific(T value, int index){
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

    public T deletion(){
        T num = this.Head.value;
        this.Head = this.Head.next;
        return num;
    }
    public T deleteLast(){
        if(this.Head == null || this.Head.next == null){
            return deletion();
        }
        Node temp = this.Head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        T delnum = temp.next.value;
        temp.next = null;
        return delnum;
    }
    public T deletespecific(int index){
        if(index == 0){
            return deletion();
        }
        int count = 1;
        Node temp = this.Head;
        while(count < index && temp.next != null ){
            temp = temp.next;
            count++;
        }
        T val = temp.next.value;
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
    public T midEle(){
        if(this.Head ==null){
            return null;
        }
        Node fastPoint = this.Head;
        Node slowPoint = this.Head;
        while(fastPoint.next != null && fastPoint.next.next != null){
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
        }
        T num = slowPoint.value;
        return num;
    }
    public GenericLLProblems<T> merge(GenericLLProblems<T> list){
        Node h1 = this.Head;
        Node h2 = list.Head;
        GenericLLProblems<T> result = new GenericLLProblems<>();
        while(h1 != null && h2 != null){
            if(h1.value.compareTo(h2.value) < 0){
                result.insertLast(h1.value);
                h1 = h1.next;
            }else{
                result.insertLast(h2.value);
                h2 = h2.next;
            }
        }
        while(h1 != null){
            result.insertLast(h1.value);
            h1 = h1.next;
        }
        while(h2 != null){
            result.insertLast(h2.value);
            h2 = h2.next;
        }
        return result;
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
