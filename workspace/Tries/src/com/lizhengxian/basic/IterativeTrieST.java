package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Stack;

public class IterativeTrieST<Value> {
	 private static int R = 256 ;
	 private Node root;
     private static class Node{
    	 private Object val  ;
    	 private Node[] next = new Node[R];
     }
    public void put(String key,Value val){
    	if(root == null) root = new Node();
    	Node x = root ;
    	Node pre = null ;
    	int d =0 ;
    	while(d<key.length()){
    		pre = x ;
    		char c = key.charAt(d);
    		x = x.next[c];
    		if(x==null)  pre.next[c] = new Node();
    		x = pre.next[c];
    		d++;
    		if(d == key.length()) {
    			x.val = val;return;
    		}
    	}
    }
    public void delete(String key){
    	if(root==null) return;
    	Stack<Node> stack = new Stack<Node>();
    	Node x = root ;
    	for(int d = 0; d < key.length() ; d++){
    		char c = key.charAt(d);
    		if(x.next[c]==null) return;
    		else {stack.push(x); x = x.next[c];}
    		if(d == key.length()-1)  x.val = null ;
    	}
    	while(!stack.isEmpty()){
    		Node n = stack.pop();
    		for(char c = 0 ; c < R ;c++){
    			if(n.next[c]!=null) return;
    		}
    		n = null;
    	}
    }
    public  void insert(String key,Value val){
    	  if(root == null) root = new Node();
    	  Node x = root ;
    	  for(int i = 0 ; i < key.length(); i++){
    		  char c = key.charAt(i);
    		  if(x.next[c] == null) x.next[c] = new Node();
    		  x = x.next[c];
    		  if(i == key.length()-1)  x.val = val;
    	  }
    }
    private void insert(Node proot,String key,Value val){
    	Node x = proot ;
    	for(int i = 0 ; i < key.length() ; i++){
    		char c  = key.charAt(i);
    		if(x.next[c]==null){
    			x.next[c] = new Node();
    		}
    		if(i == key.length()-1) {
    			x.val = val;
    		}
    		x = x.next[c];
    	}
    }
     
     public Value get(String key){
    	 Node x = root ;
    	 int d = 0 ;
    	
    	 while(d<key.length()&&x!=null){
    		 char c = key.charAt(d);
    		 x = x.next[c];
    		 d++;
    	 }
    	 if(x == null) return null;
    	 return (Value)x.val;
     }
     public static void main(String[]args){
    	 IterativeTrieST<Integer> st = new IterativeTrieST<Integer>();
           st.insert("a", 1);
           st.insert("b", 2);
           st.insert("abc", 4);
           st.delete("abc");
    	   System.out.println(st.get("e"));
    	
    	 
     }
}
