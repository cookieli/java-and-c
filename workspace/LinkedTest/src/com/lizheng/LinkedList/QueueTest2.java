package com.lizheng.LinkedList;

public class QueueTest2<T> {
      public T[] a =(T[])new Object[1];
      int N=0;
      public int size(){
    	  return N;
      }
      public boolean isEmpty(){ return N==0; }
      public void resize(int max){
    	     T[] temp =(T[]) new Object[max];
    	     for(int i =0;i<a.length;i++){
    	    	 temp[i] = a[i];
    	     }
    	     a = temp;
      }
      public void enqueue(T temp){
    	  if(N==a.length){ resize(2*a.length);}
    	  a[N++] = temp;
    	  
      }
      public T dequeue(){
    	  T item = a[0];
    	  for(int i =0;i<N-1;i++)
    	  {
    		  a[i]=a[i+1];
    	  }
    	  a[N-1] =null;
    	  N--;
    	  if(N<a.length/4){
    		  resize(a.length/2);
    	  }
    	  return item;
      }
      public void getInfo()
      {
    	  for(int i =0;i<a.length;i++){
    		  System.out.print(a[i]+",");
    	  }
    	  System.out.println();
      }
      public static void main(String args[]){
    	  QueueTest2<String> t2 = new QueueTest2<String>();
    	  t2.enqueue("a");
    	  t2.enqueue("b");
    	  System.out.println(t2.dequeue());
    	 // System.out.println(t2.size());
    	 // t2.getInfo();
    	
      }
}
