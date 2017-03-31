package com.lizhengxian.creativeproblem;

public class FasterMerge{
	   //private static Comparable[] aux;
	   public static void sort(Comparable[] aux,Comparable[] a,int lo,int hi){
	    	 if(lo>=hi) return;
	    	 int mid = lo+(hi-lo)/2;
	    	 sort(aux,a,lo,mid);
	    	 sort(aux,a,mid+1,hi);
	    	 fastMerge(aux,a,lo,mid,hi);
	     }
       public static void fastMerge(Comparable[]aux,Comparable[]a,int lo,int mid,int hi){
    	   int i = lo,j=hi;
    	   for(int k =0; k<=mid;k++){
    		   aux[k] = a[k];
    	   }
    	   for(int k=hi,n=mid+1;k>=mid+1;k--){
    		   aux[n++] = a[k];
    	   }
    	   for(int k = lo; k <= hi; k++){
    		   if(less(aux[i],aux[j])) a[k] = aux[i++];
    		   else                    a[k] = aux[j--];
    	   }
    	   
       }
       public static boolean less(Comparable a,Comparable b){
      	 return a.compareTo(b)<0;
       }
}
