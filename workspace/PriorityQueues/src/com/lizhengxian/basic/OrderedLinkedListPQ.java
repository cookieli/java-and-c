package com.lizhengxian.basic;

import java.util.Iterator;

public class OrderedLinkedListPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Node first;
    private int N;
    public boolean isEmpty(){
    	return N==0;
    }
    public int size(){
    	return N;
    }
    public void insert(Key item){
    	if(first==null){
    		Node newNode = new Node(item);
    		first = newNode;
    		first.next = null;
    	}
    	else{
    		Node newNode = new Node(item);
    		newNode.next = first;
    		first = newNode;
    		first =sort(first);
    	}
    }
    public Key delMax(){
    	Key max = first.item;
    	first = first.next;
    	return max;
    }
    public Node sort(Node first){
    	if(first.next==null) return first;
    	Node middle = findMiddle(first);
    	Node lefthead = first;
    	Node righthead = middle.next;
    	middle.next = null;
    	lefthead = sort(lefthead);
    	righthead = sort(righthead);
    	return merge(lefthead,righthead);
    	
    	
    }
    private Node merge(Node head1,Node head2){
    	Node dummy = new Node();
    	dummy.next = head1;
    	Node p1 =dummy;
    	Node p2 = head2;
    	while(p1.next!=null&&p2!=null){
    		if(less(p1.next.item, p2.item)&&p1.next.next==null){
    			p1.next.next = p2;
    		   break;
    		}
    		else if(less(p1.next.item, p2.item)){
    			p1 = p1.next;
    		}
    		else if(!less(p1.next.item, p2.item)){
    			head2 = head2.next;
    			p2.next = p1.next;
    			p1.next = p2;
    			p1 =p2;
    			p2 = head2;
    			
    		}
    	}
    	return dummy.next;
    }
    private boolean less(Key a,Key b) {
    	return a.compareTo(b)>0;
    }
    
    private Node findMiddle(Node first){
    	Node slow = first;
    	Node fast = first;
    	while(fast!=null&&fast.next!=null&&fast.next.next!=null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
	class Node{
    	 Key item;
    	 Node next;
         private Node(){}
         private Node(Key item){
        	 this.item = item;
         }
      
     }
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return new PQiterator();
	}
	private class PQiterator  implements Iterator<Key>{
        private Node newNode = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return newNode !=null;
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			Key temp = newNode.item;
			newNode = newNode.next;
			
			return temp;
		}
		
	}
	public static void main(String []args){
    	 OrderedLinkedListPQ<Integer> od = new OrderedLinkedListPQ<Integer>();
    	 od.insert(7);
    	 od.insert(5);
    	 od.insert(9);
        System.out.println(od.delMax()); 
        System.out.println(od.delMax()); 
//    	 od.insert(1);
    	 System.out.println("..............");
    	 Iterator<Integer> it = od.iterator();
    	 while(it.hasNext()){
    		 System.out.println(it.next());
    	 }
    	 
     }
}
