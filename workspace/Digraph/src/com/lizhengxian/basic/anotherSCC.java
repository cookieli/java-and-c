package com.lizhengxian.basic;

public class anotherSCC {
      private boolean[] onStack;
      private boolean[] marked;
      private int[] id ;
      private int count ;
      public anotherSCC(Digraph D){
    	  onStack = new boolean[D.V()];
    	  marked  = new boolean[D.V()];
    	  id = new int[D.V()];
    	  for(int i = 0 ; i < D.V() ; i++){
    		  dfs(D,i); count++;
    	  }
      }
      public void dfs(Digraph D,int v){
    	  marked[v] = true ;
    	  onStack[v] = true ;
    	  for(int w:D.adj(v)){
    		  if(!marked[w]){
    			  dfs(D,w);
    		  }
    		  else if(onStack[w]){
    			  id[w] = count ;
    		  }
    	  }
    	  onStack[v] = false;
      }
}
