package com.lizhengxian.basic;

import java.util.Iterator;

public class DifferantPritoryQueues<Key extends Comparable<Key>>implements Iterable<Key> {
	 private Key[] pq; 
	 private int N;
	 public DifferantPritoryQueues(){}
	 public DifferantPritoryQueues(int Max){
		 pq = (Key[]) new Comparable[Max+1];
	 }
	 public int size(){
		 return N;
	 }
	 public boolean isEmpty(){
		 return N==0;
	 }
	 public void insert(Key item){
		 if(this.size()==pq.length) resizing(2*pq.length);
		 pq[++N] = item;
	 }
	 public Key delMax(){
		 int temp = findMastIndex();
		 Key most = pq[temp];
		 exch(pq,temp,N--);
		 pq[N+1] = null;
		 if(N>0&&(N==((pq.length-1)/4))){resizing(pq.length/2);}
		 return most;
	 }
	 public int findMastIndex(){
		 int bigger = 1;
		 for(int i =2 ; i<=N ; i++){
			 if(less(pq[bigger],pq[i])) bigger = i;
		 }
		 return bigger;
	 }
	 public void resizing(int max){
		 Key[] temp =  (Key[]) new Comparable[max];
		 for(int i = 0; i <=N ; i++){
			 temp[i] = pq[i];
		 }
		 pq = temp;
	 }
	 private boolean  less(Key a,Key b){
		 return a.compareTo(b)<0;
	 }
	 private void exch(Key[] a,int i,int j){
		 Key temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	 }
   
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return new queueiterator();
	}
	class queueiterator implements Iterator<Key>{
        private DifferantPritoryQueues<Key> copy;
        private queueiterator(){
        	copy = new DifferantPritoryQueues<Key>(size());
        	for(int i=1;i<=N;i++){
        		copy.insert(pq[i]);
        	}
        }
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return! copy.isEmpty();
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			return copy.delMax();
		}
		
	}
	  public static void main(String args[]){
	    	 DifferantPritoryQueues<Integer> dpq = new DifferantPritoryQueues<Integer>(10);
	    	 dpq.insert(10);
	    	 dpq.insert(5);
	    	 dpq.insert(8);
	    	 dpq.insert(7);
	    	 dpq.insert(66);
	    	 dpq.insert(44);
	    Iterator<Integer> it = dpq.iterator();
	    while(it.hasNext()){
	    	System.out.print(it.next()+",");
	    }
	    	 
	     }
}
