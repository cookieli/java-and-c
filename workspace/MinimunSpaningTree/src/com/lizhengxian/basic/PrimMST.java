package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
      private Edge[] edgeTo;
      private double[] disTo;
      private boolean[] marked;
      private IndexMinPQ<Double> pq;
      public PrimMST(EdgeWeightedGraph G){
    	  edgeTo = new Edge[G.V()];
    	  disTo  = new double[G.V()];
    	  marked = new boolean[G.V()];
    	  pq = new IndexMinPQ<Double>(G.V());
    	  for(int i = 0 ;i <G.V();i++){
    		  disTo[i] = Double.POSITIVE_INFINITY;
    	  }
    	  disTo[0] = 0.0;
    	  pq.insert(0, 0.0);
    	  while(!pq.isEmpty()){
    		  visit(G,pq.delMin());
    	  }
      }
      public void visit(EdgeWeightedGraph G,int v){
    	  marked[v] = true ;
    	  for(Edge w: G.adj(v)){
    		  int u = w.other(v);
    		  if(marked[u]) continue;
    		  if(w.weight()<disTo[u]){
    			  edgeTo[u] = w;
    			  disTo[u] = edgeTo[u].weight();
    			 if(pq.contains(u)) pq.changeKey(u, disTo[u]);
    			 else               pq.insert(u, disTo[u]);
    		  }
    	  }
      }
      public Iterable<Edge> edges(){
      	   Bag<Edge> mst = new Bag<Edge>();
      	   for(int i = 1 ; i <edgeTo.length ; i++ ){
      		   mst.add(edgeTo[i]);
      	   }
      	   return mst;
         }
      public String toString(){
    	  String s = "";
    	  for(Edge e:edges()){
    		  s+=e.toString()+ "\n";
    	  }
    	  return s;
      }
      public static void main(String[] args){
    	  In in = new In();
    	  EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    	  PrimMST p = new PrimMST(G);
    	  System.out.println(p.toString());
      }
}
