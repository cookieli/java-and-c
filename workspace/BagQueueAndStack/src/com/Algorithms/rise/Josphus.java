package com.Algorithms.rise;

import edu.princeton.cs.algs4.Queue;

public class Josphus {
      public static void main(String args[]){
    	  int N =41;
    	  int M =3;
    	  Queue<Integer> q1 = new Queue<Integer>();
    	  for(int i=0;i<N;i++){
    		  q1.enqueue(i);
    	  }
    	  kill(q1,M);
      }
      /**
     * 
     */
    public static void kill(Queue<Integer> q1,int M){
    	int people_cnt=0;
    	int temp=-1;
    	while(q1.size()!=0){
    		temp=q1.dequeue();
    		people_cnt++;
    		if(people_cnt==M){
    			people_cnt =0;
    			//System.out.println("------------");
    			System.out.print(temp+",");
    		}
    		else{
    			q1.enqueue(temp);
    		}
    	}
   }
}
