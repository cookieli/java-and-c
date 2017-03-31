package com.lizhengxian.basicproblem;

public class LRtree<Key extends Comparable<Key>,Value> {
	  Node root;
      private class Node{
    	  Key   key;
    	  Value val;
    	  int   N  ;
    	  Node left,right;
    	  public Node(){}
    	  public Node(Key key,Value val,int N){
    		  this.key = key ;
    		  this.val = val ;
    		  this.N   = N ;
    	  }
      }
      public boolean isEmpty(){
    	  return size(root) == 0;
      }
      public int size(){
    	  return size(root);
      }
      private int size(Node x){
    	  if(x== null) return 0;
    	  else return x.N;
      }
      private boolean isRed(Node x){
    	  if(x==null) return false;
    	  int cmp = x.left.key.compareTo(x.right.key);
    	  if(cmp>0)   return true;
    	  else        return false;
      }
      private void turnLR(Node x){
    	  Node temp = x.left ;
    	  x.left    = x.right;
    	  x.right   = temp;
      }
      private Node rotateLeft(Node h){
    	  Node x = h.right ;
    	  h.right = x.left ;
    	  x.left = h;
    	  x.N = h.N;
    	  h.N =size(h.right)+size(h.left)+1;
    	  return x;
      }
      private Node rotateRight(Node h){
    	  Node x = h.left ;
    	  h.left = x.right ;
    	  x.right = h ;
    	  x.N = h.N ;
    	  h.N = size(h.right) + size(h.left) ;
    	  return x;
      }
      private Node flipColor(Node h){
    	  turnLR(h.left);
    	  turnLR(h.right);
    	  turnLR(h);
    	  return h;
      }
      private Node put(Node proot,Key key,Value val){
    	  Node x = proot;
    	  if(x == null){
    		  x = new Node(key,val,1);
    		  turnLR(x);
    		  return x ;
    	  }
    	  int cmp = key.compareTo(x.key);
    	  if(cmp>0){
    		  if(isRed(x)) x.left = put(x.left,key,val);
    		  else         x.right = put(x.right,key,val);
    	  }
    	  else if(cmp<0){
    		  if(isRed(x)) x.right =put(x.right,key,val);
    		  else         x.left = put(x.left,key,val);
    	  }
    	  else x.val =val ;
    	  if(isRed(x.right)&&!isRed(x.left))    rotateLeft(x);
    	  if(isRed(x.left)&&isRed(x.left.left)) rotateRight(x);
    	  if(isRed(x.left)&&isRed(x.right))     flipColor(x);
    	  x.N = size(x.left) + size(x.right) + 1;
    	  return x;
      }
}
