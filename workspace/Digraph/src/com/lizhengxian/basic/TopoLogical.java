package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;

public class TopoLogical {
      private Iterable<Integer> order;
      public TopoLogical(Digraph G){
    	  DirectedCycle cyclefinder = new DirectedCycle(G);
    	  if(!cyclefinder.hasCycle()){
    		  DepthFirstOrder dfo = new DepthFirstOrder(G);
    		  order = dfo.reversepast();
    	  }
      }
      public boolean hasOrder(){
    	  return order!=null;
      }
      public Iterable<Integer> order(){
    	  return order;
      }
      public static void main(String[]args){
    	  In in = new In();
    	  Digraph D = new Digraph(in);
    	  TopoLogical T = new TopoLogical(D);
    	  System.out.println(T.order);
      }
}
