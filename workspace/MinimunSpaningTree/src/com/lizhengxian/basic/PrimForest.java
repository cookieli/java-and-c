package com.lizhengxian.basic;

import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimForest {
     private Edge[] edgeTo;
     private double[] disTo;
     private boolean[] marked;
     private IndexMinPQ<Double> pq;
     public PrimForest(EdgeWeightedGraph G){
    	 edgeTo = new Edge[G.V()];
    	 disTo = new double[G.V()];
    	 marked = new boolean[G.V()];
    	 pq =new IndexMinPQ<Double>(G.V());
    	 for(int i = 0 ; i < G.V() ;i++){
    		 prim(G,i);
    	 }
     }
     public void prim(EdgeWeightedGraph G, int v){
    	 disTo[v] = 0.0;
    	 pq.insert(v, disTo[v]);
    	 while(!pq.isEmpty()){
    		 scan(G,v);
    	 }
     }
     private void scan(EdgeWeightedGraph G ,int v){
    	marked[v] = true;
    	for(Edge e: G.adj(v)){
    		int w = e.other(v);
    	    if(marked[w]) continue;
    	    if(e.weight()<disTo[w]) {
    	    	edgeTo[w] = e;
    	    	disTo[w] = e.weight();
    	    	if(pq.contains(w)) pq.changeKey(w, disTo[w]);
    	    	else               pq.insert(w, disTo[w]);
    	    	
    	   }
    	}
     }
}
