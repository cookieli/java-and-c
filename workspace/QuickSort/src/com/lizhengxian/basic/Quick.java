package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
      public static void sort(Comparable[] a){
    	  StdRandom.shuffle(a);
    	  
    	  sort(a,0,a.length-1);
    	 // fastsort(a,0,a.length-1);
      }
      private static void sort(Comparable[]a,int lo,int hi){
    	  if(lo>=hi) return;
    	  findlargest(a);
    	  int j = partition(a,lo,hi);
    	  sort(a,lo,j-1);
    	  sort(a,j+1,hi);
    	  
      }
      private static void fastsort(Comparable[] a,int lo,int hi){
    	 if(hi<=lo) return;
    	  int it = lo, i = lo+1, gt =hi;
    	  Comparable v = a[lo];
    	  while(i<=gt){
    		  int cmp = v.compareTo(a[i]);
    		  if(cmp > 0) exch(a,i++,it++);
    		  else if(cmp < 0) exch(a,i,gt--);
    		  else i++;
    	  }
    	  fastsort(a,lo,it-1);
    	  fastsort(a,gt+1,hi);
      }
      private static int partition(Comparable[] a,int lo,int hi){
    	  Comparable v ;//;= //new Comparable();
    	  int i = lo, j = hi+1;
    	  if(hi-lo<2){
    		  v = a[lo];
    	  }
    	  else{
    		 selectionsort(a,lo,lo+2);
    		 exch(a,lo,lo+1);
    		 v = a[lo]; 
    	  }
    	  while(true){
    	  while(less(a[++i],v)) if(i == hi) break;
    	  while(less(v,a[--j])); //if(j == lo) break;
    	  if (i>=j) break;
    	  exch(a,i,j);
    	 }
    	  exch(a,lo,j);
    	  return j;
    	
    	  
     }
      
      private static void findlargest(Comparable[] a){
    	 int larger = 0;
    	 for(int i = 0 ; i<a.length ; i++){
    		 if(less(a[larger],a[i])) larger = i;
    	 }
    	 exch(a,larger,a.length-1);
      }
      private static boolean less(Comparable a,Comparable b){
    	  return a.compareTo(b)<0;
      }
      private static void exch(Comparable[]a,int i,int j){
    	  Comparable temp = a[i];
    	  a[i] = a[j];
    	  a[j] = temp;
      }
      private static void selectionsort(Comparable[]a,int lo ,int hi){
    	  for(int j =lo;j<=hi;j++){
    	  int larger = j;
    	  for(int i =j+1;i<=hi;i++){
    		  if(less(a[larger],a[i])) larger = i;
    	  }
    	  exch(a,larger,j);
    	 }
    	  
    	  
      }
      public static void main(String[] args){
    	 Double[] a = new Double[]{4.0,6.0,2.0,8.0,1.0,5.5,9.6};
    	 sort(a);
    	 for(int i =0 ; i<a.length;i++){
    		 System.out.print(a[i]+",");
    	 }
      }
}
