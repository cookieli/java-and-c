package com.lizhengxian.graph;

public class CC {
      private boolean[] marked;
      private int[] id;//id用来储连通标识符，其中索引代表顶点
      private int count;//连通标识符
      public CC(graph G){
    	  marked = new boolean[G.V()];
    	  id = new int[G.V()]; 
    	  for(int s = 0 ; s<G.V() ; s++){
    		  dfs(G,s);
    		  count++;
    	  }
      }
      private void dfs(graph G,int s){
    	  marked[s] = true;
    	  id[s] =count;
    	  for(int w:G.adj(s)){
    		  if(!marked[w]){
    			  dfs(G,w);
    		  }
    	  }
      }
      public int count(){
    	  return this.count;
      }
}
