package com.lizhengxian.creativeproblem;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;

public class MergeSortedQueues {
      private static Comparable[] aux = new Comparable[2];
      private static Queue<Comparable>[] queues;
      /**
     * @param a
     * @return
     */
    public static Queue<? extends Comparable> topdown(Comparable[] a){
          Queue<Queue<Comparable>> q3 = new Queue<Queue<Comparable>>(); 
    	  Queue<Comparable> first = new Queue<Comparable>();
    	  Queue<Comparable> second = new Queue<Comparable>();
    	  int N = a.length;
    	  queues =  (Queue<Comparable>[]) new Queue<?>[N];
           for(int i =0 ; i<N ;i++){
        	   queues[i] = new Queue<Comparable>();
        	   queues[i].enqueue(a[i]);
        	   q3.enqueue(queues[i]);
           }
            while(q3.size()>1){
            	first = q3.dequeue();
            	second = q3.dequeue();
            	q3.enqueue((Queue<Comparable>) merge(first,second));
            }
            return (Queue<? extends Comparable>) q3;
           
           
           
      }
      public static Queue<? extends Comparable> merge(Queue<?extends Comparable> q1,Queue<? extends Comparable> q2){
    	  Queue<Comparable> q3 = new Queue<Comparable>();
    	  //aux[0] = q1.dequeue();
    	 // aux[1] = q2.dequeue();
    	  while(true){
    	  if(q1.isEmpty()&&q2.isEmpty())   break;
    	  else if(q1.isEmpty())              q3.enqueue(q2.dequeue());
    	  else if(q2.isEmpty())              q3.enqueue(q1.dequeue());
    	  else if(less(q1.peek(),q2.peek())) q3.enqueue(q1.dequeue());
    	  else                               q3.enqueue(q2.dequeue());
    	  }
    	  return q3;
    	  
      } 
      public static boolean less(Comparable a,Comparable b){
	    	 return a.compareTo(b)<0;
	     }
      public static void exch(Object[]a,int i,int j){
      	   Object temp = a[i];
      	   a[i] = a[j];
      	   a[j] = temp;
        }
      public static void main(String[] args){
    	  Queue q = new Queue();
    	  Double[] a = new Double[]{3.0,6.0,1.0,5.0};    	  
    	  q= topdown(a);
    	  Iterator it = q.iterator();
    	  while(it.hasNext()){
      	  System.out.print(it.next()+",");
    	  }
      }     
}