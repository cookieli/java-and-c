package com.lizhengxian.mergesort;
public class Merge {
     private static Comparable[] aux;
     public static double TD_cnt = 0;
     public static double DU_cnt = 0;
     public static void TopDown(Comparable[] a){
    	 aux = new Comparable[a.length];
    	 TDsort(a,0,a.length-1);
     }
     public static void DownTop(Comparable[] a){
    	int N = a.length;
    	aux = new Comparable[N];
    	for(int sz =1;sz<N-sz;sz =sz+sz){//sz代表子数组容量大小
    		for(int lo=0;lo<N-sz;lo+=sz+sz-1){
    			merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
    		}
    	}
    	 
     }
     
     private static void TDsort(Comparable[] a,int lo,int hi){
    	 if(lo>= hi) return;
    	 int mid = lo+(hi-lo)/2;
    	 TDsort(a,lo,mid);
    	 TDsort(a,mid+1,hi);
    	 merge(a,lo,mid,hi);
     }
     public static void merge(Comparable[] a,int lo,int mid,int hi){
    	
    	 int i = lo, j = mid+1;
    	 for(int k=lo;k<=hi;k++){
    		 aux[k] = a[k];
    		 TD_cnt+=2;
    	 }
    	 for(int k =lo;k<=hi;k++){
    		 if(i>mid) a[k] = aux[j++];
    		 else if(j>hi) a[k] = aux[i++];
    		 else if(less(aux[i],aux[j])) {a[k] =aux[i++];TD_cnt+=2;}
    		 else {a[k] = aux[j++];TD_cnt+=2;}
    		 TD_cnt+=2;
    	 }
     }
     public static boolean less(Comparable a,Comparable b){
    	 return a.compareTo(b)<0;
     }
}
