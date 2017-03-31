package com.lizhengxian.creativeproblem;

public class Domain {
     /**
     * @param args
     */
    public static void main(String args[]){
    	 String s = "cs.princeton.edu";
    	 String[] a =s.split(".");
    	for(int i=0;i<a.length;i++){
    		System.out.println(a[i]);
    	}
     }
}
