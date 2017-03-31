package com.lizhengxian.basic;

public class OrderedArrayPQ<Key extends Comparable<Key>> {
     private Key[] pq;
     private int N=0;
     public OrderedArrayPQ(int max){
    	 pq = (Key[])new Comparable[max];
     }
     public void insert(Key a){
    	 if(N==pq.length-1) resizing(2*N);
    	 pq[N++] = a;
    	 insection(pq);
     }
     public Key delMax(){
    	 Key temp = pq[N-1];
    	 pq[N-1] = null;
    	 N--;
    	 return temp;
     }
     private void insection(Key[] a){
    	 for(int j =N-1;j>0&&less(a[j],a[j-1]);j--){
    		 exch(a,j,j-1);
    	 }
     }
     public boolean isEmpty(){
    	 return N==0;
     }
     public int size(){
    	 return N;
     }
     public void resizing(int max){
		 Key[] temp =  (Key[]) new Comparable[max];
		 for(int i = 0; i < pq.length ; i++){
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
	 public static void main(String[] args){
		 OrderedArrayPQ<Integer> oa = new OrderedArrayPQ<Integer>(5);
		 oa.insert(1);
		 oa.insert(4);
		 oa.insert(7);
		 oa.insert(3);
		 System.out.println(oa.delMax());
		 System.out.println(oa.delMax());
	 }
}
