package com.lizhengxian.mergesort;

public class ImproveDemo {
     public static void main(String args[]){
    	 Double[] a=new Double[]{7.0,3.0,4.0,5.0};
    	 Double[] aux=new Double[a.length];
    	 for(int i =0;i<a.length;i++){
    		 aux[i] = a[i];
    	 }
    	 ImprovementMerge.sort(aux, a, 0, a.length-1);
    	 for(int i=0;i<a.length;i++){
    		 System.out.print(a[i]+" ");
    	 }
     }
}
