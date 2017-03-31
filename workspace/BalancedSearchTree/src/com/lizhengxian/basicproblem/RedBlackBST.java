package com.lizhengxian.basicproblem;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
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
       private Node min(Node x){
    	   if(x==null)        return null;
    	   if(x.left==null)   return x;
    	   return min(x.left);
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
       private void flipColor(Node x){
    	   x.left.color  = !x.left.color ;
    	   x.right.color = !x.right.color ;
    	   x.color = !x.color ;
       }
       private boolean isRed(Node x){
    	   if(x==null) return false;
    	   return x.color ==RED ;
       }
       private boolean is23(Node x){//注意正确的分情况考虑
    	   if(x==null)                          return true;
    	   if(isRed(x.right))                   return false; 
    	   if(x!=root&&isRed(x)&&isRed(x.left)) return false;
    	   return is23(x.left)&&is23(x.right);
       }
       private boolean isBalanced(){
    	   Node x = root ;
    	   int black = 0 ;
    	   while(x!=null){
    		   if(!isRed(x)) black++;
    		   x = x.left ;
    	   }
    	   return isBalanced(root,black);
       }
       private boolean isBalanced(Node x,int black){
    	   if(x==null) return black==0;
    	   black--;
    	   return isBalanced(x.left,black)&&isBalanced(x.right,black);
       }
       public boolean isBST(){
    	   return isBST(root,null,null);
       }
       private boolean isBST(Node x,Key min,Key max){
    	   if(x==null)   return true;
    	   if(min!=null&&x.key.compareTo(min)<=0) return false;
    	   if(max!=null&&x.key.compareTo(max)>=0) return false;
    	   return isBST(x.left,min,x.key)&&isBST(x.right,x.key,max);
       }
       private Node put(Node x,Key key , Value val){
    	   if(x == null) { return new Node(key,val,1,RED);}
    	   int cmp = key.compareTo(x.key) ;
    	   if(cmp > 0) x.right = put(x.right,key,val);
    	   else if (cmp < 0) x.left = put(x.left,key,val) ;
    	   else       x.val = val;
    	   if(!isRed(x.left)&&isRed(x.right)) x = rotateLeft(x);
    	   if(isRed(x.left)&&isRed(x.left.left)) x = rotateRight(x);
    	   if(isRed(x.left)&&isRed(x.right)) flipColor(x);
    	   x.N = size(x.left) + size(x.right) + 1;
    	   return x;
       }
       private Value get(Node x,Key key){
    	   if(x==null)     return null;
    	   int cmp = key.compareTo(x.key);
    	   if(cmp>0)       return get(x.right,key);
    	   else if(cmp<0)  return get(x.left,key);
    	   else            return x.val;
       }
       //if(x.left and x.left.left)
       private Node moveRightLeft(Node h){
    	   flipColor(h);//这句话含义有二：俩个子节点都是2-结点时将他们粘成一个4-节点边结点是
    	                //当其右边结点是3-结点时键值转移第一步
    	   if(isRed(h.right.left)){
    		   h.right = rotateRight(h.right);
    		   h = rotateLeft(h);
    	   }
    	   return h;
       }
       private Node delete(Node x,Key key){
    	   if(key.compareTo(x.key)<0){
    		   if(!isRed(x.left)&&!isRed(x.left.left)){
    			   x = moveRightLeft(x);
    			   x.left = delete(x.left,key);
    		   }
    	   }
    	   else{
    		   if(isRed(x.left)) x = rotateRight(x);
    		   if(key.compareTo(x.key)==0&&x.right==null) return null;
    		   if(isRed(x.right)&&isRed(x.right.left)){
    			   x = moveRedRight(x);
    		   }
    		   if(key.compareTo(x.key)==0){
    			   x.val = get(x.right,min(x.right).key);
    			   x.key = min(x.right).key ;
    			   x.right = deleteMin(x.right);
    		   }
    		   else  
    			   x.right =delete(x.right,key);
    	   }
    	   return balance(x);
       }
       private Node deleteMin(Node h){
    	   if(h.left==null) return null;
    	   if(!isRed(h.left)&&!isRed(h.left.left))
    		   h = moveRightLeft(h);
    	       h.left = deleteMin(h.left);
    	      return balance(h);
       }
       private Node deleteMax(Node x){
    	   if(isRed(x.left)) x = rotateRight(x);
    	   if(x.right==null) return null;
    	   if(!isRed(x.right)&&!isRed(x.right.left))
    		   moveRedRight(x);
    	   x.right = deleteMax(x.right);
    	   return balance(x);
       }
       private Node  moveRedRight(Node x){
    	   flipColor(x);
    	   if(!isRed(x.left.left)){
    		   x = rotateRight(x);
    	   }
    		   return x;
       }
       private Node balance(Node h){
    	   if(isRed(h.right)) rotateLeft(h);
    	   if(isRed(h.left)&&isRed(h.left.left)) rotateRight(h);
    	   if(isRed(h.left)&&isRed(h.right)) flipColor(h);
    	   h.N = size(h.left) + size(h.right) + 1;
    	   return h;
       }
       
       
       
}
