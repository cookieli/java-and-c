package com.lizhengxian.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class graph {
   public final int V;
   public int E;
   public Bag<Integer>[] adj;
   public graph(int V){
	   this.V =V;
	   this.E = 0 ;
	   adj = (Bag<Integer>[])new Bag[V];
	   for(int i = 0 ; i < V ; i++){
		   adj[i] = new Bag<Integer>();
	   }
   }
   public graph(In in){
	   this(in.readInt());
	   System.out.println("顶点数目输入成功");
	   int E = in.readInt();
	   System.out.println("边数目输入成功");
	   for(int i = 0 ; i < E ; i++ ){
		  int w = in.readInt();
		  
		  int v = in.readInt();
		
		  addEdge(w,v);
	   }
    System.out.println("图已初始化完成");
   }
   public graph(In in,String sp){
	   this(in.readInt());
	   int E =in.readInt();
	   System.out.println("边数目输入成功"+",顶点数目成功");
	   while(in.hasNextLine()){
		   String[] a = in.readLine().split(sp);
		   int[] ach = new int[a.length];
		   for(int i = 0 ; i < ach.length;i++)
			   ach[i] = Integer.parseInt(a[i]);
		   for(int i = 1 ; i < a.length ; i++){
			   addEdge(ach[0],ach[i]);
		   }
	   }
	  
	   
	   
   }
   public graph(graph G){
	   this(G.V());
	   this.E = G.E;
	   for(int v = 0;v<G.V();v++){
	   Stack<Integer> reverse = new Stack<Integer>();
	    for(int w:G.adj(v)){
	    	reverse.push(w);
	    }
	    for(int x:reverse){
	    	adj[v].add(x);
	    }
	   }
   }
   public void addEdge(int v,int w){
	   if(hasEdge(v,w)) return;
	   if(v == w)       return;
	   adj[v].add(w);
	   adj[w].add(v);
	   E++;
   }
   public Iterable<Integer> adj(int v){
	   return adj[v];
   }
   public int V(){
	   return this.V;
   }
   public boolean hasEdge(int v,int w){
	   for(int x:adj[w])
		   if(x==v) return true;
	   return false;
   }
   public String toString(){
	  String s = V + "vertices,"+ E + "edges\n";
	  for(int v = 0 ;v < V ; v++){
		  s+=v+":";
		  for(int w:this.adj(v)){
			  s+=w+" ";
		  }
		  s+="\n";
	  }
	   return s;
   }
  
   public static void main(String[] args){
	   In in = new In();
 	   graph G = new graph(in);
 	   System.out.println(G.toString());
   }
   
}
