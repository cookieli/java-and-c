package com.lizhengxian.basicProblem;

public class BST<Key extends Comparable<Key>,Value> {
	  private Node root;
      private class Node{
    	 private Key key;//键
    	 private Value val;//值
    	 private Node left,right;//指向子树的链接
    	 private int N;//以该节点为根结点的二叉树的节点的个数
    	 private int H;//该节点为根结点的树的高度
    	 public Node(){}
    	 public Node(Key key , Value val,int N){
    		 this.key = key;
    		 this.val = val;
    		 this.N   = N;
    	 }
      }
      public int ahight(){
    	  return aheight(root);
      }
      private int aheight(Node x){
    	  if(x==null) return -1;
    	  return x.H;
      }
      public int size(){
    	  return size(root);
      }
      private int size(Node x){
    	  if(x==null) return 0;
    	  return x.N;
      }
      public Value get(Key key){
    	  return get(root,key);
      }
      private Value get(Node x,Key key){
    	  if(x==null) return null;//查找未命中
    	  int cmp = key.compareTo(x.key);
    	  if(cmp==0)      return x.val;
    	  else if(cmp>0)  return get(x.right,key);
    	  else            return get(x.left, key);
      }
      public void put(Key key,Value val){
    	     root = put(root,key,val);
      }
      private Node put(Node x,Key key,Value val){
    	   if(x==null) return new Node(key,val,1);
    	   int cmp = key.compareTo(x.key);
    	   if(cmp<0)      x.left  =put(x.left,key,val);
    	   else if(cmp>0) x.right = put(x.right,key,val);
    	   else           x.val   = val;
    	   x.N = size(x.left) + size(x.right) +1;
    	   x.H = Math.max(aheight(x.left),aheight(x.right))+1;
    	   return x;
      }
      public Key min(){
    	  return min(root).key;
      }
      private Node min(Node x){
    	  if(x==null)         return null;
    	  if(x.left == null)  return    x;
    	  else                return  min(x.left);
      }
      public  Key  max(){
    	  return max(root).key;
      }
      private Node max(Node x){
    	  if(x==null)         return null;
    	  if(x.right == null) return    x;
    	  else                return  max(x.right);
      }
      public void deleteMin(){
    	  root = deleteMin(root);
      }
      private Node deleteMin(Node x){
    	 if(x==null)      return null;
    	 if(x.left==null) return x.right;
    	 x.left = deleteMin(x.left);
    	 x.N = size(x.left)+size(x.right)+1;
    	 return x;
     }
      public void delete(Key key){
    	  root = delete(root,key);
      }
      private Node delete(Node x,Key key){
    	  if(x==null) return null;
    	  int cmp = key.compareTo(x.key);
    	  if(cmp==0){
    		  if(x.left==null)       return x.right;
    		  else if(x.right==null) return x.left;
    		  else{
    			  Node t  = x;
    			       x  = min(x.right);
    			  x.right = deleteMin(t.right);
    			  x.left  =  t.left; 
    		  }
    	  }
    	  x.N = size(x.left) + size(x.right) + 1;
    	  return x;
      }
      public int height(){
    	  return height(root);
      }
      private int height(Node x){
    	  if(x==null)  return -1;
    	  return 1+Math.max(height(x.left), height(x.right));
      }
      public int avgCompares(){
    	  return avgCompares(root);
      }
      private int avgCompares(Node x){
    	  return length(x)/size(x)+1;
      }
      private int length(Node x){
    	  if(x==null)   return 0;
    	  else        return length(x.left)+length(x.right)+1; 
      }
      public boolean isBinaryTree(){
    	  return root.N==isBinaryTree(root);
      }
      private int isBinaryTree(Node x){
    	  if(x==null) return 0;
    	  return isBinaryTree(x.left)+isBinaryTree(x.right)+1;
      }
      public static int optCompares(int N){
    	  return 0;
      }
      public static void main(String[]args){
    	  BST<String,Integer> bs = new BST<String,Integer>();
    	  bs.put("h", 1);
    	  bs.put("c", 1);
    	  bs.put("s", 1);
    	  bs.put("a", 1);
    	  bs.put("e", 1);
    	  bs.put("r", 1);
    	  bs.put("x", 1);
    	  System.out.println(bs.isBinaryTree(bs.root));
    	  System.out.println(bs.height());
      }
     
}
