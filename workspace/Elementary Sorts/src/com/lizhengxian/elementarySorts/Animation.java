package com.lizhengxian.elementarySorts;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Animation {
       public static void main(String[] args) throws InterruptedException {
    	   int N = 50;
    	   Double[] a = new Double[N];
    	   String[] b = new String[N];
    	   for(int i =0 ; i<N ; i++){
    		   a[i] =Math.random();
    	   }
    	   //��һ����ȷ��������С
    	  // StdDraw.setXscale(0,N);
    	  // StdDraw.setYscale(0,N);
    	   //�ڶ�����ȷ�����ʴ�С
    	   StdDraw.setPenRadius(0.001);
    	   RewriteSelection.sort(a);
//    	   for(int i=0; i<N; i++){
//    		   double x = 1.0*i/N;
//    		   double y =a[i]/2.0;
//    		   double rw =0.5/N;
//    		   double rh =a[i]/2.0;
//    		   StdDraw.filledRectangle(x, y, rw, rh);
//    	   }
       }
}
