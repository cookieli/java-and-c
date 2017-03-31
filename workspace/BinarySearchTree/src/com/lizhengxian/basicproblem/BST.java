package com.lizhengxian.basicproblem;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

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
    	 public Node(Key key , Value val){
    		 this.key = key;
    		 this.val = val;
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
      public Value iget(Key key){
    	  Node x = root ;
    	  while(x!=null){
    		  int cmp = key.compareTo(x.key);
    		  if(cmp>0)      x = x.right;
    		  else if(cmp<0) x = x.left;
    		  else          return x.val;
    	  }
    	  return null;
      }
      public void iput(Key key,Value val){
    	  Node x = root;
    	  if(x==null) {root = new Node(key,val,1);return;}
    	  Node pre = null;
    	  while(x!=null){
    		  pre = x;
    		  int cmp = key.compareTo(x.key);
    		  if(cmp>0)           x = x.right;
    		  else if(cmp<0)      x = x.left;
    		  else      {x.val = val;return;}             
    	  }
    	  int cmp1 = key.compareTo(pre.key);
    	  if(cmp1>0) pre.right = new Node(key,val);
    	  else      pre.left  = new Node(key,val);
    	  Node y = root;
    	  while(y!=null){
    		  int cmp0 = key.compareTo(y.key);
    		  if(cmp0>0)     {y.N++; y = y.right;}
    		  else if(cmp0<0){y.N++; y = y.left;}
    		  else      {y.N++;return;}
    	  }
      }
      public Key min(){
    	  return min(root).key;
      }
      private Node min(Node x){
    	  if(x==null)         return null;
    	  if(x.left == null)  return    x;
    	  else                return  min(x.left);
      }
      public Key imin(){
    	  return imin(root).key;
      }
      private Node imin(Node proot){
    	  Node x = proot;
    	  while(x!=null){
    		  if(x.left==null)      return x;
    		  else               x = x.left;  
    	  }
    	  return null;
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
      
      public Key floor(Key key){
    	  return floor(root,key).key;
      }
      private Node floor(Node x,Key key){
    	  if(x==null)      return null;
    	  int cmp = key.compareTo(x.key);
    	  if(cmp==0)       return x;
    	  else if(cmp<0)   return floor(x.left,key);
    	  else {
    		 Node t = floor(x.right,key);
    		 if(t==null)   return x;
    		 else          return t;
    	  }  
      }
      public Key ifloor(Key key){
    	  return ifloor(root,key).key;
      }
      private Node ifloor(Node proot,Key key){
    	  Node x = proot ;
    	 
    	  Node pre = null;
    	  if(x==null)    return null;
    	  while(x!=null){
    		  pre = x;
    		  int cmp = key.compareTo(x.key);
    		  if(cmp==0) return x;
    		  if(cmp<0 ) x = x.left;
    		  else  {
    			 if(x.right!=null&&key.compareTo(min(x.right).key)<0) return x;
    			 else  x = x.right;
    		  }
    	  }
    	  return pre;
      }
      public  Key  select(int k){
    	  return select(root,k).key;
      }  
      private Node select(Node x,int k){
    	  if(x==null)       return null;
    	  int t = size(x.left);
    	  if(t>k)           return select(x.left,k);
    	  else if(t<k)      return select(x.right,k-t-1);
    	  else              return  x;
      }
      public Key iselect(int k){
    	  return iselect(root,k).key;
      }
      private Node iselect(Node proot,int k){
    	  Node x = proot ;
    	  int m =k;
    	  while(x!=null){
    		  int t = size(x.left);
    		  if(t>m)       x = x.left;
    		  else if(t<m) { x = x.right; m = m-t-1;}
    		  else          return x;
    	  }
    	  return null;
      }
      public int rank(Key key){
    	  return rank(root,key);
      }
      private int rank(Node x,Key key){
    	  if(x==null)        return 0;
    	  int cmp = key.compareTo(x.key);
    	  if(cmp<0)          return rank(x.left,key);
    	  else  if(cmp>0)    return 1+size(x.left)+rank(x.right,key);
    	  else               return size(x.left);
      }
      private int irank(Node proot,Key key){
    	 Node x = proot;
    	 int cnt = 0;
    	 if(x==null) return 0;
    	 while(x!=null){
    		 int cmp = key.compareTo(x.key);
    		 if(cmp<0)         x = x.left ;
    		 else if(cmp==0)  cnt+=size(x.left);   
    		 else{
    			 cnt=cnt+size(x.left)+1;
    			 x = x.right;
    		 }
    	 }
    	 return cnt;  
      }
      private boolean isOrdered(Node x,Key min,Key max){
    	  if(x==null)  return true;
    	  if(min!=null&&x.key.compareTo(min)<0) return false;
    	  if(max!=null&&x.key.compareTo(max)>0) return false;
    	  return isOrdered(x.left,min,max)&&isOrdered(x.right,min,max);
    	  
      }
     private boolean isRankConsistent(){
    	 for(int i = 0 ; i < size() ; i++){
    		 if(i != rank(select(i)))  return false;
    	 }
    	 for(Key key:keys()){
    		 if(key.compareTo(select(rank(key)))!=0) return false;
    	 }
    	 return true;
     }  
     private Iterable<Key> OrderLevel(){
    	 Queue<Key> keys = new Queue<Key>();
    	 Queue<Node> queue = new Queue<Node>();
    	 queue.enqueue(root);
    	 while(!queue.isEmpty()){
    		 Node x = queue.dequeue();    	 
    		 if(x==null) continue;
    		 keys.enqueue(x.key);
    		 queue.enqueue(x.left);
    		 queue.enqueue(x.right);
    	}
    	 return keys;
     }
     public Iterable<Key> keys(){
    	 return keys(min(),max());
     }
     private Iterable<Key> keys(Key lo,Key hi){
    	 Queue<Key> queue = new Queue<Key>();
    	 keys(root,queue,lo,hi);
    	 return queue;
     }
     private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
    	 if(x==null) return;
    	 int locmp = lo.compareTo(x.key);
    	 int hicmp = hi.compareTo(x.key);
    	 if(locmp<0) keys(x.left,queue,lo,hi);
    	 if(locmp<=0&&hicmp>=0) queue.enqueue(x.key);
    	 if(hicmp>0) keys(x.right,queue,lo,hi);
     }
     private void ikeys(Node proot, Queue<Key> queue){
    	 Stack<Node> stk = new Stack<Node>();
    	 Node x = proot;
    	 while(x!=null||!stk.isEmpty()){
    		 if(x!=null){
    			 stk.push(x);
    			 x = x.left;
    		 }
    		 else{
    			 x = stk.pop();
    			 queue.enqueue(x.key);
    			 x = x.right ;
    		 }
    	 }
     }
     private void morrisKeys(Node proot,Queue<Key>queue){
    	 Node p = proot;
    	 Node pre = null;
    	 while(p!=null){
    		 if(p.left==null) {queue.enqueue(p.key);p = p.right;}
    		 else{
    			 pre = p.left;
    			 while(pre.right!=null||pre.right!= p)
    				 pre = pre.right;
    			 if(pre.right==null){
    				 pre.right = p;
    				 p = p.left;
    			 }
    			 else{
    				 pre.right = null;
    				 queue.enqueue(p.key);
    				 p = p.right;
    			 }
    		 }
    	 }
     }
      private boolean hasNoDuplicates(Node x){
    	  if(x==null) return true;
    	  int Lcmp = x.key.compareTo(x.left.key);
    	  int Rcmp = x.key.compareTo(x.right.key);
    	  if(Lcmp==0||Rcmp==0)  return false;
    	  else  return hasNoDuplicates(x.left)&&hasNoDuplicates(x.right);
      }
      public static void main(String[]args){
    	  BST<String,Integer> bs = new BST<String,Integer>();
    	  bs.iput("s", 1);
    	  bs.iput("e", 4);
    	  bs.iput("x", 6);
    	  bs.iput("a", 5);
    	  bs.iput("c", 1);
    	  bs.iput("r", 1);
    	  bs.iput("h", 1);
    	  bs.iput("m", 1);
    	  
    	  System.out.println(bs.floor("g"));
    	  System.out.println(bs.ifloor("g"));
//    	  bs.put("c", 1);
//    	  bs.put("s", 1);
//    	  bs.put("a", 1);
//    	  bs.put("e", 1);
//    	  bs.put("r", 1);
//    	  bs.put("x", 1);
    	  
      }
     
}
