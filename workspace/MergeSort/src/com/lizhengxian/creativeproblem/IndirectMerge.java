package com.lizhengxian.creativeproblem;

public class IndirectMerge {
	 private static int[] perm;
	 private static int[] permaux;
     public static void merge(Comparable[]a,int lo,int mid,int hi){
    	 int n = lo, m = mid+1;
    	 for(int i=lo;i<=hi;i++){
    		 if(n>mid)                            perm[i] = permaux[m++];
    		 else if(m>hi)                        perm[i] = permaux[n++];
    		 else if(less(a[permaux[n]],a[permaux[m]]))             perm[i] = permaux[n++];
    		 else                                 perm[i] = permaux[m++];
    	 }
    	 for(int i =0 ; i<=hi ; i++){
    		 permaux[i] = perm[i];
    	 }
     }
     public static void mergesort(Comparable[]a){
    	 int N = a.length;
    	 perm = new int[N];
    	 permaux = new int[N];
    	 for(int i =0 ; i<N ; i++){
    		 perm[i] = i;
    		 permaux[i] = i;
    	 }
    	 sort(a,0,N-1);
     }
     public static void sort(Comparable[]a,int lo,int hi){
    	 if(hi<=lo) return;
    	 int mid = lo +(hi-lo)/2;
    	 sort(a,lo,mid);
    	 sort(a,mid+1,hi);
    	 merge(a,lo,mid,hi);
     }
     
     public static boolean less(Comparable a,Comparable b){
      	 return a.compareTo(b)<0;
       }
     public static void main(String args[]){
    	 Double[] a = new Double[]{3.0,2.0,1.0,4.0,8.0,5.0,6.0,4.4,3.0,9.0};
    	 mergesort(a);
    	 for(int i =0 ;i<a.length;i++){
    		 System.out.print(perm[i]+",");
    		
    	 }
    	 System.out.println();
    	 for(int i =0 ;i<a.length;i++){
    		 System.out.print(a[i]+",");
    		
    	 }
     }
}
