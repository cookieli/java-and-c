package com.lizhengxian.collection;

public class StackTest<T> {
	  private T[] a=(T[])new Object[1];
	  private int N=0;
	  public boolean isEmpty(){return N==0;}
	  public int size(){return N;}
	  private void reseise(int max){
		  T[] temp=(T[]) new Object[max];
		  for(int i =0;i<N;i++){
			  temp[i]=a[i];
		  }
		  a=temp;
	  }
	  public void push(T item){
		  if(N==a.length){reseise(2*a.length);}
		  a[N++]=item;
	  }
	  public T pop(){
		  T item = a[--N];
		  a[N]=null;
		  if(N<a.length/4) reseise(a.length/2);
		  return item;
		  
	  }
     
}
