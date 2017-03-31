package com.lizhengxian.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
    private boolean[] marked;//是否进行过深度遍历
    private int[] edgeTo;//记录到达某点的最短的点
    private final int s;
    public DepthFirstPaths(graph G,int s){
    	marked = new boolean[G.V()];
    	edgeTo = new int [G.V()];
    	this.s = s;
    	dfs(G,s);
    }
    private boolean isMarked(int v){
    	return marked[v] == true ;
    }
    private void dfs(graph G,int s){
    	marked[s] = true ;
    	for(int w:G.adj(s)){
    		if(!marked[w]){
    			edgeTo[w] = s;
                dfs(G,w);
    		}
    	}
    }
    public boolean hasPathTo(int v){
    	return marked[v] == true;
    }
    public Iterable<Integer> pathTo(int v){
    	if(!hasPathTo(v)) return null;
    	Stack<Integer> st = new Stack<Integer>();
    	for(int x = v ; x != s; x = edgeTo[x]){
    		st.push(x);
    	}
    	st.push(s);
    	return st;
    }
    public static void main(String[] args){
    	In in = new In();
  	    graph G = new graph(in);
  	    DepthFirstPaths d = new DepthFirstPaths(G,0);
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
  	    
    }
}
