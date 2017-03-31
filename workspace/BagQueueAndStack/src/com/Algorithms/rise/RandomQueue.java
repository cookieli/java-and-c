package com.Algorithms.rise;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue <T> implements Iterable<T>{
      private int N=0;
      public int size(){
    	  return N;
      }
     
      T[] queue ;
      public RandomQueue(){
    	  queue =(T[])new Object[1];
      }
      public boolean isEmpty(){
    	  return N==0;
      }
      private void resize(int max){
    	  T[] b = (T[])new Object[max];
    	  for(int i=0;i<N;i++){
    		  b[i] =queue[i];
    	  }
    	  queue =b;
    	  
    	  
      }
      public void enqueue(T item){
    	  if(N==queue.length){resize(2*queue.length);}
    	  queue[N++] = item;
      }
     private void randomSwap(){
    	 if(N<=1) return;
    	 Random rand = new Random();
    	 int swapIndex = rand.nextInt(N-1);
    	 T temp = queue[swapIndex];
    	 queue[swapIndex] = queue[N-1];
    	 queue[N-1] = temp;
    	
     }
      public T dequeue(){
    	  randomSwap();
    	  T item = queue[--N];
    	  queue[N] = null;
    	  if(N>0&&N<queue.length/4){resize(queue.length/2);}
    	  return item;	  
      }
      public T sample(){
    	  randomSwap();
    	  return queue[N-1];
      }
    
    public static void main(String args[]){
    	  RandomQueue<String> rq = new RandomQueue<String>();
    	  rq.enqueue("a");
    	  rq.enqueue("b");
    	  rq.enqueue("c");
    	  rq.enqueue("f");
    	  rq.enqueue("e");
    	  rq.enqueue("g");
    	  System.out.println(rq.size());
    	Iterator<String> it = rq.iterator();
    	while(it.hasNext()){
    		System.out.println(it.next());
    	}
    	
    	  
      }
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iter();
	}
    private class Iter implements Iterator<T>{
    	public Iter(){
    		shuffle();
    	}
        int cursor = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor!=N;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return queue[cursor++];
		}
		private void shuffle(){
			for(int i =0;i<N;i++){
				int randomIndex = i +(int)(Math.random()*(N-i));
				T temp = queue[randomIndex];
				queue[randomIndex]= queue[i];
				queue[i] = temp;
			}
		}
    	
    }
   
	   
   
}
