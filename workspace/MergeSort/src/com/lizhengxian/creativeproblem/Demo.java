package com.lizhengxian.creativeproblem;

import com.lizhengxian.mergesort.ImprovementMerge;

public class Demo {
	 public static void main(String args[]){
    	 Double[] a=new Double[]{7.0,3.0,5.5,9.9,2.5,4.4,7.7,9.9};
    	 Double[] aux=new Double[a.length];
    	 for(int i=0;i<a.length;i++){
    		 aux[i] = a[i];
    	 }
    	 ImprementsFirst.sort(aux, a, 0, a.length-1);
    	 for(int i=0;i<a.length;i++){
    		 System.out.print(a[i]+" ");
    	 }
     }
}
