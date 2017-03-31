package com.lizhengxian.riseproblem;

public class FastInsertMinPQ<Key extends Comparable<Key>> {
     private Key[] pq;
     private int N = 0;
     public FastInsertMinPQ(){}
     public FastInsertMinPQ(int Max){
    	 pq = (Key[])new Object[Max+1];
     }
     public boolean isEmpty(){
    	 return N==0;
     }
     public int size(){
    	 return N;
     }
     private void swim(int k){
    	 Key item = pq[k];
    	
     }
     private boolean less(int i,int j){
    	 return pq[i].compareTo(pq[j])<0;
     }
     private void exch(int i,int j){
    	 Key temp = pq[i];
    	 pq[i] = pq[j];
    	 pq[j] = temp;
     }
     
}
