package com.Algorithms.rise;

public class MoveToFront<T> {
	  public Node first;
	  
      private class Node{
    	  T item;
    	  Node next;
    	  public Node(T item,Node next){
    		  this.item = item;
    		  this.next = next;
    	  }
      }
      public Node delete(Node x,T item){
    	  if(x==null) return null;
    	  if(x.item == item)return x.next;
    	  x.next = delete(x.next,item);
    	  return x;
      }
      public int find(T item){
    	  int i =0;
    	  for(Node x= first;x!=null;x=x.next){
    		  i++;
    		  if(x.item == item){
    			  return i;
    		  }	 
    	  }
    	  return 0;
      }
      public int add(T item){
    	  int location =find(item);
    	  first = delete(first,item);
    	  first = new Node(item,first);
    	  return location;
      }
      public static void main(String args[]){
    	      MoveToFront<Character> mtf = new MoveToFront<Character>();
    	      String s ="abcdaaa";
    	      for(int i=0;i<s.length();i++){
    	    	  char c =s.charAt(i);
    	    	  System.out.print(mtf.add(c)+",");
    	      }
    	      System.out.println();
    	      
    	  }
      }
