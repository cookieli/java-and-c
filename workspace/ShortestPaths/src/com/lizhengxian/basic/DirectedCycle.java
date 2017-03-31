package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
      private boolean[] marked;
      private int[] edgeTo;
      private Stack<Integer> cycle;
      private boolean[] onStack;
      public DirectedCycle(DirectedEdgeWeightedGraph G){
    	  marked = new boolean[G.V()];
    	  edgeTo = new int[G.V()];
    	  onStack = new boolean[G.V()];
    	  for(int i = 0 ; i<G.V() ; i++){
    		  dfs(G,i);
    	  }
      }
      private void dfs(DirectedEdgeWeightedGraph G,int w){
    	  marked[w]  = true ;
    	  onStack[w] = true ;
    	  for(DirectedEdge e: G.adj(w)){
    		  int v= e.to();
    		  if(!marked[v]){edgeTo[v] = w; dfs(G,v);}
    		  else if(onStack[v]){
    			  cycle = new Stack<Integer>();
    			  for(int x = w ; x!=v ;x = edgeTo[x]){
    				  cycle.push(x);
    			  }
    			  cycle.push(v);
    			  cycle.push(w);
    		  }
    	  }
    	  onStack[w] = false ;
      }
      public boolean hasCycle(){
    	  return cycle!=null;
      }
      public Iterable<Integer> cycle(){
    	  return cycle;
      }
      public static void main(String[]args){
    	  In in = new In();
    	  DirectedEdgeWeightedGraph G = new DirectedEdgeWeightedGraph(in);
    	  DirectedCycle D = new DirectedCycle(G);
    	  System.out.println(D.hasCycle());
    	  System.out.println(D.cycle());
      }
}
