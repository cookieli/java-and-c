package com.lizhengxian.basicProblem;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;

public class OrderedSequentialSearchST<Key extends Comparable<Key>,Value> {
    private Node first;
    private Node last;
    private int N = 0;
	private class Node{
    	 Key key;
    	 Value val;
    	 Node next;
    	 public Node(){}
    	 public Node(Key key,Value val,Node next){
    		 this.key = key;
    		 this.val = val;
    		 this.next = next;
    	 }
     }
	public boolean isEmpty(){
		return first ==null;
	}
	public int size(){
		return N;
	}
	public Key min(){
		return first.key;
	}
	public Key max(){
		return last.key;
	}
	public void delete1(Key key){
		first = delete(first,key);
	}
	private Node delete(Node x,Key key){
		if (x==null) return null;
		if(x.key.equals(key)){
			N--;
			return x.next;
		}
		x.next =delete(x.next,key);
		return x;
	}
	public void delete(Key key){
		N--;
		Node newNode = first;
		while(newNode!=null){
			if(newNode.next!=null&&newNode.next.key.equals(key)&&newNode.next.next==null){
				newNode.next = null;
				last = newNode;
			}
			
			else if(key.equals(newNode.key)&&newNode.next!=null){
				newNode.key = newNode.next.key;
				newNode.val = newNode.next.val;
				newNode.next = newNode.next.next;
			}
			else{
				newNode = newNode.next;
			}
		}
	}
	public Key floor(Key key){
		Node newNode = first;
		while(newNode!=null){
			if(newNode.next!=null&&newNode.key.compareTo(key)<=0&&newNode.next.key.compareTo(key)>0){
				return newNode.key;
			}
			else if(newNode.next==null){
				return newNode.key;
			}
			else 
				newNode = newNode.next;
		}
		return null;
		
	}
	public Key ceiling(Key key){
		Node newNode = first;
		while(newNode!=null){
			if(newNode.next!=null&&newNode.key.compareTo(key)<0&&newNode.next.key.compareTo(key)>=0){
				return newNode.next.key;
			}
			else if(newNode.next==null){
				return null;
			}
			else 
				newNode = newNode.next;
		}
		return null;
	}
	public int rank(Key key){
		Node newNode = first;
		int cnt = 0;
		while(newNode!=null){
			if(newNode.key.compareTo(key)<0){
				cnt++;
				newNode = newNode.next;
			}
			else break;
		}
		return cnt;
	}
	public Value get(Key key){
		Node newNode = first;
		while(newNode!=null){
			Key item = newNode.key;
			if(item.equals(key)){
				return newNode.val;
			}
			else
				newNode = newNode.next;
		}
		return null;
	}
	
	public void put(Key key,Value val){
		N++;
		if(first==null){
			first = new Node(key,val,null);
			last = new Node(key,val,null);
		}
		else{//实现一个链表的归并
		   Node dummy =new Node();
		   dummy.next = first;
		   Node newNode = new Node(key,val,null);
		   Node p1 = dummy;
		   while(p1.next!=null){
			   int cmp = key.compareTo(p1.next.key);
			   if(cmp>0){
				   p1 = p1.next;
				   if(p1.next==null){
					   p1.next = newNode;
					   last = newNode;
					   first = dummy.next;
					   return;
				   }
			   }
			   else{
				   newNode.next = p1.next;
				   p1.next = newNode;
				   first = dummy.next;
				   return;
			   }
		   }
		}
	}
	 public Iterable<Key> keys(){
		 Queue<Key> q = new Queue<Key>();
		 for(Node x=first;x!=null;x=x.next){
			 q.enqueue(x.key);
		 }
		 return q;
	 }
	  public static void main(String[] args){
//		  OrderedSequentialSearchST<Integer,String> st = new  OrderedSequentialSearchST<Integer,String>();
//		  st.put(2, "c");
//		  st.put(0, "b");
//		  st.put(5, "d");
//		  st.put(3, "h");
//		  while(st.keys().iterator().hasNext()){
//			  System.out.print(st.keys().iterator().next()+",");
//		  }
//			  
//		  System.out.println(st.rank(10));
		 SequentialSearchST<Integer,String> st= new SequentialSearchST<Integer,String>();
		 st.put(1, "a");
		 st.put(2, "b");
		 st.put(4, "c");
		 Iterator<Integer> it = st.keys().iterator();
		 while(it.hasNext()){
			 System.out.print(it.next()+",");
		 }
	  }
}
