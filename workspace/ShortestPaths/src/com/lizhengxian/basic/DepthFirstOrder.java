package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
     private boolean marked[];
     private Queue<Integer> pre;
     private Queue<Integer> post;
     private Stack<Integer> reversepost;
     public DepthFirstOrder(DirectedEdgeWeightedGraph G){
    	 marked = new boolean[G.V()];
    	 pre = new Queue<Integer>();
    	 post = new Queue<Integer>();
    	 reversepost = new Stack<Integer>();
   	 for(int i = 0 ; i < G.V() ; i++){
   		   if(!marked[i])  dfs(G,i);
   	   }
     }
     private void dfs(DirectedEdgeWeightedGraph G,int w){
    	 marked[w] = true ;
    	 pre.enqueue(w);
    	 for(DirectedEdge v: G.adj(w)){
    		 int s = v.to() ;
    		 if(!marked[s]){
    			 dfs(G,s);
    		 }
    	 }
    	 post.enqueue(w);
    	 reversepost.push(w);
     }
     public Iterable<Integer> pre(){
    	 return pre;
     }
     public Iterable<Integer> post(){
    	 return post ;
     }
     public Iterable<Integer> reversepost(){
    	 return reversepost;
     }
     public static void main(String[] args){
    	 
     }
}
