package com.lizhengxian.basicproblem;

public class TwoThreeST<Key extends Comparable<Key>,Value> {
	  private Node root;
       class Node{
    	  Key[] keys;
    	  Value[] vals;
    	  Node left,right;
    	  int N;
    	  public Node(){
    		  keys = (Key[]) new Comparable[1];
    		  vals = (Value[])new Object[1];
    	  }
    	  public Node(Key key1,Value val1,int N){
    		  this();
    		  keys[0] = key1; vals[0] = val1;
    		  this.N = N;
    	  }
      }
       private class TwoNode extends Node{
    	   Node middle;
    	   public TwoNode(){
    		   keys = (Key[]) new Comparable[2];
     		   vals = (Value[])new Object[2];
    	   }
    	   public TwoNode(Key key1,Value val1,Key key2,Value val2,int N){
    		   this();
     		   keys[0] = key1; vals[0] = val1;
     		   keys[1] = key2; vals[1] = val2;
    	   } 
       }
       public int size(){
    	   return size(root);
       }
       private int size(Node x){
    	   if(x == null) return 0;
    	   return x.N;
       }
       public boolean isEmpty(){
    	   return root.N == 0;
       }
       private boolean isTwoNode(Node x){
    	   int l = x.keys.length;
    	   if(l==1) return false;
    	   return true;
       }
       
       private Node put(Node x,Key key,Value val){
    	   if(x==null) return new Node(key,val,1);
    	   if(!isTwoNode(x)){//如果x是单键结点
    		   
    	   }
    	   return x;
       }
      
      
}
