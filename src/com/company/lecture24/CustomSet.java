package com.company.lecture24;

import java.time.LocalDate;
import java.util.*;

public class CustomSet<K>{
    ArrayList<LinkedList<K>> data;
    static final int DEFAULT_SIZE = 20;
    int size ;
    static final double LOAD_FACTOR = 0.75;
    CustomSet(){
        this.data = new ArrayList<>(DEFAULT_SIZE);
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            this.data.add(new LinkedList<>());
        }
        this.size = 0;
    }

    public void add(K value){
       int hash = value.hashCode();
       int index =Math.abs(hash % data.size());
       LinkedList<K> list = this.data.get(index);
       for(K key: list){
           if(key.equals(value)){
               return ;
           }
       }
       list.add(value);
       size++;
       if((double)size / data.size() > LOAD_FACTOR){
           rehash();
       }
    }

    private void rehash() {
        ArrayList<LinkedList<K>> old = this.data;
        this.data = new ArrayList<>();
        for (int i = 0; i < old.size()*2; i++) {
            this.data.add(new LinkedList<>());
        }
        this.size = 0;
        for (LinkedList<K> list : old) {
            for (K element: list){
                add(element);
            }
        }
        old = null;
    }

    public boolean contains(K value){
        int hash = value.hashCode();
        int index =Math.abs(hash % data.size());
        LinkedList<K> list = this.data.get(index);
        for(K key: list){
            if(key.equals(value)){
                return true;
            }
        }
        return false;
    }
    public boolean  remove(K value){
        int hash = value.hashCode();
        int index =Math.abs(hash % data.size());
        LinkedList<K> list = this.data.get(index);
        for(K key: list){
            if(key.equals(value)){
                list.remove(value);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("CustomSet:  ");
        for (LinkedList<K> list : this.data) {
            for (K key:list
                 ) {
                str.append(key).append(" ");
            }
        }
        return str.toString();
    }
}
