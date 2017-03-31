package com.lizhengxian.collection;

public class StackList<T> {
      private Node first;
      private int N;
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
      public void push(T item){
    	  Node oldFirst =first;
    	  first=new Node();
    	  first.item=item;
    	  first.next=oldFirst;  
    	  N++;
      }
      public T pop(){
    	     T item =first.item;
    	     first=first.next;
    	     N--;
    	     return item;
      }
      public T peek(){
    	     T item = first.item;
    	     return item;
      }
}
