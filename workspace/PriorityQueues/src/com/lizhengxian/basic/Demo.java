package com.lizhengxian.basic;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class Demo {
      private int item;
      public static void main(String[]args){
    	  
    	  Demo d = new Demo();
    	  Demo c = new Demo();
    	  int[] a = new int[]{2,2,3,4};
    	  d.item = a[0];
    	  c.item = a[3];
    	  d=c;
    	  System.out.println(a[3]-a[0]);
    	  //System.out.println(c);
    	  
      }
}
