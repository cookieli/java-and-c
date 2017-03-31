package com.lizhengxian.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
     private final int V;
     private int E;
     private Bag<Integer>[] adj;
     public Digraph(int V){
    	 this.V = V;
    	 adj =(Bag<Integer>[]) new Bag[V];
    	 for(int i = 0; i < V ; i++){
    		 adj[i] = new Bag<Integer>();
    	 }
     }
     public Digraph(In in){
    	 this(in.readInt());
    	 int E = in.readInt();
    	 System.out.println("���������ɹ�");
    	 for(int i = 0 ; i < E ; i++){
    		 int w = in.readInt();
    		 int v = in.readInt();
    		 addEdge(w,v);
    	 }
    	 System.out.println("����ͼ�������");
     }
     public Iterable<Integer> adj(int i){
    	 return this.adj[i];
     }
     private void addEdge(int w, int v){
    	 adj[w].add(v);
    	 this.E++;
     }
     private int V(){ return this.V; }
     private int E(){ return this.E; }
     public String toString(){
    	 String s = V + "vertices, " + E + " edges\n";
    	 for(int v = 0; v < V ; v++){
    		 s+=v + ":";
    		for(int w : this.adj(v)){
    			s+=w + " ";
    		}
    		s+= "\n";
    	 }
    	 return s;
     }
     public static void main(String[] args){
    	 In in = new In();
    	 Digraph di = new Digraph(in);
    	 System.out.println(di.toString());
     }
}
