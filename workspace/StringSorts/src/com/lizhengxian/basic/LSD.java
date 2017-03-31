package com.lizhengxian.basic;

import edu.princeton.cs.algs4.StdIn;

public class LSD {
    private LSD(){}
    public static void sort(String[] a ,int w){
    	int N = a .length;
    	int R = 256;
    	String[] aux = new String[N];
    	for(int d = w - 1 ;d >= 0 ;d-- ){
    		int[] count = new int[R+1];
    		for(int i = 0 ; i <N; i++){
    			count[a[i].charAt(d)+1]++;
    		}
    		for(int r  = 0 ; r < R ;r++){
    			count[r+1]+= count[r];
    		}
    		for(int i = 0 ; i<N ;i++){
    			aux[count[a[i].charAt(d)]++] = a[i];
    		}
    		for(int i = 0 ; i< N ;i++){
    			a[i] = aux[i];
    		}
    	}
    }
    public static void main(String[] args){
    	String[] a = StdIn.readAllStrings();
        int n = a.length ; 
        System.out.println();
        System.out.println(n);
        int w = a[0].length();
        sort(a,w);
        System.out.println();
        System.out.println(a.length);
        //System.out.println(a[0]+a[1]+a[2]);
    }
}
