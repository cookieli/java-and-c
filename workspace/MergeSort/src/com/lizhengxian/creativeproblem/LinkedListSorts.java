package com.lizhengxian.creativeproblem;

public class LinkedListSorts<T extends Comparable> {
	  public  Node head;
	  public  Node tail;
	  public  Node find(Node head){
		 Node fast = new Node();
		 Node slow = new Node();
		 fast = head;
		 slow = head;
		 while(fast!=null&&fast.next!=null&&fast.next.next!=null){
			 fast = fast.next.next ;
			 slow = slow.next;
		 }
		return slow;  
	  }
	  public Node mergesort(Node head){
		  if(head.next ==null) return head;
		  Node middle = find(head);
		  Node lefthead = head ;
		  Node righthead = middle.next;
		  middle.next = null ;
		  lefthead = mergesort(lefthead);
		  righthead = mergesort(righthead);
		  return merge(lefthead,righthead);
		   
	  }
	  //把head2对应的链表归并到1里面
	  public Node merge(Node head1,Node head2){
		   Node dummy = new Node();
		   dummy.next = head1;
		   Node p1 = dummy;
		   Node p2 = head2;
		   while(p1.next!=null&&p2!=null){
			   if(less(p1.next.item,p2.item)){
				   p1 = p1.next;
			   }
			   else{
				   head2 = head2.next;
				   p2.next = p1.next;
				   p1.next = p2;
				   p1 = p2;
				   p2 = head2;
			   }
		   }
		   return dummy.next;
	  }
	  public static boolean less(Comparable a,Comparable b){
	      	 return a.compareTo(b)<0;
	       }
	  
      private  class Node{
    	  T item;
    	  Node next;
      }
      public static void main(String args[]){
    	 
      }
}
