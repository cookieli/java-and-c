package com.lizhengxian.creativeproblem;

public class NatualMerge {
     private static int[] rec;
     private static Comparable[] aux;
     public static void mergeSort(Comparable[] a){
    	 int N = a.length;
    	 rec = new int[N];
    	 aux = new Comparable[N];
    	 int num = pass(a);
    	 while(num != 2){
    		 for(int i = 0;i < num-2 ; i+=2){
              merge(a,rec[i],rec[i+1]-1,rec[i+2]-1);
    		 }
    		 num = pass(a);
    	 }
    	 
     }
     private static void merge(Comparable[] a,int lo,int mid,int hi){
    	 int N = a.length;
    	 int i = lo;
    	 int j = mid + 1;
    	 for(int n = 0; n<N ; n++){
    		 aux[n] = a[n];
    	 }
    	 for(int n = lo;n <= hi;n++ ){
    		 if(i>mid)                    a[n] = aux[j++];
    		 else if(j>hi)                a[n] = aux[i++];
    		 else if(less(aux[i],aux[j])) a[n] = aux[i++];
    		 else                         a[n] = aux[j++];
    	 }
    	 
     }
     
     private static int pass(Comparable[]a){//扫描数组找到有序子数组
    	 int N = a.length;
    	 int num = 0;
    	 Comparable bigger = a[0];
    	 rec[num++] = 0;
    	 for(int i =1 ; i<N ;i++){
    		 if(less(bigger,a[i])||bigger.equals(a[i])) bigger = a[i];
    		 else{
    			 bigger = a[i];
    			 rec[num++] = i;
    		 }
    	 }
    	 //if(rec[num]==N) return num;
    	// else{
    		 rec[num++] = N;
    	// }
    	 return num;	 
     }
     
     public static boolean less(Comparable a,Comparable b){
      	 return a.compareTo(b)<0;
       }
     public static void main(String[] args){
    	 Double[] a = new Double[]{3.0,2.0,3.0,4.0,8.0,9.0,4.0};
    	 mergeSort(a);
    	 for(int i = 0; i< a.length; i++){
    		 System.out.print(a[i] + ",");
    	 }
     }
}
