package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class LCA {
     private Digraph D;
     private boolean[] marked;
     public LCA(Digraph D){
    	 this.D = D.reverse();
    	 marked = new boolean[D.V()];
     }
     public Iterable<Integer> parent(int i){
    	 Queue<Integer> queue = new Queue<Integer>();
    	 Queue<Integer> parent = new Queue<Integer>();
    	 marked[i] = true;
    	 queue.enqueue(i);
    	 while(!queue.isEmpty()){
    		 int v = queue.dequeue() ;
    		 for(int w : D.adj(v)){
    			 if(!marked[w]) {
    				 marked[w] = true ;
    				 queue.enqueue(w);
    				 parent.enqueue(w);
    		   }
    		 }
    	 }
    	 return parent;
     }
     public Iterable<Integer> bothparent(int w,int v){
    	 Queue<Integer> wparent = (Queue<Integer>) parent(w);
    	 Queue<Integer> vparent = (Queue<Integer>) parent(v);
    	 Queue<Integer> both = new Queue<Integer>();
    	 for(int s: wparent){ System.out.println(s);}
    	 if(wparent.size()>vparent.size()){
    		 for(int s :vparent){
    			 for(int h :wparent){
    				 if(s==h) {both.enqueue(h);break;}
    			 }
    		 }
    	 }
    	 else{
    		 for(int s :wparent){
    			 for(int h :vparent){
    				 if(s==h) {both.enqueue(h);break;}
    			 }
    	      }
          }
    	 return both;
    }
     public static void main(String[]args){
    	 In in = new In();
    	 Digraph di = new Digraph(in);
    	 LCA lca = new LCA(di);
    	System.out.println(lca.bothparent(1, 2)); 
     }
}
