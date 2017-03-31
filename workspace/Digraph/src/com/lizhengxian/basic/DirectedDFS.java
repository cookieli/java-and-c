package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DirectedDFS {
     private boolean[] marked;
     public DirectedDFS(Digraph G,Iterable<Integer> sourse){
    	 marked = new boolean[G.V()];
    	 for(int w:sourse){
    		 dfs(G,w);
    	 }
     }
     public DirectedDFS(Digraph G){
    	 marked = new boolean[G.V()];
    	 for( int i = 0 ; i < G.V() ; i++){
    		 dfs(G,i);
    	 }
     }
     public DirectedDFS(Digraph G,int i){
    	 marked = new boolean[G.V()];
    	 dfs(G,i);
     }
     private void dfs(Digraph G,int v){
    	 marked[v] = true ;
    	 for(int w:G.adj(v)){
    		 if(!marked[w]) dfs(G,w);
    	 }
     }
     public boolean marked(int v){
    	 return  marked[v];
     }
     public static void main(String[]args){
    	 Digraph G = new Digraph(new In(args[0]));
    	 Bag<Integer> sources = new Bag<Integer>();
    	 for(int i =1 ; i < args.length ;i ++)
    		 sources.add(Integer.parseInt(args[i]));
    	 DirectedDFS reachable = new DirectedDFS(G,sources);
    	 for(int v = 0 ; v < G.V() ;v++)
    		 if(reachable.marked(v)) System.out.println(v + " ");
    	 System.out.println();
     }
}
