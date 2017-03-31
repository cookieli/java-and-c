package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DirectedEdgeWeightedGraph {
       private final int V;
       private int E;
       private Bag<DirectedEdge>[] adj;
       public DirectedEdgeWeightedGraph(int V){
    	   this.V = V;
    	   this.E = 0;
    	   adj =(Bag<DirectedEdge>[]) new Bag[V];
    	   for(int i = 0 ; i < V ;i++){
    		   adj[i] = new Bag<DirectedEdge>();
    	   }
       }
       public int V(){
    	   return this.V;
       }
       public int E(){
    	   return this.E;
       }
       public DirectedEdgeWeightedGraph(In in){
    	   this(in.readInt());
    	   int E = in.readInt();
    	   System.out.println("vertex and edge come in");
    	   for(int i = 0 ; i < E ;i++){
    		   int v = in.readInt();
    		   int w = in.readInt();
    		   double weight  = in.readDouble();
    		   addEdge(new DirectedEdge(v,w,weight));
    	   }
    	   System.out.println("ÊäÈëÍê³É");
       }
       public void addEdge(DirectedEdge e){
    	   adj[e.from()].add(e);
    	   E++;
       }
       public Iterable<DirectedEdge> adj(int v){
    	   return adj[v];
       }
       public Iterable<DirectedEdge> edges(){
    	   Bag<DirectedEdge> edges = new Bag<DirectedEdge>();
    	   for(int i = 0 ; i < V ;i++){
    		   for(DirectedEdge e:adj[i]){
    			   edges.add(e);
    		   }
    	   }
    	   return edges;
       }
       public static void main(String[] args){
    	   In in  = new In();
    	   DirectedEdgeWeightedGraph def = new DirectedEdgeWeightedGraph(in);
    	  
       }
}
