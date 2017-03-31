package com.lizhengxian.basic;

import java.util.Iterator;

public class LinkListPQ<Key extends Comparable<Key>>implements Iterable<Key> {
	private Node first = null;
    private int N = 0;
    public boolean isEmpty(){
    	return N==0;
    }
    
    public int size(){
    	return N;
    }
    public void insert(Key element){
    	if(first == null){
    		Node newNode = new Node(element);
    		first = newNode;
    		first.next = null;
    	}
    	else{
    		Node newNode = new Node(element);
    		newNode.next = first;
    		first = newNode;
    	}
    	N++;
    }
    public Key delMax(){
    	Node newNode = findMax();
    	Key max = newNode.item;
    	if(newNode.next ==null){
    		newNode = null;
    	}
    	else{
    		Node p = newNode.next;
    		newNode.item = p.item;
    		newNode.next = p.next;
    		p =null;
    	}
    	N--;
    	return max;
    }
    public Node findMax(){
    	Node cursor = this.first;
    	Node bigger = this.first;
   
    	while(cursor.next!=null){
    		
    		cursor = cursor.next;
    		if(less(bigger.item,cursor.item))  bigger = cursor;
    		
    	}
    	return bigger;
    }
    private boolean  less(Key a,Key b){
    	return a.compareTo(b)<0;
    }
	class Node{
		Key item;
		Node next;
		private Node(){}
		private Node(Key item){
			this.item = item;
			this.next = null;
		}
	}

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return  new PQiterator();
	}
	private class PQiterator implements Iterator<Key> {
        private Node newNode = first;
       
		@Override 
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return newNode!=null;
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			Key temp = newNode.item;
			newNode = newNode.next;
			return temp;
		}
		
	}
	public static void main(String args[]){
		LinkListPQ<Integer> ldPQ = new LinkListPQ<Integer>();
		ldPQ.insert(2);
		ldPQ.insert(9);
		ldPQ.insert(5);
		ldPQ.insert(4);
	    Iterator<Integer> it = ldPQ.iterator();
	    System.out.println(ldPQ.delMax());
	    System.out.println(ldPQ.delMax());
	    System.out.println("..............");
        while(it.hasNext()){
		  System.out.print(it.next()+",");
	  } 

	}
}
