package com.lizhengxian.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.princeton.cs.algs4.Stack;

public class StackApplication {
      public static void main(String args[]) throws IOException{
    	  BufferedReader br = new BufferedReader(
    			              new InputStreamReader(
    			            	    System.in));
    	  String expretion = br.readLine();
    	  System.out.println(EvaluatePostfix(InfixToPostFix(expretion)));
      }
      public static String complete(String exp){
    	  String[] s = exp.split(" ");
    	  Stack<String> data = new Stack<String>();
    	  Stack<String> opr = new Stack<String>();
    	  for(int i=0;i<s.length;i++){
    		  if(isOpretor(s[i])){
    			  opr.push(s[i]);
    		  }
    		  else if(s[i].equals(")")){
    			  String d1 = data.pop();
    			  String d2 = data.pop();
    			  String op = opr.pop();
    			  String var ="(" + d2+op+d1+s[i];
    			  data.push(var);
    			  
    		  }
    		  else{
    			  data.push(s[i]);
    		  }
    		  
    	  }
    	  return data.pop();
    }
      private static boolean isOpretor(String i){
    	  if(i.equals("+")||i.equals("-")||i.equals("*")||i.equals("/")){
    		  return true;
    	  }
    	  return false;
      }
      public static String InfixToPostFix(String s){
    	    String postFixExp="";
    	    Stack<String> data = new Stack<String>();
    	    Stack<String> opr = new Stack<String>();
    	    String [] str=s.split(" ");
    	    for(int i=0;i<str.length;i++){
    	    	if(str[i].equals("(")){
    	    		opr.push(str[i]);
    	    	}
    	    	else if(str[i].equals("+")||str[i].equals("-")){
    	    		if(opr.isEmpty()){
    	    			opr.push(str[i]);
    	    		}
    	    		else if(opr.peek().equals("*")||opr.peek().equals("/")){
    	    	    while(opr.peek().equals("*")||opr.peek().equals("/")){
    	    				postFixExp=postFixExp+opr.pop();
    	    			}
    	    	       opr.push(str[i]);
    	    		}
    	    	    else{
    	    	    	opr.push(str[i]);
    	    	     }
    	    		}
    	    	 else if(str[i].equals("*")||str[i].equals("/")){
    	    		 opr.push(str[i]);
    	    	 }
    	    	 else if(str[i].equals(")"))
    	    	 {
    	    		 while(!opr.peek().equals("("))
    	    		 {
    	    			 postFixExp=postFixExp+ opr.pop();
    	    		 }
    	    		 opr.pop();
    	    	 }
    	    	 else{
    	    		 postFixExp=postFixExp+str[i];
    	    	 }
    	    }
    	    	while(!opr.isEmpty()){
    	    		postFixExp=postFixExp+opr.pop();
    	    	}
    	    	return postFixExp;
      }
      public static double EvaluatePostfix(String s){
    	  char [] scr = s.toCharArray();
    	  Stack<Double> data = new Stack<Double>();
    	  for(int i =0;i<scr.length;i++){
    		  if(scr[i]=='+'){
    			double value = data.pop();
    			value = value + data.pop();
    			data.push(value);  
    		  }
    		  else if(scr[i]=='-'){
    			  double value = data.pop();
    			  value = value - data.pop();
    			  data.push(value);
    		  }
    		  else if(scr[i]=='*'){
    			  double value = data.pop();
    			  value = value * data.pop();
    			  data.push(value);
    		  }
    		  else if(scr[i]=='/'){
    			  double value = data.pop();
    			  value = value * data.pop();
    			  data.push(value);
    		  }
    		  else{
    			  data.push(Double.valueOf(scr[i]-48.00 ));
    		  }
    		  
    	  }
    	  return data.pop();
      }
}
    	    		 
    	    	 
    	    	
    	    
      
