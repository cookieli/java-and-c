package com.lizhengxian.mergesort;

import edu.princeton.cs.algs4.StdDraw;

public class Demo {
	public static Comparable[] a;
	public static double[] TDrecord = new double[512];
	public static double[] DUrecord = new double[512];
    public static void record(){
    	for(int N=1;N<=512;N++){
    		Merge.TD_cnt = 0;
    		//DownUp.DU_cnt = 0;
    		a = new Comparable[N];
    		for(int i=0;i<N;i++){
    			a[i] =(Double)Math.random(); 
    		}
    		Merge.TopDown(a); 
    		//DownUp.DownUp(a);
    		TDrecord[N-1] = Merge.TD_cnt;
    		//DUrecord[N] = Merge.DU_cnt;
    	}
    }
    public static void drawTrace(){
    	StdDraw.setXscale(0,512);
    	StdDraw.setYscale(0,24576);
    	StdDraw.setPenRadius(0.001);
    	StdDraw.setPenColor(StdDraw.BLACK);
    	for(int i=0;i<512;i++){
    		StdDraw.point(i, TDrecord[i]);
    	}
    	StdDraw.setPenColor(StdDraw.RED);
    	for(int i=0;i<512;i++){
    		StdDraw.point(i, 6*i*Math.log(i)/Math.log(2));
    	}
    	
    }
    public static void main(String args[]){
    	record();
    	drawTrace();
    }
}
