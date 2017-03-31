package com.lizhengxian.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadFirstPaths {
	private final int INIFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    public  int furthest;
    private int[] edgeTo;
    private int[] disTo;
    private final int s;
    public BreadFirstPaths(graph G, int s){
    	marked = new boolean[G.V()];
    	edgeTo = new int[G.V()];
    	disTo  = new int[G.V()];
    	this.s = s;
    	bfs(G,s);
    }
   
    private void bfs(graph G, int s){
    	Queue<Integer> queue = new Queue<Integer>();
    	queue.enqueue(s);
    	for(int i = 0 ; i < G.V() ; i++){
    		disTo[i] = INIFINITY;
    	}
    	disTo[s] = 0 ;
    	marked[s] = true ;
    	while(!queue.isEmpty()){
    		int v = queue.dequeue();
    		if(queue.isEmpty())
    			this.furthest = v;
    		for(int w:G.adj(v)){
    			if(!marked[w]){
    			disTo[w] = disTo[v]+1;
    			marked[w] = true;
				edgeTo[w] = v ;
    			queue.enqueue(w);
    			}
    		}
    	}
    }
    public boolean hasPathTo(int v){
    	return marked[v] ;
    }
    public int disTo(int v){
    	return disTo[v];
    }
    public Iterable<Integer> pathTo(int v){
    	if(!hasPathTo(v)) return null;
    	Stack<Integer> st = new Stack<Integer>(); 
    	for(int x = v;x!=s;x=edgeTo[x]){
    		st.push(x);
    	}
    	st.push(s);
    	return st;
    }
    public static void main(String[]args){
    	In in = new In();
  	    graph G = new graph(in);
  	    BreadFirstPaths d = new BreadFirstPaths(G,0);
  	    for(int v = 0 ; v < G.V() ; v++){
  	    	System.out.print(0+" to "+ v + " : ");
  	    	if(d.hasPathTo(v)){
  	    		for(int x:d.pathTo(v)){
  	    			if(x == 0) System.out.print(x);
  	    			else       System.out.print("-"+x);
  	    		}
  	    		System.out.println();
  	    	}
  	    }
  	    System.out.println(".......................");
  	    
    }
}
