package com.lizhengxian.basic;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class Vyssotsky {
	private MaxPQ<Edge> mst;
    public Vyssotsky(EdgeWeightedGraph G){
         mst = new MaxPQ<Edge>();
         UF uf = new UF(G.V());
         for(Edge e : G.edges()){
        	 int v = e.either();
        	 int w = e.other(v);
        	 mst.insert(e);
        	 if(uf.connected(v,w)){
        		 mst.delMax();
        	 }
        	 else uf.union(v, w);
         }
    }
    
    public static void main(String[]args){
    	
    }
	

}
