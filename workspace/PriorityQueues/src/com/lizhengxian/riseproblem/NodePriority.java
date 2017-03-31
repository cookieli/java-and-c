package com.lizhengxian.riseproblem;

import java.util.Iterator;

public class NodePriority<Key extends Comparable<Key>>implements Iterable<Key> {
	 private Node root;
	 private Node lastinserted;
	 private int leftsize = 0;
	 private int rightsize = 0;
     private class Node{
    	 int N; //它的子节点的数量
    	 Key data;
    	 Node parent;
    	 Node left;
    	 Node right;
    	 private Node(){}
    	 private Node(Key data,int N){
    		 this.data = data;
    		 this.N = N;
    	 }
     }
     private int size(Node x){
    	 if(x == null) return 0;
    	 else          return x.N;
     }
     private Node insert(Node x,Key data){
    	 if(x==null){
    		 lastinserted = new Node(data,1);
    		 return lastinserted;
    	 }
    	 else{
    		 int leftSize = size(x.left);
    		 int rightSize = size(x.right);
    		 if(leftSize<=rightSize){
    			 Node inserted = insert(x.left,data);
    			 inserted.parent = x;
    			 x.left = inserted;
    		 }
    		 else{
    			 Node inserted = insert(x.right,data);
    			 inserted.parent = x;
    			 x.right = inserted;
    		 }
    		 //x.N =leftSize+rightSize+1;
    		 x.N = size(x.left)+size(x.right);
    		 return x;
    	 }
    	 
     }
     private void swim(Node x){
    	 while(x.parent!=null){
    		 if(less(x.parent,x)){ 
    			 exch(x.parent,x);
    		     x = x.parent;
    		 }
    		 else break;
    	 }
     }
     private void sink(Node x){
    	 if(x ==null) return;
    	 while(x.left!=null||x.right!=null){
    		 if(x.left==null){
    			 if(less(x,x.right)){
    				 exch(x,x.right);
    				 x = x.right;
    			 }
    			 else break; 
    		 }
    		 else if(x.right==null){
    			 if(less(x,x.left)){
    				 exch(x,x.left);
    				 x = x.left;
    			 }
    			 else break; 
    		 }
    		 else {
    			 if(less(x.left,x.right)) exch(x.left,x.right);
    			 if(less(x,x.left)){
    				 exch(x,x.left);
    				 x = x.left;
    			 }
    			 else break; 
    		 }
    	 }
     }
     public void insert(Key data){
    	 root = insert(root,data);
    	 swim(lastinserted);
     }
     public int size(){
    	 return size(root);
     }
     private boolean less(Node a,Node b){
    	 return a.data.compareTo(b.data)<0;
     }
     private void exch(Node a,Node b){
    	 Key item = a.data;
    	   a.data = b.data;
    	   b.data = item;
     }
     private Node resetLastinserted(Node x){
    	if(x==null)                     return x;
    	if(x.left==null&&x.right==null) return x;
    	if(size(x.left)>size(x.right))  return resetLastinserted(x.left);
    	else                            return resetLastinserted(x.right);
    	
     }
      public Key delMax(){
    	 if(size()==1) {
    		 Key ket = root.data;
    		 root = null;
    		 return ket;
    	 }
    	 exch(root,lastinserted);
    	 Key lastinsData = lastinserted.data;
    	 Node lastinsParent = lastinserted.parent;
    	 if(lastinsParent.left ==lastinserted) 
    		 lastinsParent.left = null;
    	 else lastinsParent.right = null;
    	 sink(root);
    	 lastinserted = resetLastinserted(root);
    	 return lastinsData;
     }
    
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	private class heapIterator implements Iterator<Key>{
        private Node cursor;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public static void main(String[] args){
		NodePriority<Integer> np = new NodePriority<Integer>();
		np.insert(1);
		np.insert(2);
		np.insert(5);
		np.insert(3);
		System.out.println(np.delMax());
		System.out.println(np.delMax());
		System.out.println(np.delMax());
		np.insert(7);
		System.out.println(np.delMax());
	}
}
