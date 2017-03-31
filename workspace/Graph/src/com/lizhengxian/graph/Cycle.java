package com.lizhengxian.graph;

public class Cycle {
      private boolean[] marked;
      private boolean hasCycle;
      public Cycle(graph G){
    	  marked = new boolean[G.V()];
    	  for(int s = 0 ;s <G.V();s++){
    		  dfs(G,s,s);
    	  }
      }
      public void dfs(graph G,int u,int v){
    	  marked[u] = true;
    	  for(int w:G.adj(u)){
    		  if(!marked[w])   dfs(G,w,u);
    		  else  if(w!=v) hasCycle = true;
    	  }
      }
      public boolean hasCycle(){
    	  return hasCycle;
      }
}
