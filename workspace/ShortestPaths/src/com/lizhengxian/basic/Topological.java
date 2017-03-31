package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;

public class Topological {
      private Iterable<Integer> order;
      public Topological(DirectedEdgeWeightedGraph G){
    	   DirectedCycle cyclefinder = new DirectedCycle(G);
    	   if(!cyclefinder.hasCycle()){
    		   DepthFirstOrder dfo = new DepthFirstOrder(G);
    		   order = dfo.reversepost();
    	   }
      }
      public Iterable<Integer> order(){
    	  return this.order;
      }
      public static void main(String[]args){
    	  In in = new In();
    	  DirectedEdgeWeightedGraph G = new DirectedEdgeWeightedGraph(in);
    	  Topological T = new Topological(G);
    	  System.out.println(T.order());
      }
}
