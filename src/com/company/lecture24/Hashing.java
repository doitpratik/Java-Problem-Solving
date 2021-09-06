package com.company.lecture24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Hashing<K> {
    ArrayList<K> data ;
    int size = 20;

    //Constructor
    public Hashing(){
        this.data = new ArrayList<K>(size);
    }

    // Methods
    public void add(K value){
        int hash = value.hashCode();
        int index = hash % size;
        if(data.get(index) == null){
            data.add(index, value);
        }
    }
}
