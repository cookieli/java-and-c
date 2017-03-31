package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;

public class TransitiveClosure {
       private DirectedDFS[] all;
       public TransitiveClosure(Digraph D){
    	   all = new DirectedDFS[D.V()];
    	   for(int i =0 ; i < D.V() ;  i++){
    		   all[i] = new DirectedDFS(D,i);
    	   }
       }
       public boolean reachable(int w ,int v){
    	  return all[w].marked(v);
       }
       public static void main(String[]args){
    	   In in = new In();
    	   Digraph D = new Digraph(in);
    	   TransitiveClosure tc = new TransitiveClosure(D);
    	   System.out.println(tc.reachable(0, 1));
       }
}
