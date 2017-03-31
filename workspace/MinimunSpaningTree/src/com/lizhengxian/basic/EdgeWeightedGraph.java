package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedGraph {
     private final int V;
     private int E;
     private Bag<Edge>[] adj;
     public EdgeWeightedGraph(In in){
    	 this(in.readInt());
    	 int E = in.readInt();
    	 System.out.println("边与顶点输入完成");
    	 for(int i =0 ; i <E ; i++){
    	 int v = in.readInt();
    	 int w = in.readInt();
    	 double weight = in.readDouble();
//    	 adj[v].add(new Edge(v,w,weight));
//    	 adj[w].add(new Edge(v,w,weight));
    	 addEdge(new Edge(v,w,weight));
      }
      System.out.println("无向权重图构建完成"); 
     }
     public EdgeWeightedGraph(int V){
    	 this.V = V;
    	 this.E = 0 ;
    	 adj = (Bag<Edge>[])new Bag[V];
    	 for(int i =0 ; i < V ; i++){
    		 adj[i] = new Bag<Edge>();
    		
    	 }
     }
     public int V(){
    	 return this.V;
     }
     public int E(){
    	 return this.E;
     }
     public Iterable<Edge> adj(int v){
    	 return this.adj[v];
     }
     public void addEdge(Edge e){
    	 int v = e.either() ;
    	 int w = e.other(v) ;
    	 adj[v].add(e);
    	 adj[w].add(e);
    	 this.E++;
     }
     public Iterable<Edge> edges(){
    	Bag<Edge> list = new Bag<Edge>();
    	for(int i = 0 ; i<V ;i++){
    		int selfloops = 0 ;
    		for(Edge w : adj(i)){
    			if(w.other(i)>i) list.add(w);
    			else if(w.other(i) ==i){
    				if(selfloops%2==0) list.add(w);
    				selfloops++;
    			}
    		}
    	}
    	return list;
     }
     public String toString(){
    	 String a = V + "vertices" + E + "edges\n";
    	 for(int i = 0 ; i < V ; i++){
    		 a+= i + ":";
            for(Edge e:adj[i]){
    			 a+=e.toString()+" ";
    		 }
            a+="\n";
    	 }
    	 return a;
     }
     public static void main(String[] args){
    	 In in = new In();
    	 EdgeWeightedGraph ewg = new EdgeWeightedGraph(in);
    	 System.out.println(ewg.toString());
    	for(Edge e:ewg.adj(0)){
    		System.out.println(e.toString());
    	}
    	 
    	 
    	 
     }
}
