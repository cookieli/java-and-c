package com.lizhengxian.basic;

import edu.princeton.cs.algs4.In;

public class Eular {
	private boolean isEular = true;
     public Eular(Digraph G){
    	 KosarajuSCC k = new KosarajuSCC(G);
    	 System.out.println(k.count());
    	 if(k.count()==1){
    		 Degrees d = new Degrees(G);
    		 for(int i = 0 ; i < G.V() ; i++){
    			 if(d.indegree(i)!=d.Outdegree(i)){
    				 System.out.println(i+"²»ÊÇ");
    				 isEular = false;
    			 }
    		 }
    	 }
    	 else isEular = false;
     }
     public static void main(String[] args){
    	 In in = new In();
    	 Digraph D = new Digraph(in);
    	 Eular e = new Eular(D);
    	 System.out.println(e.isEular);
     }
}
