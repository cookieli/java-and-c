package com.lizhengxian.parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Parentheses {
      private static final char LEFT_PAREN ='(';
      private static final char RIGHT_PAREN = ')';
      private static final char LEFT_BRACE ='[';
      private static final char RIGHT_BRACE = ']';
      private static final char LEFT_BRACKET = '{';
      private static final char RIGHT_BRACKET = '}';
      
      public static Boolean isBalance(String s){
    	 
    	  Stack<Character> s1 = new Stack<Character>();
    	  char[] scr =s.toCharArray();
    	  for(int i=0;i<scr.length;i++){
    		  if (scr[i]==LEFT_PAREN||scr[i]==LEFT_BRACE||scr[i]==LEFT_BRACKET){
    			  s1.push(scr[i]);
    		  }
    		  else if(scr[i]==RIGHT_PAREN){
    			  if(s1.pop()!=LEFT_PAREN){
    				  return false;
    			  }
    		  }
    		  else if(scr[i]==RIGHT_BRACE){
    			  if(s1.pop()!=LEFT_BRACE){
    				  return false;
    			  }
    		  }
    		  else if(scr[i]==RIGHT_BRACKET){
    			  if(s1.pop()!=LEFT_BRACKET){
    				  return false;
    			  }
    		  }
    	  }
    	  return true;
    	  
    	  
    	  
      }
      public static void main(String args[]) throws IOException{
    	// In in=new In();
    	 //String s =
    	 BufferedReader br=new BufferedReader(
    			           new InputStreamReader(System.in));
    	String s = br.readLine().trim();
    	 //String s ="[]{(}";
    	 System.out.println(isBalance(s));
    	 
    	
      }
}
