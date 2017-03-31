package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Queue;

public class BellmanFordSP {
      private double[] disTo;
      private DirectedEdge[] edgeTo;
      private boolean[] onQ;
      private Queue<Integer> queue;
      private int cost;
      private Iterable<DirectedEdge> cycle;
      public BellmanFordSP(DirectedEdgeWeightedGraph G,int s){
    	  disTo = new double[G.V()];
    	  edgeTo = new DirectedEdge[G.V()];
    	  onQ  = new boolean[G.V()];
    	  queue = new Queue<Integer>();
    	  for(int i = 0 ; i <G.V() ; i++){
    		  disTo[i] = Double.POSITIVE_INFINITY;
    	  }
    	  disTo[s] = 0 ;
    	  
      }
      private void relax(DirectedEdgeWeightedGraph G,int s){
    	  for(DirectedEdge e:G.adj(s)){
    		  int w = e.to();
    		  
    	  }
      }
}
