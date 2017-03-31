package com.lizhengxian.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class GraphProperties {
      private int[] disTo;       //指向某一点的最短距离
      private int[] edgeTo;//指向w的点是v;
      private int[] cycles; //图中环的长度
      private int[] eccents;//图中各点的离心率
      private int diameter; //图的直径
      private int radius;
      private int cycle;
      public GraphProperties(graph G){
    	  disTo   = new int[G.V()];
    	  edgeTo  = new int[G.V()];
    	  cycles  = new int[G.V()];
    	  eccents = new int[G.V()];
    	  for(int i =0 ; i < G.V() ; i++){
    		  bfs(G,i);
    	  }
      }
      public int diameter(){
    	  int max = 0 ;
    	  for(int i = 0 ; i < eccents.length ; i++){
    		  if(max < eccents[i]) max = eccents[i];
    	  }
    	  return max;
      }
      public int radius(){
    	  int min = 0 ;
    	  for(int i = 0 ; i < eccents.length ; i++){
    		  if(min > eccents[i]) min = eccents[i];
    	  }
    	  return min;
      }
      public int eccentricity(int v){
    	  return eccents[v];
      }
      public void  bfs(graph G,int s){
    	  int eccen = 0;
    	  int cycle = Integer.MAX_VALUE;
    	  Queue<Integer> queue = new Queue<Integer>();
    	  for(int i =0 ; i < disTo.length ; i++){
    		  disTo[i] = -1 ;
    	  }
    	  disTo[s] = 0;
    	  queue.enqueue(s);
    	  while(!queue.isEmpty()){
    		  int v = queue.dequeue();
    		  for(int w:G.adj(v)){
    			  if(disTo[w]==-1){//说明w没有被标记过
    				  disTo[w] = disTo[v] + 1 ;
    				  edgeTo[w] = v;
    				  eccen = disTo[w];
    				  queue.enqueue(w);
    			  }
    			  else if(edgeTo[v]!=w){//说明找到了一个环
    				  int d = disTo[v] + 1;
    				  cycle = d<cycle?d:cycle;
    				  
    			  }
    		  }
    	  }
    	  cycles[s]  = cycle;
    	  eccents[s] = eccen;
      }
      public static void main(String[] args){
    	  In in = new In();
    	  graph G = new graph(in);
    	  GraphProperties gp = new GraphProperties(G);
    	  for(int i = 0 ; i < G.V() ; i++){
    		  System.out.println("第"+i+"个点的离心率为"+gp.eccentricity(i));
    		  System.out.println("第"+i+"个点的周长为为"+gp.cycles[i] );
    	  }
    	  System.out.println(".................");
    	  System.out.println("直径"+gp.diameter);
    	  System.out.println("半径"+gp.radius);
    	  
      }
}
