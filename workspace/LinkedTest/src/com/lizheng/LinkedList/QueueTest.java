package com.lizheng.LinkedList;

public class QueueTest<T> {
      private Node first;
      private Node last;
      private int N;
      public QueueTest(){}
      public QueueTest(QueueTest<T> q){
    	  this.first = deepcopy(q.first);
      }
      public Node deepcopy(Node first){
    	  Node x =null;
    	  if(first==null) x= null;
    	  else  if(first.next ==null) {
    		  x.item= first.item;
    		  x.next = null;
    	  }
    	  else{
    		  x.item = first.item;
    		  x.next = deepcopy(first.next);
    	  }
    	  return x;
      }
      private class Node{
    	  T item;
    	  Node next;
      }
      public boolean isEmpty(){
    	  return first==null;
      }
      public int size(){
    	  return N;
      }
      public void enqueue(T item){
    	    Node oldLast = last;
    	    last = new Node();
    	    last.item = item;
    	    last.next = null;
    	    if(isEmpty()) first = last;
    	    else oldLast.next = last; 	  
    	    N++;
      }
      public T dequeue(){
    	  T item = first.item;
    	  first = first.next;
    	  if(isEmpty()) last = null;
    	  N--;
    	  return item;
      }
      public static void main(String args[]){
    	  QueueTest<String> = new QueueTest<String>();
      }
    	  
    	    
}
