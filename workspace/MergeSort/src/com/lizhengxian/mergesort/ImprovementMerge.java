package com.lizhengxian.mergesort;

public class ImprovementMerge {
     public static void sort(Comparable[] aux,Comparable[] a,int lo,int hi){
    	 if(lo>=hi) return;
    	 int mid = lo+(hi-lo)/2;
    	 sort(aux,a,lo,mid);
    	 sort(aux,a,mid+1,hi);
    	 merge(aux,a,lo,mid,hi);
     }
     private static void merge(Comparable[] aux,Comparable[] a,int lo,int mid,int hi){
    	 int i = lo,j = mid+1;
    	for(int k=lo;k<=hi;k++){
    		if(i>mid)     a[k] = aux[j++];
    		else if(j>hi) a[k] = aux[i++];
    		else if(less(aux[j],aux[i])) a[k]=aux[j++];
    		else          a[k]=aux[i++];   
    	}
     }
     public static boolean less(Comparable a,Comparable b){
    	 return a.compareTo(b)<0;
     }
}
