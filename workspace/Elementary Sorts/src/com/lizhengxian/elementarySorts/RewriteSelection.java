package com.lizhengxian.elementarySorts;

import edu.princeton.cs.algs4.StdDraw;

public class RewriteSelection {
      public static void sort(Comparable[] a) throws InterruptedException {
    	  int N = a.length;
    	  for(int i =0;i<N;i++){
    		  int min =i;
    		  for(int j =i+1;j<N;j++){
    			  if(less(a[j],a[min])) min = j;
    		  }
    		  exch(a,min,i);
    		  draw(a);
    		   
    		  //StdDraw.show();
    		 
    	  }
      }
      public static void draw(Comparable[] a) throws InterruptedException{
    	  int N = a.length;
    	  Thread.sleep(100);
		  StdDraw.clear();
		  Thread.sleep(10);
		  //StdDraw.show();
		  for(int m=0; m<N; m++){
   		   double x = 1.0*m/N;
   		   double y =(double)a[m]/2.0;
   		   double rw =0.5/N;
   		   double rh =(double)a[m]/2.0;
   		   StdDraw.filledRectangle(x, y, rw, rh);
   		   
   	   }
      }
      public static boolean less(Comparable a,Comparable b){
    	  
		return a.compareTo(b)<0;
    	  
      }
      public static void exch(Object[]a,int i,int j){
    	   Object temp = a[i];
    	   a[i] = a[j];
    	   a[j] = temp;
      }
}
