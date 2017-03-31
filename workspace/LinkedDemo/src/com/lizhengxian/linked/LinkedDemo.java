package com.lizhengxian.linked;



public class LinkedDemo<T> {
	 
      int size;
	  Node<T> first;
      Node<T> last;
      public void addFirst(T item){
    	  final Node<T> f =first;
    	  Node<T> newNode =new Node<T>(item,f);
    	  if(first==null)
    	  {
    		  first=newNode;
    		  last=newNode;
    	  }
    	  else{
    		  first=newNode;
    	  }
    	  size++;
     }
      public void addLast(T item){
    	 final Node<T> l=last;
    	 Node<T> newNode=new Node<T>(item,null);
    	 if(last==null)
    	 {
    		 first=newNode;
    		 last = newNode;
    	 }else{
    		 last=newNode;
    		 l.next=newNode;
          // size++;
    	 }
    	 size++;
      }
      public boolean isEmpty(){
    	  if(first==null)
    	  {
    		  return true;
    	  }
    	  return false; 
      }
      public Node<T> findLastBefore()
      {
    	  if(!this.isEmpty())
    	{
    	  Node<T> temp =first;
    	  while(temp.next.next!=null)
    	  {
    		  temp=temp.next;
    	  }
    	  size--;
    	  return temp;
      }
    	  return null;
     }
      public void deleteLast(){
    	  findLastBefore().next=null;
    	 
      }
      public int size(){
    	 return size;
      }
      public int find(Node<T> node){
    	  for(int i =0;i<this.size();i++)
    	  {
    		  if(this.find(i).equals(node))
    		  return i;
    	  }
    	  return -1;
      }
      public Node<T> find(int k)
      {
    	  Node<T> temp = first;
    	  if(k<this.size())
    	  {
    	  int coord=0;
    	  if(!this.isEmpty())
    	  {
    	   while(temp.next!=null)
    	   {
    		   if(coord==k)
    		   {
    			   break;
    		   }
    		   coord++;
    		   temp = temp.next;	
    	   }
    	  }
    	  return temp;
    	  }
    	  else 
    		  return null;
      }
	  public void delete(int k)
	  {
		  if(k==this.size()-1)
		  deleteLast();
		  else if(k<this.size()-1)
			  if(k==0)
			  {
				  final Node<T> l=first;
				  first=l.next;
				  l.next =null;
				  size--;
			  }
	      else{
		  find(k-1).next=find(k-1).next.next;
		  size--;
	      }
		  
		  else
			   return;
	  }
	  public void removeAfter(Node<T> t){
		  if(t==null)
			  return;
		  if(t.next==null)
			  return;
		  t.next=null;
		  int dvalue =find(t);
		  size=size-dvalue;
	  }
	  public void insertAfter(Node<T> a,Node<T> b)
	  {
		  if(a==null||b==null)
			  return;
		  b.next =a.next;
		  a.next=b;
		  size++;
	  }
	  public void remove(T key){
		  Node<T> nowNode =first;
		  while(true){
			  if(nowNode==null){
				  break;
			  }
			  if(nowNode.item.equals(key))
			  {
				  if(nowNode.next==null){
					  nowNode=null;
					  size--;
					  break;
				  }
				  Node<T> nextNode=nowNode.next;
				  nowNode.item=nextNode.item;
				  nowNode.next=nextNode.next;
				  nextNode=null;
				  size--;
			  }
			  else
				  nowNode =nowNode.next;
		  }
	  }
	  class Node<T>
	  {
		  T item;
		  Node<T> next;
		  Node(){
			  this.item =null;
			  this.next=null;
		  }
		  
		  Node(T item,Node<T> next)
		  {
			  this.item=item;
			  this.next=next;
		  }
	  }
//	  public int max(Node<Integer> first){
//		   int max =0;
//		   Node<Integer> nowNode =first;
//		   while(true){
//			   if(nowNode==null){
//				   break;
//			   }
//			  if(max<nowNode.item){
//				  max=nowNode.item;
//			  }
//			  
//			  nowNode=nowNode.next;
//		   }��
//		   return max;
//	  }
	  public int max(Node<Integer> first,int last_item){
		 if(first==null){
			 return 0;
		 }
		 else if(first.next==null){
			 return last_item>first.item?last_item:first.item;
		 }
		 else {
			int last=last_item>first.next.item?last_item:first.next.item;
			 return max(first.next,last);
		 }
		  
	  }
	  public int maxForList(Node<Integer>first){
		  if(first==null){
			  return 0;
		  }
		if(first.next==null){
			return (int) first.item;
		}
		else{
			int max= maxForList(first.next);
			return max>first.item?max:first.item;
		}
	  }
	  public Node<T> reverse(Node<T> t){
		    Node<T> first = t;
		    Node<T> reverse=null;
		    while(first!=null){
		    	Node<T>second=first.next;
		    	first.next=reverse;
		        reverse = first;
		        first =second;
		    }
		    return reverse;
	  }
	  public Node<T> breverse(Node<T> first){
		   if(first==null) return null;
		   if(first.next==null) return first;
		   Node<T> second = first.next;
		   Node<T> rest = breverse(second);
		   second.next =first;
		   first.next=null;
		   return rest;	
	  }
    
}
