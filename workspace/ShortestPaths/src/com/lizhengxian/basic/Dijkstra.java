package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Dijkstra {
    private DirectedEdge[] edgeTo;
    private double[] disTo;
    private DirectedEdge anotherEdge;
    private IndexMinPQ<Double> pq;
    public Dijkstra(DirectedEdgeWeightedGraph G,int s){
    	edgeTo = new DirectedEdge[G.V()];
    	disTo  = new double[G.V()];
    	pq     = new IndexMinPQ<Double>(G.V());
    	for(int i = 0 ; i <G.E() ; i++){
    		disTo[i] = Double.POSITIVE_INFINITY;
    	}
    	disTo[s] = 0 ;
    	pq.insert(s, disTo[s]);
    	while(!pq.isEmpty()){
    		relax(G,pq.delMin());
    	}
    }
    private void relax(DirectedEdgeWeightedGraph G,int i){
    	for(DirectedEdge E : G.adj(i)){
    		int w = E.to();
    		if(i==4){
    			System.out.println(disTo[i]+","+disTo[w]+E.weight());
    			System.out.println(E.toString());
    		}
    		System.out.println("数为"+i);
    		if(disTo[w]>disTo[i]+E.weight()){
    			System.out.println("值为"+i);
    			edgeTo[w] = E;
    			disTo[w] = disTo[i] +E.weight();
    		}
    		else {
    			System.out.println((disTo[i]+E.weight()));
    			System.out.println(disTo[w]);
    			System.out.println("值为"+i);
              anotherEdge = E;
             // while(true){System.out.println(this.anotherEdge.toString());}
    		}
    		 
    		if(pq.contains(w)) pq.changeKey(w, disTo[w]);
    		else               pq.insert(w, disTo[w]);
    	}
    }
    public double disTo(int v){
    	return disTo[v];
    }
    public boolean hasPathTo(int v){
    	return disTo[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v){
    	if(!hasPathTo(v)) return null;
    	Stack<DirectedEdge> path = new Stack<DirectedEdge>();
    	for( DirectedEdge x = edgeTo[v] ; x!=null ; x= edgeTo[x.from()]){
    		path.push(x);
    	}
    	return path;
    }
//    public Iterable<DirectedEdge> anotherPathTo(int v){
//    	
//    }
    public Iterable<DirectedEdge> edges(){
    	Queue<DirectedEdge> queue = new Queue<DirectedEdge>();
         for(int i = 1 ; i < edgeTo.length ; i++){
        	 queue.enqueue(edgeTo[i]);
         }	
         return queue;
    }
    public static void main(String[] args){
    	In in = new  In();
    	DirectedEdgeWeightedGraph G = new DirectedEdgeWeightedGraph(in);
    	Dijkstra a = new Dijkstra(G,0);
    	System.out.println(a.disTo(1));
    	if(a.hasPathTo(1)){
    	  for(DirectedEdge d :a.pathTo(1)){
    		  System.out.print(d.toString()+" ");
    	  }
    	  System.out.println();
//    	  for(DirectedEdge d :a.anotherPathTo(2)){
//    		  System.out.print(d.toString()+" ");
//    	  }
    	}
    	 
    	 System.out.println(a.anotherEdge.toString());
    	
    	
    	
    }
}
