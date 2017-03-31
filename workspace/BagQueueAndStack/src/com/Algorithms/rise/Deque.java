package com.Algorithms.rise;

import java.util.Iterator;

public class Deque <T> implements Iterable<T>{
	  private Node left;
	  private Node right;
	  private int N;
	  public boolean isEmpty(){
		  return N==0;
	  }
	  public int size(){
		  return N;
	  }
	  public void pushLeft(T item){
		  Node newNode = new Node();
		  newNode.item = item;
		  if(isEmpty()){
			  left = newNode;
			  right = newNode;
			}
		  else{
			  newNode.next = left;
			  left.pre = newNode;
			  left = newNode;
		  }
		  N++;
	  }
	  public void pushRight(T item){
		    Node newNode = new Node();
		    newNode.item = item;
		    if(isEmpty()){
		    	left = newNode;
		    	right = newNode;
		    }
		    else{
		    	newNode.pre = right;
		    	right.next = newNode;
		    	right = newNode;
		    }
		    N++;
	  }
	  public T popLeft(){
		    if(isEmpty()){
		    	return null;
		    }
		    else{
		    	T item = left.item;
		    	left = left.next;
		    	N--;
		    	return item;
		    }
	  }
	  public T popRight(){
		  if(isEmpty()){
			  return null;
		  }
		  else{
			  T item = right.item;
			  right = right.pre;
			  N--;
			  return item;
		  }
	  }
      private class Node{
    	  T item;
    	  Node pre;
    	  Node next;
      }
      public Iterator<T> iterator(){
    	  return new iter();
      }
      private class iter implements Iterator<T>{
             private Node current = left;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T item = current.item;
			current = current.next;
			return item;
		}
    	  
      }
      public static void main(String args[]){
    	  Deque<String> de = new Deque<String>();
    	  de.pushLeft("a");
    	  de.pushLeft("b");
    	  de.pushLeft("c");
    	  de.pushRight("d");
    	  de.pushRight("e");
    	  
//    	  System.out.println(de.size());
//    	  System.out.println(de.popRight());
//    	  System.out.println(de.popRight());
    	  
    	  Iterator<String> it = de.iterator();
    	  while(it.hasNext()){
    		  System.out.println(it.next());
    	  }
      }
}
