package com.lizhengxian.creativeproblem;

import com.lizhengxian.mergesort.Merge;

import edu.princeton.cs.algs4.Insertion;

public class SublinearExtraSpace {
	   
	   private static Comparable[] aux;
	   
       public static void sort(Comparable[]a,int M){//M需要取约数
    	   int N = a.length;
    	   int size = Math.max(N/M, M);
    	   aux = new Comparable[size];
    	   for(int i = 0; i <=N-M;i+=M){
    		   for(int j = i ; j < i+M ; j++){
    			 Insertion.sort(a, i, j);
    		   }
    	   }
    	   selection(a,M);
    	   for(int i = 0;i<N-M;i+=M){
    	     merge(a,aux,i,M);
    	   }
    	   
       }
       public static void merge(Comparable[]a,Comparable[]aux,int firstindex,int M){
    	   int i = firstindex,j = firstindex + M - 1;
    	   int k = j+M , n = j+1;
    	   arraycopy(a,i,j,aux);
    	   int temp = 0;
    	   while(i<=k){
    		   if(n>k)                       a[i++] = aux[temp++];
    		   else if(temp ==aux.length)    a[i++] = a[n++];
    		   else if(less(aux[temp],a[n])) a[i++] = aux[temp++];
    		   else                          a[i++] = a[n++];
    	   }  
       }
       public static void arraycopy(Comparable[]a,int i,int j,Comparable[]aux){
    	   for(int n = i,m=0; n<= j;n++){
    		   aux[m++] = a[n];
    	   }
       }
       public static void selection(Comparable[] a,int M){
    	   for(int i = 0; i<a.length;i+=M){
    		   int min = i;
    		   for(int j = i+M;j<a.length;j+=M){
    			   if(less(a[j],a[min])) min = j;
    		   }
    		   for(int n = i;n<i+M;n++){
    			   exch(a,min,n);
    			   min++;
    		   }
    		   
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
       public static void main(String args[]){
    	   Double[] a = new Double[]{3.0,2.0,5.0,1.0};
    	   int N = a.length;
    	   int M = 2;
    	   int size = Math.max(N/M, M);
    	   aux = new Comparable[size];
    	   for(int i = 0; i <=N-M;i+=M){
    		   for(int j = i ; j < i+M ; j++){
    			 Insertion.sort(a, i, j);
    		   }
    	   }
    	   selection(a,M);
    	  // for(int i = 0;i<N-M;i+=M){
      	     merge(a,aux,0,M);
      	  // }
      	   
    	  
    	   for(int i = 0;i<a.length;i++){
    		   System.out.print(a[i]+",");
    	   }
       }
       
}
