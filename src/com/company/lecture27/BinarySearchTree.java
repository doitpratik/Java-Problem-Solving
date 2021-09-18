package com.company.lecture27;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class BinarySearchTree<T extends Comparable<T>> {
    Node root;
    class Node {
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }
    }

    public void insert(T value){
        this.root = insert(root, value);
    }
    private Node insert(Node node, T value){
        if(node == null){
            node  = new Node(value);
            return  node;
        }
        if(node.value.compareTo(value) < 0){
            node.right = insert(node.right, value);
        }else if(node.value.compareTo(value) > 0){
            node.left = insert(node.left, value);
        }else if(node.value.compareTo(value) == 0){//if the values are equal this code will putt the values to left side/ Right side
            // but thats not case in BST it is not good practice to add duplicate values
            //node.left = insert(node.left, value);
            // node.right = insert(node.right, value);
        }
        return node;
    }

    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        display(node.right, indent+'\t');
        System.out.println(indent + node.value);
        display(node.left, indent+'\t');
    }

    public boolean find(T value){
        return find(root, value);
    }
    private boolean find(Node node, T value){
        if(node == null){
            return false;
        }
        if(node.value.equals(value)){
            return true;
        }
        return (node.value.compareTo(value) > 0 ? (find(node.left, value)) : (find(node.right, value)));
    }
    public T max(){
        return max(root);
    }
    private T max(Node node){
        if(node.right == null){
            return node.value;
        }

        return max(node.right);
    }
    public T min(){
        return min(root);
    }
    private T min(Node node){
        if(node.left == null){
            return node.value;
        }

        return min(node.left);
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }
    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void preorder(){
        preorder(root);
        System.out.println();
    }
    private void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }
    public void postorder(){
        postorder(root);
        System.out.println();
    }
    private void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public List<T> sortedList(){
        return makeSortedList(root, new ArrayList<>());
    }
    private List<T> makeSortedList(Node node, ArrayList<T> list){
        if(node == null){
            return list;
        }
        makeSortedList(node.left, list);
        list.add(node.value);
        makeSortedList(node.right, list);
        return list;
    }
    public void populateFromSortedArray(T[] sorted){
        this.root = makeTree(sorted, 0, sorted.length-1);
    }
    private Node makeTree(T[] arr,int index, int finalidx){
        if(index > finalidx){
            return null;
        }
        int mid = (index + finalidx)/2;
        Node node = new Node(arr[mid]);
        node.left = makeTree(arr, index, mid-1);
        node.right = makeTree(arr, mid+1, finalidx);
        return node;
    }

    public void range(T start, T end){
        range(start, end, this.root);
    }
    private void range(T start, T end, Node node){
        if(node == null){
            return ;
        }
        if(node.value.compareTo(start) > 0){
            range(start, end, node.left);
        }
        if(node.value.compareTo(start) >= 0 && node.value.compareTo(end) <=0){
            System.out.print(node.value+" ");
        }
        if(node.value.compareTo(end) < 0){
            range(start, end, node.right);
        }
    }


}

