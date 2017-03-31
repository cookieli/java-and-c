package com.lizheng.LinkedList;

import java.util.LinkedList;

public class LinkedTest<T> {
	    Node<T> first;
	    Node<T> last;
	    int size=0;
	    public LinkedTest(){}
	    public void addFirst(T item){
	    	final Node<T> f=first;
	    	final Node<T> l=last;
	    	Node<T> nowNode=new Node<T>(null,item,f);
	    	if(first==null){
	    		first=nowNode;
	    		last=nowNode;
	    	}else{
	    		first.pre =nowNode;	
	    		first =first.pre;
	    	}
	    	size++;
	    }
	    public int getSize(){
	    	return size;
	    }
	    public void addLast(T item){
	    	final Node<T> f=first;
	    	final Node<T> l=last;
	    	Node<T> nowNode= new Node<T>(l,item,null);
	    	if(first==null){
	    		first=nowNode;
	    		last =nowNode;
	    	}else{
	    		last.next=nowNode;
	    		last=last.next;
	    	}
	    	size++;
	    }
	    public void deleteFirst(){
	    	if(first!=null){
	    	first =first.next;
	    	first.pre=null;
	    	}else{
	    		return;
	    	}
	    	size--;
	    }
	    public void deleteLast(){
	    	if(first!=null){
	    	last=last.pre;
	    	last.next=null;
	    	}else{
	    		return;
	    	}
	    	size--;
	    	
	    }
	    public void insertBefore(Node<T> n,T item){
	    	Node<T> lastNode=n.pre;
	    	if(lastNode!=null){
	    	Node<T> insert = new Node<T>(lastNode,item,n);
	    	lastNode.next=insert;
	    	n.pre=insert;
	    	}else{
	    		addFirst(item);
	    	}
	    	size++;
	    }
	    public void insertAfter(Node<T> n,T item){
	    	  Node<T> nextNode=n.next;
	    	  if(nextNode!=null){
	    		  Node<T> insert=new Node<T>(n,item,nextNode);
	    		  n.next=insert;
	    		  nextNode.pre=insert;
	    	  }else{
	    		  addLast(item);
	    	  }
	    	  size++;
	    }
	    private void delete(Node<T> n){
	    	Node<T> lastNode=n.pre;
	    	Node<T> nextNode=n.next;
	    	lastNode.next=nextNode;
	    	nextNode.pre = lastNode;
	    }
	    public Node<T> getNode(int k){
	    	  int cnt =0;
	    	  Node<T> nowNode=first;
	    	  if(k>=0&&k<this.getSize()){
	    	  while(true){
	    		  if(cnt==k){
	    			  return nowNode;  
	    		  }
	    		  cnt++;
	    		  nowNode=nowNode.next;
	    	  }
	    	  }else{
	    		  return null;
	    	  }
	    }
	    public void delete(int k){
	    	int cnt=0;
	    	if(k<0||k>=size){
	    		return;
	    	}else if(k==0){
	    		deleteFirst();
	    	}else if(k==this.getSize()-1){
	    		deleteLast();
	    	}else{
	    		Node<T> nowNode=first;
	    		while(true){
	    			if(k==cnt){
	    				delete(nowNode);
	    				break;
	    			}
	    			cnt++;
	    			nowNode=nowNode.next;
	    			
	    		}
	    	}
	    }
	    
	    public Node<T> getNode(Node<T> pre,T item,Node<T> next){
	    	Node<T> newNode=new Node<T>(pre,item,next);
	    	return newNode;
	    }
	    public Node<T> reverse(Node<T> t){
	    	  Node<T> first=t;
	    	  Node<T> reverse =null;
	    	  while(first!=null){
	    		  Node<T> second =first.next;
	    		  first.next=reverse;
	    		  first.pre=second;
	    		  reverse=first;
	    		  first=second;
	    	  }
	    	  return reverse;
	    }
	    public Node<T> breverse(Node<T> t){
	    	Node<T> first =t;
	    	if(first==null) return null;
	    	if(first.next==null) return first;
	    	else{
	    		Node<T> second = first.next;
	    		Node<T> rest = breverse(second);
	    		second.next =first;
	    		second.pre =second.next;
	    		first.pre=second;
	    		first.next =null;
	    		return rest;
	    	}
	    		
	    	
	    }
	    
       class Node<T>{
    	   Node<T> pre;
    	   T item;
    	   Node<T> next;
    	   public Node(){}
    	   public Node(Node<T> pre,T item,Node<T> next){
    		   this.pre=pre;
    		   this.item=item;
    		   this.next= next;
    	   }
       }
}
