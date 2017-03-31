package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;

public class KosarajuSCC {
     private boolean[] marked;
     private int[] id ;
     private int count;
     public KosarajuSCC(Digraph G){
    	 marked = new boolean[G.V()];
    	 id  = new int[G.V()];
    	 DepthFirstOrder sd = new DepthFirstOrder(G.reverse());
    	 for(int w:sd.reversepast()){
    		if(!marked[w]) {dfs(G,w);count++;}
    	 }
     }
     private void dfs(Digraph G,int w){
    	 marked[w] = true ;
    	 id[w]  = count ;
    	 for(int v:G.adj(w)) {
    		 if(!marked[v]) dfs(G,v);
    	 }
     }
     public int count(){
    	 return this.count;
     }
    public static void main(String[] args){
    	 In in = new In();
    	 Digraph D = new Digraph(in);
    	 KosarajuSCC kos = new KosarajuSCC(D);
    	 for(int i = 0 ; i < D.V() ; i++){
    		 System.out.println(i+"的id值为"+kos.id[i]);
    	 }
    	 System.out.println("kos连通值为"+kos.count);
     }
}
