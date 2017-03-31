package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
     private Queue<Edge> mst;
     public KruskalMST(EdgeWeightedGraph G){
    	 mst = new Queue<Edge>();
    	 MinPQ<Edge> pq = new MinPQ<Edge>();
   	 for(Edge e:G.edges()){
   		 pq.insert(e);
   	    }
    	 UF uf = new UF(G.V());
   	 while(!pq.isEmpty()&&mst.size()<G.V()-1){
   		   Edge e = pq.delMin();
   		   int u = e.either();
   		   int w = e.other(u);
   		   if(uf.connected(u, w)) continue;
   		   uf.union(u, w);
   		   mst.enqueue(e);
   		}
     }
     public Iterable<Edge> edges(){
    	 return mst;
     }
     public static void main(String[] args){
    	 In in = new In();
    	 EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    	 KruskalMST  k = new KruskalMST(G);
    	 for(Edge e:k.edges()){
    		 System.out.println(e.toString());
    	 }
     }
}
