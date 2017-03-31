package com.lizhengxian.elementarySorts;

import java.util.Arrays;

import edu.princeton.cs.algs4.Shell;

//Keep Increments in an array
 public class RewriteShell {
       private RewriteShell() {}
       public static void sort(Comparable[] a){
    	   int N = a.length;
    	   int h = 1;
    	   int recordCapacity = N/3+1;
    	   int[] record = new int[recordCapacity];
    	   for(int i = 0;i<record.length;i++){
    		   record[i] = h;
    		   h = 3*h+1;
    	   }
    	   for(int m = record.length;m>0;m--){
    		   for(int n =record[m-1];n<N;n++){
    			   for(int s =n;s>=record[m-1]&&less(a[s],a[s-record[m-1]]);s=s-record[m-1]){
    				   exch(a,s,s-record[m-1]);
    			   }
    		   }
    	   }
    	  
       }
       public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;  
       }
       public static void exch(Object[] a,int i,int j){
    	   Object temp = a[i];
    	   a[i] = a[j];
    	   a[j] = temp;
       }
       public static void main(String args[]){
    	   String[] a = new String[]{"c","a","e","d","m","h"};
    	   RewriteShell.sort(a);
    	   for(int i =0;i<a.length;i++){
    		   System.out.print(a[i]+",");
    	   }
    	   Arrays.sort(a);
       }
}
