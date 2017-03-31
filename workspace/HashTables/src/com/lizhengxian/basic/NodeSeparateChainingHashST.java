package com.lizhengxian.basic;

   class Node<Key,Value>{
	public Key key;
	public Value val;
	public Node next;
	public int rank;
	public Node(){}
	public Node(Key key,Value val){
		this.key = key;
		this.val = val;
	}
	public Node(Key key,Value val,int rank){
		this(key,val);
		this.rank = rank ;
	}
}
public class NodeSeparateChainingHashST<Key,Value> {
     private int N ;       //键值对总数
     private int M ;      //链表总数
     private Node<Key,Value>[] st;
     public NodeSeparateChainingHashST(){
    	 this(997);
     }
     public NodeSeparateChainingHashST(int M){
    	 this.M = M;
    	 st = (Node<Key,Value>[])new Node[M];
    	 for(int i =0 ; i < M ; i++){
    		 st[i] = new Node();
    	 }
     }
     private int hash(Key key){
    	 return (key.hashCode()&0x7fffffff)%M;
     }
     
     public void put(Key key,Value val){
    	 int cnt = 0 ;
    	 if(st[hash(key)]==null) st[hash(key)] = new Node(key,val,0);
    	 else {
    		 Node cursor = null ;
    		 for(cursor = st[hash(key)];cursor!=null;cursor = cursor.next){
    			 cnt++;
    			 if(cursor.key == key) cursor.val =val;return;
    			 
    		 }
    		 cursor = new Node(key,val,cnt);
    	 }           
    	
     }
     public Value get(Key key){
    	 for(Node x = st[hash(key)] ; x != null ; x = x.next){
    		 if(x.key == key) return (Value) x.val;
    	 }
    	 return null;
     }
     
     
}
