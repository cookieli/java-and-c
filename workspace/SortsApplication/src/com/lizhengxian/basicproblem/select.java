package com.lizhengxian.basicproblem;

public class select {
        private static void exch(Comparable[] a,int i,int j){
        	Comparable temp = a[i];
        	a[i] = a[j];
        	a[j] = temp;
        }
        private static boolean less(Comparable a,Comparable b){
        	return a.compareTo(b)<0;
        }
        private static int partition(Comparable[]a,int lo,int hi){
        	int i =lo;
        	int j = hi+1;
        	Comparable v = a[lo];
        	while(true){
        		while(less(a[++i],v)) {if(i==hi) break;}
        		while(less(v,a[--j])) {if(j==lo) break;}
        		if(i>=j) break;
        		exch(a,i,j);
        	}
        	exch(a,lo,j);
        	return j;
        }
       public static Comparable select(Comparable[]a,int k,int lo,int hi){
    	   if(lo==hi&&lo==k) {return a[lo];
    	   
    	   }
    	   int j = partition(a,lo,hi);
    	   if(j==k) return a[j];
    	   else if(j>k)  return select(a,k,lo,j-1);
    	   else return select(a,k,j+1,hi);
       }
       public static void main(String[]args){
    	   Integer[] s = new Integer[]{29,5,33,3,7,66};
    	   System.out.println((Integer)select((Comparable[])s,2,0,5));
    	 //  select((Comparable[])s,3,0,5);
    	   
       }
}