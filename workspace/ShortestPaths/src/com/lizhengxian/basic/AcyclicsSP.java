package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class AcyclicsSP {
     private DirectedEdge[] edgeTo;
     private double[] disTo;
     public AcyclicsSP(DirectedEdgeWeightedGraph G,int s){
    	 edgeTo = new DirectedEdge[G.V()];
    	 disTo  = new double[G.V()];
    	 for(int i = 0 ; i < G.V() ; i++){
    		 disTo[i] = Double.POSITIVE_INFINITY;
    	 }
    	 disTo[s] = 0 ; 
    	Topological T = new Topological(G);
        for(int w : T.order()){
        	relax(G,w);
        }
     }
     private void relax(DirectedEdgeWeightedGraph G,int s){
    	 for(DirectedEdge d: G.adj(s)){
    		 int w = d.to();
    		 if(disTo[w]>disTo[s]+d.weight()) {
    			 edgeTo[w] = d ;
    			 disTo[w] = disTo[s] +d.weight();
    		 }
    	 }
     }
   
     public double disTo(int v){
    	 return disTo[v];
     }
     public boolean hasPathTo(int v){
    	 return disTo[v]<Double.POSITIVE_INFINITY;
     }
     public Iterable<DirectedEdge> pathTo(int v){
    	 if(!hasPathTo(v)) return null;
    	 Stack<DirectedEdge> path = new Stack();
    	 for(DirectedEdge e = edgeTo[v]; e!=null ; e = edgeTo[e.from()])
    		 path.push(e);
    	 return path ;
     }
     public static void main(String[]args){
    	 In in = new In();
    	 DirectedEdgeWeightedGraph G = new DirectedEdgeWeightedGraph(in);
    	 AcyclicsSP ac = new AcyclicsSP(G,0);
    	 System.out.println(ac.disTo(2));
    	 System.out.println(ac.hasPathTo(2));
    	for(DirectedEdge e:ac.pathTo(2)){
    		System.out.println(e.toString());
    	}
     }
}