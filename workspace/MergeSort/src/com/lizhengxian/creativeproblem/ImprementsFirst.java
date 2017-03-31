package com.lizhengxian.creativeproblem;

public class ImprementsFirst {
      public static void sort(Comparable[]aux,Comparable[]a,int lo,int hi){
    	  if(lo>=hi) return ;

    	 
    		  int mid = lo+(hi-lo)/2;
    		  sort(a,aux,lo,mid);
    		  sort(a,aux,mid+1,hi);
    		  merge(aux, a, lo, mid, hi);
    }
      private static void insectionSort(Comparable[] a){
    	  int N = a.length;
    	  for(int i = 1;i<N;i++){
    		  for(int j = i;j>0&&less(a[j],a[j-1]);j--){
    			  exch(a,j,j-1);
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
      public static void merge(Comparable[] aux,Comparable[] a,int lo,int mid,int hi){
      	
     	 int i = lo, j = mid+1;
//     	for(int k =lo;k<=hi;k++){
//     		aux[k] = a[k];
//     	}
     	 for(int k =lo;k<=hi;k++){
     		 if(i>mid) a[k] = aux[j++];
     		 else if(j>hi) a[k] = aux[i++];
     		 else if(less(aux[i],aux[j])) {a[k] =aux[i++];}
     		 else {a[k] = aux[j++];}
     	   }
     	     // a=aux;
     	 }
}
