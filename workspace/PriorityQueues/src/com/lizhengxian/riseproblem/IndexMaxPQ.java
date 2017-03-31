package com.lizhengxian.riseproblem;

public class IndexMaxPQ<Key extends Comparable<Key>> {
      private int N = 0;
      private int pq[];
      private int[] qp;
      public Comparable<Key>[] keys;
      public IndexMaxPQ(){}
      public IndexMaxPQ(int max){
    	  keys = (Key[])new Comparable[max+1];
    	  pq = new int[max+1];
    	  qp = new int[max+1];
    	  for(int i =0 ; i<=max ; i++){
    		  qp[i] = -1;
    	  }
      }
      public boolean isEmpty(){
    	  return N==0;
      }
      public int size(){
    	  return N;
      }
      private boolean less(int i,int j){
    	  return keys[pq[i]].compareTo((Key) keys[pq[j]])<0;
      }
      private void exch(int i,int j){
    	  int swap = pq[i];
    	  pq[i] = pq[j];
    	  pq[j] = swap;
    	  qp[pq[i]] = i;
    	  qp[pq[j]] = j;
      }
      private void swim(int k){
    	  while(k>1&&less(k/2,k)){
    		  exch(k,k/2);
    		  k = k/2;
    	  }
      }
      private void sink(int k){
    	 while(2*k<=N){
    		 int j =2*k;
    		 if(j<N&&less(j,j+1)) j = j+1;
    		 if(!less(k,j)) break;
    		 exch(j,k);
    		 k = j;
    	 }  
      }
      //此处先不添加contains(),观察是否还有其他bug;
      public void insert(int k ,Key item){
    	  keys[k] = item;
    	  N++;
    	  pq[N] = k;
    	  qp[k] = N;
    	  swim(k);
    	  
      }
      //删除最大值操作
      public int delMax(){
    	  int maxIndex = pq[1];
    	  Key max = (Key) keys[pq[1]];
    	  exch(1,N--);
    	  sink(1);
    	  keys[pq[N+1]] = null;
    	  //pq[N+1] =-1;
    	  qp[pq[N+1]] =-1;
    	  return maxIndex;
      }
      public void change(int k,Key key){
    	  keys[k] = key;
    	  swim(qp[k]);
    	  sink(qp[k]);
      }
      public int MaxIndex(){
    	  return pq[1];
      }
      public Key max(){
    	  return (Key) keys[pq[1]];
      }
     
      public static void main(String[] args){
    	  IndexMaxPQ<Character> a = new IndexMaxPQ<Character>(20);
    	  a.insert(0, 'b');
    	  a.insert(1, 'f');
    	  a.insert(2, 'd');
    	  a.insert(3, 'e');
    	  a.insert(4, 'h');
    	  a.insert(5, 'a');
    	  System.out.println("最大元素索引是"+a.MaxIndex()+"最大元素是"+a.max());
    	  System.out.println(a.N);
    	  for(int i =1;i<=a.N;i++){
     		 System.out.print(a.pq[i]+",");
     		// System.out.print(a.keys[a.pq[i]]+",");
     	 }
     	 System.out.println();
     	 for(int i = 0;i<a.N;i++){
     		 System.out.print(a.keys[i]+",");
     	 }
     	 System.out.println();
     	 
    	  System.out.println(a.delMax());
    	  System.out.println(a.delMax());
    	  System.out.println("..........删除后......");
    	  System.out.println(a.max());
    	  System.out.println(a.MaxIndex());
    	 for(int i =1;i<=a.N;i++){
    		 System.out.print(a.pq[i]+",");
    		// System.out.print(a.keys[a.pq[i]]+",");
    	 }
    	 System.out.println();
    	 for(int i = 0;i<=a.N;i++){
    		 System.out.print(a.keys[i]+",");
    	 }
    	  
    	  
      }
}
