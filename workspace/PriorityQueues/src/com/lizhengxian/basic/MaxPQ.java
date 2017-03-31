package com.lizhengxian.basic;

import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;

public class MaxPQ <Key extends Comparable<Key>> implements Iterable<Key>{
        private Key[] pq;
        private Stack<Key> s;
        private int N =0;
        public MaxPQ(){}
        public MaxPQ(int max){
        	pq = (Key[])new Comparable[max+1];
        	s  = new Stack<Key>();
        	
        }
        public MaxPQ(Comparable<Key>[] copy){
        	pq = (Key[])new Comparable[copy.length+1];
        	N = copy.length;
        	for(int i =1 ;i<pq.length;i++){
        		pq[i] =(Key) copy[i-1];
        	}
        	for(int i =1 ; i<pq.length ; i++){
        		swim(i);
        	}
        }
        public int size(){
        	return N;
        }
        public boolean isEmpty(){
        	return N==0;
        }
        public void sort(Comparable[]a){
        	int N = a.length;
        	for(int k =N/2;k>=1;k--){
        		
        	}
        }
        private void swim(int k){
        	while(k>1&&less(k/2,k)){
        		exch(k,k/2);
        		k = k/2;
        	}
        }
        private Key delMax(){
        	Key max = pq[1];
        	exch(1,N--);
        	pq[N+1] = null;
        	sink(1);
        	return max;
        }
        
        public Key min(){
        	return s.peek();
        }
        private void insert(Key item){
        	pq[++N] =  item;
        	if(s.isEmpty()) s.push(item);
        	else{
        		if(less(item,s.peek())){
        			s.pop();
        			s.push(item);
        		}
        	}
        	swim(N);
        }
        private boolean less(Key a1, Key a2) {
			// TODO Auto-generated method stub
			return a1.compareTo(a2)<0;
		}
		private void sink(int k){
        	while(2*k<=N){
        		int j =2*k;
        		if(j+1<=N&&less(j,j+1)) j++;
        		if(!less(k,j)) break;
        		exch(k,j);
        		k = j;
        	}
        }
        private boolean less(int i,int j){
        	return pq[i].compareTo(pq[j])<0;
        }
        private void exch(int i,int j){
        	Key temp = pq[i];
        	pq[i] = pq[j];
        	pq[j] = temp;
        }
		
		@Override
		public Iterator<Key> iterator() {
			// TODO Auto-generated method stub
			return new HeapIterator();
		}
		public class HeapIterator implements Iterator<Key>{
            private MaxPQ<Key> copy;
            public HeapIterator(){
            	copy = new MaxPQ<Key>(size());
            	for(int i =1;i<=N;i++){
            		copy.insert(pq[i]);
            	}
            }
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return !copy.isEmpty();
			}

			@Override
			public Key next() {
				// TODO Auto-generated method stub
				return copy.delMax();
			}
			
		}
		public static void main(String[] args){
			MaxPQ<Integer> pq = new MaxPQ<Integer>(10);
			
			//pq.insert(0);
			pq.insert(7);
			pq.insert(44);
			pq.insert(5);
			pq.insert(33);
			pq.insert(2);
			pq.insert(22);
			System.out.println(pq.min());
			System.out.println(pq.size());

			Iterator<Integer> it = pq.iterator();
			while(it.hasNext()){
				System.out.print(it.next()+",");
			}
		}
		
}
