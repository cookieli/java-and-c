package com.lizhengxian.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class GraphProperties {
      private int[] disTo;       //ָ��ĳһ�����̾���
      private int[] edgeTo;//ָ��w�ĵ���v;
      private int[] cycles; //ͼ�л��ĳ���
      private int[] eccents;//ͼ�и����������
      private int diameter; //ͼ��ֱ��
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
    			  if(disTo[w]==-1){//˵��wû�б���ǹ�
    				  disTo[w] = disTo[v] + 1 ;
    				  edgeTo[w] = v;
    				  eccen = disTo[w];
    				  queue.enqueue(w);
    			  }
    			  else if(edgeTo[v]!=w){//˵���ҵ���һ����
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
    		  System.out.println("��"+i+"�����������Ϊ"+gp.eccentricity(i));
    		  System.out.println("��"+i+"������ܳ�ΪΪ"+gp.cycles[i] );
    	  }
    	  System.out.println(".................");
    	  System.out.println("ֱ��"+gp.diameter);
    	  System.out.println("�뾶"+gp.radius);
    	  
      }
}
