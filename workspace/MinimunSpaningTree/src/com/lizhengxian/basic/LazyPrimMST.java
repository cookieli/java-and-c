package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
       private boolean marked[];
       private Queue<Edge> mst;
       private MinPQ<Edge> pq ;
       public LazyPrimMST(EdgeWeightedGraph E){
    	   marked = new boolean[E.V()];
    	   mst = new Queue<Edge>();
    	   pq = new MinPQ<Edge>();
    	   visit(E,0);
    	   while(!pq.isEmpty()){
    		   Edge t = pq.delMin();
    		   int v = t.either();
    		   int w = t.other(v);
    		   if(marked[v]&&marked[w]) continue;
    		   mst.enqueue(t);
    		   if(!marked[v]) visit(E,v);
    		   if(!marked[w]) visit(E,w);
    		   }
       }
       private void visit(EdgeWeightedGraph E,int w){
    	   marked[w] = true ;
    	   for(Edge v:E.adj(w)){
    		   if(!marked[v.other(w)])
    			   pq.insert(v);
    	   }
       }
       public String toString(){
    	   String a = " ";
    	   for(Edge w:mst){
    		   a+= w.toString() + " \n";
    	   }
    	   return a ;
       }
       public static void main(String[] args){
    	   In in = new In();
    	   EdgeWeightedGraph E = new EdgeWeightedGraph(in);
    	   LazyPrimMST lps = new LazyPrimMST(E);
    	   System.out.println(lps.toString());
    	  
       }
}
