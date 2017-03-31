package com.lizhengxian.basicproblem;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Combination {
	  public static void quicksort(String[] a){
		 StdRandom.shuffle(a);
		 sort(a,0,a.length-1);
	  }
	  private static void sort(String[] a,int lo,int hi){
		  if(lo>=hi) return;
		  int j = partition(a,lo,hi);
		  sort(a,lo,j-1);
		  sort(a,j+1,hi);
	  }
	  private static int partition(String[] a,int lo,int hi){
		  int i = lo, j = hi+1;
		  String v = a[lo];
		  while(true){
			  while(less(a[++i],v)) {if(i==hi) break;}
			  while(less(v,a[--j])) {if(j==lo) break;}
			  if(i>=j) break;
			  exch(a[i],a[j]); 
		  }
		     exch(a[lo],a[j]);
		     return j;
	  }
	 
	  private static void exch(String a,String b){
		  String temp = a;
		  a = b;
		  b = temp;
	  }
	  private static boolean less(String a,String b){
		  return a.compareTo(b)<0;
	  }
	  public static String[] dedup(String[] a){
		  int N = a.length;
		  quicksort(a);
		  for(int i = 1;i<a.length;i++){
			  if(a[i].compareTo(a[i-1])==0) {
				  exch(a[i],a[a.length-1]);
				  a[a.length-1] = null;
				  N--;
			  }
		  }
		  String[] b = new String[N];
		  for(int i =0;i<N;i++){
			  b[i] =a[i];
		  }
		  quicksort(b);
		  return b;
		  
	  }
      public static void main(String[]args){
    	  Double a;
    	  String[] s = new String[]{"after","thought","thought","afterthought"};
    	 // quicksort(s);
    	 String[]str= dedup(s);
    	 // Arrays.sort(s);
    	  for(int i=0;i<str.length;i++){
    		  System.out.println(str[i]);
    	  }
    	  //System.out.println(combinate(1,s[1],s,s[1].length()));
    	 
    	  
      }
      //写一个函数，判断一个单词是否由处于同一数组的其他俩个单词组成
      //用递归处理
     
    public static boolean combinate(int n,String a,String[]b,int len){
        if (len == 0) return true;
        for(int i = 1;i<=len;i++){
        	//if(i==len) return false;
        	String temp = a.substring(0,i);
        	for(int j = 0;j<b.length;j++){
        		if(temp.equals(b[j])&&j!=n) return combinate(n,a.substring(i),b,a.substring(i).length());
        	}
        }
        return false;
       // return combinate(a.substring(cnt),b,a.substring(cnt).length());
        
           
      }
	
      
}
