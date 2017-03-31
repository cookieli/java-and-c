package com.lizhengxian.basicproblem;

public class AVLtree<Key extends Comparable<Key>,Value> {
	   Node root;
       private class Node{
    	   Key key;
    	   Value val;
    	   int H;
    	   Node left,right;
    	   public Node(){}
    	   public Node(Key key,Value val,int H){
    		   this.key = key ;
    		   this.val = val ; 
    		   this.H   =  H  ; 
    	   }
       }
       public int height(){
    	   return root.H;
       }
       private int max(int a,int b){
    	   return a>b?a:b;
       }
       private int height(Node x){
    	   if(x==null)  return 0;
    	   return x.H;
       }
       private Node rotateRight(Node h){
    	   Node x  = h.left;
    	   h.left  = x.right;
    	   x.right = h ;
    	   h.H = max(height(h.right),height(h.left)) + 1; 
    	   x.H = max(height(x.right),height(x.left)) + 1;
    	   return x;
       }
       private Node rotateLeft(Node h){
    	   Node x  = h.right ;
    	   h.right = x.left  ;
    	   x.left  = h       ;
    	   h.H = max(height(h.right),height(h.left)) + 1;
    	   x.H = max(height(x.left),height(x.right)) + 1;
    	   return x;
       }
       private Node put(Node x,Key key,Value val){
    	   if(x==null) return new Node(key,val,0);
    	   int cmp = key.compareTo(x.key) ;
    	   if(cmp>0)      x.right = put(x.right,key,val);
    	   else if(cmp<0) x.left  = put(x.left,key,val);
    	   else           x.val   =val ;
    	   //平衡高度
    	   if(height(x.left)-height(x.right)>1){
    		   //左左情况
    		   if(height(x.left.left)>height(x.left.right)   ) x=rotateRight(x);
    		   //左右情况
    		   else if(height(x.left.right)>height(x.left.left)){
    			  x = rotateLeft(x);
    			  x = rotateRight(x);   
    		   }
    	   }
    	   else if(height(x.right)-height(x.left)>1){
    		   //右右情况
    		   if(height(x.right.right)>height(x.right.left)){
    			   x= rotateLeft(x);
    		   }
    		   //右左情况
    		   else if(height(x.right.left)>height(x.right.right)){
    			   x = rotateRight(x);
    			   x = rotateLeft(x);
    		   }
    	   }
    	   return x;
       }
}
