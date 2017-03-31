package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Degrees {
	private int[] Incount ;
	private int[] Outcount ;
    public Degrees(Digraph D){
    	Outcount = new int[D.V()];
    	Incount = new int[D.V()];
    	 for(int i = 0 ; i<D.V() ; i++){
    		 for(int w : D.adj(i))
    			 Outcount[i]++;
    	 }
    	 Digraph E = D.reverse() ;
    	 for(int i = 0 ; i < E.V() ; i++){
    		 for(int w :E.adj(i))
    			 Incount[i]++;
    	 }
      }
      private void dfs(Digraph D,int v){
    	
    	 
      }
      public int indegree(int v){
    	  return Incount[v];
      }
      public int Outdegree(int v){
    	  return Outcount[v];
      }
      public Iterable<Integer> sources(){
    	  return null;
      }
      public Iterable<Integer> sinks(){
    	  return null;
      }
      public static void main(String[] args){
    	  In in = new In();
    	  Digraph D = new Digraph(in);
    	  Degrees deg = new Degrees(D);
    	  for(int i = 0 ; i < D.V() ; i++){
    	  System.out.println(i+"的入度为"+deg.indegree(i));
    	  System.out.println(i+"的出度为"+deg.Outdegree(i));
    	 }
      }
      
}
