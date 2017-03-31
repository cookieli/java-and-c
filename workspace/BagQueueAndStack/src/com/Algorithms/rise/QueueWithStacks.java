package com.Algorithms.rise;

import edu.princeton.cs.algs4.Stack;

public class QueueWithStacks<T> {
      private Stack<T> s1 ;//= new Stack<T>();
      private Stack<T> s2 ;
      public QueueWithStacks(){
    	  s1 = new Stack<T>();
    	  s2 = new Stack<T>();
      }
      public void enqueue(T item){
    	  s1.push(item);
      }
      public T dequeue(){
    	  if(s1.isEmpty()&&s2.isEmpty()){
    		  System.out.println("WRONG");
    		  return null;
    	  }
    	  else if(s2.isEmpty()){
    		  
    	     while(s1.size()!=1){
    		     s2.push(s1.pop());  
    	        }
    	     return s1.pop();
    	  }
    	  else {
    		 return s2.pop();
    	  }
      }
      public static void main(String args[]){
    	  QueueWithStacks<Integer> q1 = new QueueWithStacks<Integer>();
    	  q1.enqueue(1);
    	  q1.enqueue(2);
    	  q1.enqueue(3);
    	  System.out.println(q1.dequeue());
    	  System.out.println(q1.dequeue());
    	  
      }
}
