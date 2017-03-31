package com.lizhengxian.basic;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimForest {
      private boolean[] marked;
      private Queue<Edge> mst ;
      private MinPQ<Edge> pq ;
      public LazyPrimForest(EdgeWeightedGraph G){
    	  marked = new boolean[G.V()];
    	  mst = new Queue<Edge>();
    	  pq  = new MinPQ<Edge>();
    	 for(int i = 0 ; i <G.V() ; i++){
    		 if(!marked[i]) prim(G,i);
    	 }
      }
      public void prim(EdgeWeightedGraph G,int v){
    	 visit(G,v);
    	 while(!pq.isEmpty()){
    		 Edge t = pq.delMin();
    		 int u = t.either(); int w = t.other(v);
    		 if(marked[u]&&marked[w]) continue;
    		 mst.enqueue(t);
    		 if(!marked[u]) visit(G,u);
    		 if(!marked[w]) visit(G,w); 
    	 }
      }
      private void visit(EdgeWeightedGraph G,int v){
    	  marked[v] = true ; 
    	  for(Edge e:G.adj(v)){
    		  if(!marked[e.other(v)]) pq.insert(e);
    	  }
      }
      public static void main(String[] args){
    	  
      }
      
}
