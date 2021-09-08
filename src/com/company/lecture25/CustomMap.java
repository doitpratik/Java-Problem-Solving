package com.company.lecture25;

import javax.management.MBeanParameterInfo;
import java.lang.reflect.Array;
import java.util.*;

public class CustomMap<K,V> {
    class Pair {
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;

        }
    }
    ArrayList<LinkedList<Pair>> data;
    private static final int DEFAULT_SIZE = 20;
    int size;
    static final double LOAD_FACTOR = 0.75;

    CustomMap(){
        this.data = new ArrayList<>();
        for(int i = 0; i < DEFAULT_SIZE; i++){
            this.data.add(new LinkedList<>());
        }
        this.size = 0;

    }

    public void put(K key, V value){
        int hash = key.hashCode();
        int index = Math.abs(hash % this.data.size());
        LinkedList<Pair> list = this.data.get(index);
        for(Pair x : list){
            if(x.key.equals(key)){
                x.value = value;
                return ;
            }
        }
        list.add(new Pair(key, value));
        size++;
        if((double)size / data.size() > LOAD_FACTOR){
            rehash();
        }
    }

    private void rehash() {
        ArrayList<LinkedList<Pair>> old = this.data;
        this.data = new ArrayList<>();
        for (int i = 0; i < old.size()*2; i++) {
            this.data.add(new LinkedList<>());
        }
        this.size = 0;
        for(LinkedList<Pair> list : old){
            for(Pair x : list){
                put(x.key, x.value);
            }
        }
        old = null;
    }

    public V get(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % data.size());
        LinkedList<Pair> list = this.data.get(index);
        for(Pair x : list){
            if(x.key.equals(key)){
                return x.value;
            }
        }
        return null;
    }

    public boolean containKey(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % data.size());
        LinkedList<Pair> list = this.data.get(index);
        for(Pair x : list){
            if(x.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean remove(K key, V value){
        int hash = key.hashCode();
        int index = Math.abs(hash % data.size());
        LinkedList<Pair> list = this.data.get(index);
        for(Pair x : list){
            if(x.key.equals(key) && x.value.equals(value)){
                list.remove(x);
                this.size--;
                return true;
            }
        }
        return false;
    }

    public V remove(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % data.size());
        LinkedList<Pair> list = this.data.get(index);
        for(Pair x : list){
            if(x.key.equals(key)){
                list.remove(x);
                this.size--;
                return x.value;
            }
        }
        return null;
    }
    public Set<K> keySet(){
        Set<K> keys = new HashSet<>();
        for(LinkedList<Pair> list : this.data){
            for(Pair x: list){
                keys.add(x.key);
            }
        }
        return keys;
    }
    public Collection<V> values(){
        Collection<V> value = new HashSet<>();
        for(LinkedList<Pair> list : this.data){
            for(Pair x: list){
                value.add(x.value);
            }
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("CustomSet: ");
        for (LinkedList<Pair> list : this.data) {
            for (Pair pair:list) {
                str.append("[" + pair.key + ":" + pair.value + "]" + " ");
            }
        }

        return str.toString();
    }
}
