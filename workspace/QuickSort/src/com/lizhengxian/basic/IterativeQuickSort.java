package com.lizhengxian.basic;

import edu.princeton.cs.algs4.Stack;

public class IterativeQuickSort {
	public static void iterativeSort(Comparable[] a){
		sort(a,0,a.length-1);
	}
	private static int partition(Comparable[] a,int lo,int hi){
		Comparable v = a[lo];
		int i = lo, j = hi+1;
		while(true){
			while(less(a[++i],v)){if(i==hi)break;}
			while(less(v,a[--j])){if(j==lo)break;}
			if(i>=j) break;
			exch(a,i,j);	
		}
		    exch(a,j,lo);
		    return j;
	}
	private static void sort(Comparable[] a,int lo,int hi){
		if(lo>=hi) return;
		Stack<Integer> st = new Stack<Integer>();
		if(hi>lo){
			int middle = partition(a,lo,hi);
			if((middle-lo)>(hi-middle)){
				if(lo<middle){
					st.push(lo);
					st.push(middle);
				}
				if(middle+1<hi){
					st.push(middle+1);
					st.push(hi);
				}
			}
			else{
				if(middle+1<hi){
					st.push(middle+1);
					st.push(hi);
				}
				if(lo<middle){
					st.push(lo);
					st.push(middle);
				}
			}
			while(!st.isEmpty()){
				int tail = st.pop();
				int head = st.pop();
				int mid = partition(a,head,tail);
				if(head<mid){
				st.push(head);
				st.push(mid);
				}
				if(mid+1<tail){
				st.push(mid+1);
				st.push(tail);
				}
			}	
		}
	}
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;	
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
     public static void main(String[] args){
    	 Double[] a = new Double[]{4.0,6.0,2.0,8.0,1.0,5.5,9.6};
    	 iterativeSort(a);
    	 for(int i =0 ; i<a.length;i++){
    		 System.out.print(a[i]+",");
    	 }
     }
}
