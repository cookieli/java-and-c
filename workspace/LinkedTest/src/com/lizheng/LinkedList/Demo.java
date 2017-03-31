package com.lizheng.LinkedList;

import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;

public class Demo {
      public static void main(String args[]){
    	Stack<String> s = new Stack<String>();
    	s.push("a");
    	s.push("b");
    	s.push("c");
    	Stack<String> s1 =copy(s);
    	System.out.println(s1.pop());
    	System.out.println(s1.pop());
    	System.out.println(s1.pop());
    	}
      public static <T> Stack <T> copy(Stack<T> s){
    	  Iterator<T> it = s.iterator();
    	  Stack<T> s1= new Stack<T>();
    	  while(it.hasNext()){
    		  s1.push(it.next());
    	  }
    	  return s1;
      }
}
