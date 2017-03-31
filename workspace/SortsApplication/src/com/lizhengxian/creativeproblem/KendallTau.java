package com.lizhengxian.creativeproblem;

public class KendallTau {
    public static void main(String[] args){
    	int[] a= new int[]{0,3,1,6,2,5,4};
    	int[] b= new int[]{1,0,3,6,4,2,5};
    	int[] aIndex = new int[a.length];
    	int[] bIndex = new int[a.length];
    	for(int i =0;i<a.length;i++){
    		aIndex[a[i]] = i;
    	}
    	for(int i =0;i<b.length;i++){
    		bIndex[i] =aIndex[b[i]];
    	}
    	for(int i=0;i<bIndex.length;i++){
    		System.out.print(bIndex[i]+",");
    	}
    	
    }
}
