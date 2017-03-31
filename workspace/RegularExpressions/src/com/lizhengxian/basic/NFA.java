package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;

public class NFA {
     private char[] re;
     private Digraph G;
     private int M ;
     public NFA(String regexp){
    	 Stack<Integer> opr = new Stack<Integer>();
    	 re = regexp.toCharArray();
    	 M = re.length;
    	 G = new Digraph(M+1);
    	 for(int i = 0 ; i < M ; i++){
    		 int lp = i;
    		 if(re[i] == '('||re[i] == '|'){
    			 opr.push(i);
    		 }
    		 else if(re[i] == ')'){
    			 int or = opr.pop();
    			 if(re[or]=='|'){
    				 lp = opr.pop();
    				 G.addEdge(lp, or+1);
    				 G.addEdge(or, i);
    			 }
    			 else lp = or ;
    		 }
    	 }
     }
}
