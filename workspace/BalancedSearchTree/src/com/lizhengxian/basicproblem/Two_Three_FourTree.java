package com.lizhengxian.basicproblem;


public class Two_Three_FourTree<Key extends Comparable<Key>,Value> {
	private static boolean RED = true;
    private static boolean BLACK = false;
    private Node root ;
    private class Node{
 	   Key key;
 	   Value val;
 	   Node left,right;
 	   int N;
 	   boolean color;
 	   public Node(){}
 	   public Node(Key key, Value val,int N,boolean color){
 		   this.key = key ;
 		   this.val = val ;
 		   this.N   =  N  ;
 		   this.color = color;
 	   }
    }
    public boolean isEmpty(){
 	   return root.N == 0 ;
    }
    public int size(){
 	   return root.N;
    }
    private int size(Node x){
 	   if(x==null) return 0 ;
 	   else        return x.N;
    }
    //左旋转
    private Node rotateLeft(Node h){
 	    Node x = h.right ;
 	    h.right = x.left ;
 	    x.left = h ;
 	    x.color = h.color ;
 	    h.color = RED;
 	    x.N = h.N ;
 	    h.N = size(h.left) + size(h.right) ;
 	    return x;
    }
    private Node rotateRight(Node h){
 	   Node x = h.left ;
 	   h.left = x.right ;
 	   x.right = h ;
 	   x.color = h.color;
 	   h.color =RED;
 	   x.N= h.N;
 	   h.N = size(h.left) +size(h.right) ;
 	   return x;
    }
    private Node flipColor(Node x){
 	   x.left.color = BLACK ;
 	   x.right.color = BLACK ;
 	   x.color = RED ;
 	   return x;
    }
    private boolean isRed(Node x){
 	   return x.color ==RED ;
    }
    private void iput(Node proot,Key key,Value val){
    	Node x = proot ;
    	Node grandpre = null;
    	Node pre = null;
    	while(x!=null){
    		pre = x;
    		if(isRed(x.left)&&isRed(x.right)) flipColor(x);
    		int cmp = key.compareTo(x.key);
    		if(cmp>0)       x = x.right;
    		else if(cmp<0)  x = x.left ;
    		else            x.val = val;
    		grandpre = pre ;
    	}
    	if(x==null){
    		if(pre == null){ proot= new Node(key,val,1,RED);return;}
    		if(grandpre==pre) x = new Node(key,val,1,RED);
    		if(isRed(pre.right)&&!isRed(pre.left)) rotateLeft(pre);
    		if(isRed(grandpre.left.left)&&isRed(grandpre.left)) rotateRight(grandpre);
    	}
    	Node y = proot ;
    	while(y!=null){
    		int cmp = key.compareTo(y.key);
    		if(cmp>0)       {y.N++;y = y.right;}
    		else if(cmp<0)  {y.N++;y = y.left;}
    		else            {y.N++;return;}
    	}
    	
    }
    private Node put(Node x,Key key,Value val){
 	  if(x == null) return new Node(key,val,1,RED);
 	  //沿路径向下,分解4_结点
 	  if(isRed(x.left)&&isRed(x.right)) {flipColor(x);}
 	  int cmp = key.compareTo(x.key);
 	  if(cmp>0)      x.right = put(x.right,key,val);
 	  else if(cmp<0) x.left  = put(x.left,key,val) ;
 	  else           x.val   = val;
 	  //向上追溯，为保持树的高度不变而配平4-结点
 	  if(isRed(x.right)&&!isRed(x.left))     rotateLeft(x);
 	  if(isRed(x.left)&&isRed(x.left.left))  rotateRight(x);
 	  x.N = size(x.left) + size(x.right) ;
 	  return x;
    }
    public static void main(String[] args){
    	
    }
}
