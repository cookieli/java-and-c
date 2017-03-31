package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> past;
    private Stack<Integer> reversepast;
    public DepthFirstOrder(Digraph G){
    	marked = new boolean[G.V()];
    	pre    = new Queue<Integer>();
    	past   = new Queue<Integer>();
    	reversepast = new Stack<Integer>();
    	for(int i =0 ; i < G.V() ; i++){
    	     if(!marked[i]) dfs(G,i);
    	}
    }
    private void dfs(Digraph G,int v){
    	pre.enqueue(v);
    	marked[v] = true ;
    	for(int w:G.adj(v)){
    		if(!marked[w]) dfs(G,w);
    	}
    	past.enqueue(v);
    	reversepast.push(v);
    }
    public Iterable<Integer> pre()
    { return pre; }
    public Iterable<Integer> past()
    {return past;}
    public Iterable<Integer> reversepast()
    {return reversepast;}
    public static void main(String[]args){
    	In in = new In();
    	Digraph G = new Digraph(in);
    	DepthFirstOrder d = new DepthFirstOrder(G);
    	for(int w: d.pre()){
    		System.out.print(w+" ");
    	}
    	System.out.println();
    	for(int w: d.past()){
    		System.out.print(w+" ");
    	}
    	System.out.println();
    	for(int w: d.reversepast()){
    		System.out.print(w+" ");
    	}
    	System.out.println();
    }
}
