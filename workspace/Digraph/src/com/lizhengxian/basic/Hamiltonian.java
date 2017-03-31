package com.lizhengxian.basic;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;

public class Hamiltonian {
	  private int order;
	  private int[] vertex;
      public Hamiltonian(Digraph D){
    	  vertex = new int[D.V()];
    	  TopoLogical tp = new TopoLogical(D);
    	  Iterator<Integer> it = tp.order().iterator();
    	  int i = 0;
    	  while(it.hasNext()){
    		  vertex[i++] = it.next();
    	  }
    	  for(int k =1 ; k <D.V() ; k++){
    		 for(int w :D.adj(vertex[k-1])){
    			 if(w==vertex[k]) order ++;
    		 }
    	  }
      } 
      public boolean isorder(){
    	  return order==vertex.length-1;
      }
      public static void main(String[]args){
    	  In in = new In();
    	  Digraph D = new Digraph(in);
    	  Hamiltonian h = new Hamiltonian(D);
    	  System.out.println(h.order);
    	  
      }
}
