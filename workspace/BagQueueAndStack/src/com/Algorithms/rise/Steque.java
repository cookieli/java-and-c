package com.Algorithms.rise;

import java.util.Iterator;

public class Steque<T> implements Iterable<T> {
      private Node first;
      private Node last;
      private int N;
      public boolean isEmpty(){
    	  return N==0;
      }
      public int size(){
    	  return N;
      }
      public void enqueue(T item){//实现从尾端添加元素
    	  Node newNode = new Node();
    	  newNode.item = item;
    	  if(isEmpty()){
    		  first = newNode;
    		  last = newNode;  
    	  }
    	  else{
    		  last.next = newNode;
    		  last = newNode;
    	  }
    	  N++;
      }
      public void push(T item){
    	  Node newNode = new Node();
    	  newNode.item = item;
    	  if(isEmpty()){
    		  first = newNode;
    		  last = newNode;
    	  }
    	  else{
    		  newNode.next = first;
    		  first = newNode;
    	  }
    	  N++;
      }
      
      public T pop(){
    	  if(isEmpty()){
    		  return null;
    	  }
    	  else{
    		  T item = first.item;
    		  first = first.next;  
    		  N--;
    		  return item;
    	  }
      }
       
      private class Node{
    	  T item;
    	  Node next;
      }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new iter();
	}
	public class iter implements Iterator<T>{
        private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}
		@Override
		public T next() {
			// TODO Auto-generated method stub
			T  item = current.item;
			current = current.next;
			return item;
		}
		
	}
	public static void main(String args[]){
		Steque<String> e = new Steque<String>();
		e.enqueue("d");
		e.push("b");
		e.push("c");
		e.enqueue("a");
		Iterator<String> it = e.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
//		System.out.println(e.pop());
//		System.out.println(e.pop());
//		System.out.println(e.pop());
//		System.out.println(e.pop());
	}
      
}
