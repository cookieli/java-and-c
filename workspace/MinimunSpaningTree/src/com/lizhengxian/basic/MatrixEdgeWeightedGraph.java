package com.lizhengxian.basic;

public class MatrixEdgeWeightedGraph {
      private double[][] Edge;
      private int E;
      private int V;
      public MatrixEdgeWeightedGraph(int V){
    	  Edge = new double[V][V];
    	  for(int i = 0 ; i <V ; i++){
    		  for(int j = 0 ; j < V ;j++){
    			  Edge[i][j] =Double.POSITIVE_INFINITY;
    		  }
    	  }
      }
}
