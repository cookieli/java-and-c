package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
      private boolean[] marked;
      private boolean[] onStack;
      private int[] edgeTo;
      private Stack<Integer> cycle;
      public DirectedCycle(Digraph G){
    	  marked  = new boolean[G.V()];
    	  edgeTo  = new int[G.V()];
    	  onStack = new boolean[G.V()];
    	
    	  for(int i = 0 ; i < G.V() ; i ++){
    		  if(!marked[i]) dfs(G,i);
    	  }
      }
      private void dfs(Digraph G,int v){
    	  marked[v] = true ;
    	  onStack[v] = true;
    	  for(int w:G.adj(v)){
    		  if(!marked[w]) {
    			  edgeTo[w] = v;
    			  dfs(G,w);
    		 }
    		  else if(onStack[w] == true){
    			  cycle = new Stack<Integer>();
    			  for(int i = v ;i !=w ;i =edgeTo[i])
    				  cycle.push(i);
    			      cycle.push(w);
    			      cycle.push(v);
    		  }
    	  }
    	  onStack[v] = false;
      }
      public boolean hasCycle(){
    	  return cycle !=null;
      }
      public Iterable<Integer> cycle(){
    	  return cycle;
      }
      public static void main(String[] args){
    	  In in = new In();
    	  Digraph G = new Digraph(in);
    	  DirectedCycle ds = new DirectedCycle(G);
    	  System.out.println(ds.hasCycle());
//    	  for(int w:ds.cycle()){
//    		  System.out.print(w +" ");
//    	  }
      }
}
