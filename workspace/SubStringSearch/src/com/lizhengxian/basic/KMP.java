package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Queue;

public class KMP {
      private String pat;
      private int[][] dfa;
      public KMP(String pat){
    	  this.pat = pat ;
    	  int R = 256 ;
    	  int M = pat.length();
    	    dfa = new int[R][M];
    	    dfa[pat.charAt(0)][0] = 1;
    	    for(int X =0,j = 1 ; j < M ; j++){
    	    	for(int c = 0 ; c < R ; c++)
    	    		dfa[c][j] = dfa[c][X];
    	    	    dfa[pat.charAt(j)][j] = j + 1;
    	    	    X = dfa[pat.charAt(j)][X];
    	    }
      }
      public int search(String txt){
    	  int i,j, N = txt.length(), M = pat.length();
    	  for( i = 0 , j = 0 ; i < N&&j < M ; i++)
    		   j = dfa[txt.charAt(i)][j];
    	      if(j == M)  return i-M;
    	      else        return N;
      }
      public Iterable<Integer> findAll(String txt){
    	 int M =pat.length();
    	 Queue<Integer> q = new Queue<Integer>();
    	 String subtxt = txt.substring(0);
    	 while(subtxt.length() >= pat.length()){
    		 int i = search(subtxt);
    		 int j = txt.length() - subtxt.length();
    		 if(i==subtxt.length()) break;
    		 q.enqueue(i+j);
    		 subtxt = subtxt.substring(i+M);
    	 }
		return q;
    	
      }
     public static void main(String[] args){
    	 KMP kmp = new KMP("abcababcab");
    	 String pat = "abcababcab";
    	 String txt = "abcabcababcababcababcab";
    	 System.out.println("text:    "+txt);
    	 int offset = kmp.search(txt) ;
    	 System.out.print("pattern: ");
    	 for(int i = 0 ; i < offset ; i++)
    		 System.out.print(" ");
    	     System.out.println(pat);
    	     for(int i : kmp.findAll(txt)){
    	    	 System.out.print(i + " ");
    	     }
    	     
     }
}
