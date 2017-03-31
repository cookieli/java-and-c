package com.lizheng.LinkedList;

import java.util.Iterator;

public class QueueTest4<T> implements Iterable<T>{
	  // private Node first;
	   private Node last;
	   private int N=0;
       private class Node{
    	 T item;
    	 Node next;
       }
       public boolean isEmpty(){
    	   return N == 0;
       }
       public int size(){
    	   return N;
       }
       public void enqueue(T item){
    	   Node node = new Node();
    	   node.item = item;
    	   if(isEmpty()){
    		 //  first = node;
    		   last = node;
    		   last.next = node;
    	   }
    	   else{
    		   Node first = last.next;
    		   last.next = node;
    		   last = node;
    		   last.next=first;
    	   }
    	   N++;
       }
       public T dequeue(){
    	   if(isEmpty()){
    		   return null;
    	   }
    	   Node first = last.next;
    	   T item = first.item;
    	   first = first.next;
    	   last.next = first;  
    	   N--;
    	   return item;
       }
       public Iterator<T> iterator(){
    	   return new ListIterator();
       }
       private class ListIterator implements Iterator<T>{
        private int i=0;
        private Node current=last.next;
		@Override
		public boolean hasNext() {
			return i<N;
		}
		@Override
		public T next() {
			T item = current.item;
			current =current.next;
			i++;
			return item;
		}
    	   
       }
       public static void main(String args[]){
    	   QueueTest4<String> q1= new QueueTest4<String>();
    	   
    	   q1.enqueue("a");
    	   q1.enqueue("b");
    	   Iterator<String> i =q1.iterator();
    	  while(i.hasNext()){
    		  System.out.println(i.next());
    	  }
    	   
       }
}
