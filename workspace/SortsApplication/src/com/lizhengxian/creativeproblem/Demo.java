package com.lizhengxian.creativeproblem;

public class Demo {
     public static void main(String[]args){
    	 Integer[] a = new Integer[5];
    	 Integer b[] = new Integer[a.length];
    	 a[0] = new Integer(1);
    	 a[1] = new Integer(1);
    	 a[2] = new Integer(3);
    	 a[3] = new Integer(4);
    	 a[4] = new Integer(5);
    	 for(int i =0;i<b.length;i++){
    		 b[i] = a[i];
    	 } 
    	 System.out.println(a[0]==b[0]);
     }
}
