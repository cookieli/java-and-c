package com.lizhengxian.basic;

public class Quick3String {
     private static int charAt(String s,int d){
    	 if(d<s.length()) return d ; else return -1;
     }
     private static void exch(String[] a, int i, int j) {
         String temp = a[i];
         a[i] = a[j];
         a[j] = temp;
     }
     private static void sort(String[]a,int lo, int hi ,int d){
    	 if( hi <= lo ) return;
    	 int lt = lo ;
    	 int gt = hi ;
    	 int i  = lo + 1;
    	 int v = charAt(a[lo],d);
    	 while(i<=gt){
    		 int t = charAt(a[i],d);
    		 if     (v < t)    exch(a,i,gt--);
    		 else if(v > t)    exch(a,i++,lt++);
    		 else              i++;
    	 }
    	 sort(a,lo,lt-1,d);
    	 if(v>=0) sort(a,lt,gt,d+1);
    	 sort(a,gt+1,hi,d);
     }
}
