package com.lizhengxian.graph;

import edu.princeton.cs.algs4.In;

public class DepthFirstSearch {
      private boolean[] marked;
      private int count;
      private int movablePoint ;
      public DepthFirstSearch(graph G,int n){
    	  marked = new boolean[G.V()];
    	  dfs(G,n);
      }
      private boolean marked(int v){
    	  return marked[v] == true;
      }
      private void dfs(graph G,int v){
    	  marked[v] = true ;
    	  count++;
    	  for(int w:G.adj(v)){
    		  if(!marked(w)) dfs(G,w);
    	  }
      }
      /**
     * @param args
     */
    public static void main(String[]args){
    	  In in = new In();
    	  graph G = new graph(in);
    	  DepthFirstSearch d = new DepthFirstSearch(G,0);
    	  for(int i = 0 ; i<G.V() ; i++){
    	   for(int w:G.adj(i)){
    		   System.out.print(w+",");
    	   }
    	   System.out.println();
    	  }
      }
}
