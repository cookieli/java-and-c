package com.Algorithms.rise;

import java.util.Iterator;

public class ResizingArrayDeque<T> implements Iterable<T>{
      private T[] a = (T[])new Object[1];//存放数据的数组
      private int N=0;
      public boolean isEmpty(){
    	  return N==0;
      }
      public int arraySize(){
    	  return a.length;
      }
      public int size(){
    	  return N;
      }
      private void resize(int length){
    	  T[] b = (T[])new Object[length];
    	  for(int i=0;i<N;i++){
    		  b[i] = a[i];
    	  }
    	  a = b;
      }
      private void nextMove(){//将数组元素向后移动一位
    	  for(int i =N;i>=1;i--){
    		  a[i] =a[i-1];
    	  }
      }
      private void preMove(){//将数据元素向前移动一位
    	  for(int i= 0;i<N-1;i++){
    		  a[i] = a[i+1];
    	  }
      }
      public void pushLeft(T item){
    	    if (N==a.length) resize(2*a.length);
    	    nextMove();
    	    a[0] = item;
    	    N++;
      }
      public void pushRight(T item){
    	  if(N==a.length) resize(2*a.length);
    	  a[N++] = item;
      }
      public T popLeft(){
    	  T item = a[0];
    	  preMove();
    	  a[N] = null;
    	  N--;
    	  if(N>0&&N<=a.length/4){
    		  resize(a.length/2);
    	  }
    	  return item;
      }
      public T popRight(){
    	  T item = a[--N];
    	  a[N] = null;
    	  return item;
      }
      public void getInfo(){
    	  for(int i =0;i<a.length;i++)
    		  System.out.print(a[i]+",");
    	  System.out.println();
      }
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new iter();
	}
	private class iter implements Iterator<T>{
        private int cursor = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor !=N;
		}

		@Override
		public T next() {
			
			return a[cursor++];
			
		}
		
	}
	public static void main(String args[]){
		ResizingArrayDeque<String> rad = new ResizingArrayDeque<String>();
		rad.pushLeft("b");
		
		rad.pushLeft("a");
		
		rad.pushRight("c");
		
		rad.pushRight("d");
	
		rad.pushRight("e");
		
		System.out.println(rad.popRight());
		System.out.println(rad.popRight());
		System.out.println(rad.popRight());
		System.out.println(rad.popRight());
		System.out.println(rad.popRight());
		System.out.println("--------");
		Iterator it = rad.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+",");
		}
		System.out.println("");
		
		
	}
      
}
