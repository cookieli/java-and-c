package com.lizhengxian.basic;

public class Heap {
	
	public static void sort(Comparable[]a){
		int N = a.length;
		//´´½¨¶Ñ
		for(int k =N/2;k>=1;k--){
			sink(a,k,N);
		}
		while(N>1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	private static void anotherSink(Comparable[]a,int k,int n){
		
	}
	private static void sink(Comparable[]a, int k,int n){
		while(2*k<=n){
			int j = 2*k;
			if(j<n&&less(a,j,j+1)) j++;
			if(!less(a,k,j)) break;
			exch(a,k,j);
			k = j;
		}
	}
	public static void exch(Comparable[]a,int i,int j){
		Comparable temp = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = temp;
	}
	private static boolean less(Comparable v,Comparable n){
		return v.compareTo(n)<0;
	}
	private static boolean less(Comparable[] pq,int i,int j){
		return pq[i-1].compareTo(pq[j-1])<0;
	}
   public static void main(String args[]){
	   Double[] a =new Double[]{3.0,5.0,1.0,7.0,4.0,2.0,99.0,74.0};
	   Heap.sort(a);
	   for(int i =0;i<a.length;i++){
		   System.out.print(a[i]+",");
	   }
   }
}
