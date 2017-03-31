package com.lizheng.LinkedList;

import java.util.Iterator;

public class QueueTest3<T> {
     private T[] a= (T[])new Object[1];
     private int N = 0;
     private int first=0;
     private int last =0;
     private void resize(int max){
    	 T[] temp = (T[]) new Object[max];
    	 for(int i = 0; i<N;i++){
    		 temp[i]=a[i];
    	 }
    	 a = temp;
     }
     public void enqueue(T item){
    	 if(N==a.length) resize(a.length*2);
    	 a[last++] = item;
    	 
    	 N++;
     }
     public T dequeue(){
    	 T temp = a[first];
    	 a[first] = null;
    	 N--;
    	 first++;
    	 if(N>0&&N==a.length/4) resize(a.length/2);
    	 return temp;
     }
     public Iterator<T> itreator(){
    	 return new  ArrayIterator();
     }
     private class ArrayIterator implements Iterator <T>
     {
    	 private int i=0;
    	 public boolean hasNext(){ return i<N;}
    	 public T next(){
    		 T item = a[i+first];
    		 i++;
    		 return item;
    	 }
    	 public void remove(){}
    	 
     }
}
