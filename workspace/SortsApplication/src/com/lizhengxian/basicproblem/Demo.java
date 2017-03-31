package com.lizhengxian.basicproblem;

public class Demo {
     /**
     * @param args
     */
    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args){
    	 //String[] a = new String[]{"a","b","c","d","w"};
    	int[] a = new int[]{1,2,3,4,5,6};
    	int x =1;
    	int y =2;
    	 exch(x,y);
//    	 for(int i =0;i<a.length;i++){
//    		 System.out.print(a[i]+",");
//    	 }
    	 System.out.println(x);
    	 System.out.println(y);
     }
     public static void exch(int a,int b){
    	 int temp = a;
    	 a = b;
    	 b = temp;
     }
}
