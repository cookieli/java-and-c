package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class TopoLogicalX {
      private Queue<Integer> order;
      private int[] rank ;
      public TopoLogicalX(Digraph D){
    	  rank = new int[D.V()];
    	  order = new Queue<Integer>();
    	  Queue<Integer> queue = new Queue<Integer>() ;
    	  Degrees De = new Degrees(D);
    	  int[] indegree = new int[D.V()];
    	  for(int i = 0 ; i < D.V() ; i++){
    		  indegree[i] = De.indegree(i);
    		  if(indegree[i]==0) queue.enqueue(i);
    	  }
    	  int count = 0;
    	  while(!queue.isEmpty()){
    		  int v = queue.dequeue();
    		  rank[v] = count ++;
    		  for(int w : D.adj(v)){
    			  indegree[w]--;
    			  if(indegree[w] == 0){
    				  queue.enqueue(w);
    			  }
    		  }
    		  order.enqueue(v);
    	  }
    	  if(count!=D.V()){
    		  order = null ;
    	  }
      }
      public boolean hasOrder(){
    	  return order!=null;
      }
      public Iterable<Integer> order(){
    	  return order;
      }
      public static void main(String[]args){
    	  In in = new In();
    	  Digraph D = new Digraph(in);
    	  TopoLogicalX t = new TopoLogicalX(D);
    	  System.out.println(t.hasOrder());
    	  System.out.println(t.order());
      }
}
