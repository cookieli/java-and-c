package com.lizhengxian.mergesort;

public class DownUp {
	 private static Comparable[] aux;
     public static int DU_cnt = 0;
     public static void sorts(Comparable[] a){
    	 int N = a.length;
    	 aux= new Comparable[N];
    	 for(int sz=1;sz<N-sz;sz=sz+sz){
    		 for(int lo=0;lo<N-sz+1;lo+=sz+sz){
    			 merge(a,lo,lo+sz-1,Math.min(N-1, lo+sz+sz-1));
    		 }
    	 }
     }
     public static void merge(Comparable[] a,int lo,int mid,int hi){
    	   int i =lo,j =mid+1;
    	   for(int k =lo;k<=hi;k++){
    		   aux[k] = a[k];
    		   DU_cnt+=2;
    	   }
    	   for(int k =lo;k<=hi;k++){
    		   if(i>mid) {a[k]=aux[j++];} 
    		   else if(j>hi) {a[k]=aux[i++];}
    		   else if(less(a[i],a[j])) {a[k]=aux[i++];DU_cnt+=2;}
    		   else {a[k]=aux[j++];}
    		   DU_cnt+=2;
    		   
    		   
    	   }
    			   
     }
     public static boolean less(Comparable a,Comparable b){
    	 return a.compareTo(b)<0;
     }
}

