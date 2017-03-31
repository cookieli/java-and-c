package com.lizhengxian.riseproblem;

import edu.princeton.cs.algs4.MaxPQ;

public class ElementaryQueue<Key> {
      private MaxPQ<element> q;
      private Integer Toppriority =0;
      public ElementaryQueue(){
    	  this.q = new MaxPQ<element>();
      }
      private class element implements Comparable<element>{
    	  Key data;
    	  Integer priority;
    	  private element(){}
    	  private element(Key data,Integer priority){
    		  this.data = data;
    		  this.priority = priority;
    	  }
		@Override
		public int compareTo(ElementaryQueue<Key>.element o) {
			// TODO Auto-generated method stub
			return this.priority.compareTo(o.priority);
		}
      }
        public void enqueue(Key item){
        	q.insert(new element(item,Toppriority--));
        }
        public Key dequeue(){
        	Toppriority++;
        	return q.delMax().data;
        }
        public static void main(String[] args){
        	ElementaryQueue<Integer> s = new ElementaryQueue<Integer>();
        	s.enqueue(0);
        	s.enqueue(2);
        	s.enqueue(3);
        	System.out.println(s.dequeue());
        	System.out.println(s.dequeue());
        	System.out.println(s.dequeue());
        }
}
