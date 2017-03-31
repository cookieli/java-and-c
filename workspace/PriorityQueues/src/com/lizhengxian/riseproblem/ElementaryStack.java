package com.lizhengxian.riseproblem;

import java.util.Comparator;

import edu.princeton.cs.algs4.MaxPQ;

public class ElementaryStack<Key>  {
	  private MaxPQ<element> p;
	  public Integer Toppriority=0;
	  public ElementaryStack(){
		  p = new MaxPQ<element>();
	  }
	 
	  private  class element implements Comparable<element> {
		  Key data;
		  Integer priority = 0;
		  private element(){}
		  private element(Key data){
			  this.data = data;
			  // this.priority++;
		  }
		  private element(Key data,Integer Toppriority){
			  this.data = data;
			  this.priority = Toppriority;
		  }
		@Override
		public int compareTo(ElementaryStack<Key>.element o) {
			// TODO Auto-generated method stub
			return this.priority.compareTo(o.priority);
		}
	  }
	  public void push(Key item){
		 p.insert(new element(item,Toppriority++));
	  }
	  public Key pop(){
		  Toppriority--;
		  return  p.delMax().data;
	  }
	  
      public static void main(String args[]){
    	  ElementaryStack<Integer> s = new ElementaryStack<Integer>();
    	  s.push(2);
    	  s.push(3);
    	  s.push(5);
    	  s.push(1);
    	  System.out.print(s.pop());
    	  System.out.print(s.pop());
      }
	
}
