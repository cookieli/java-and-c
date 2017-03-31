package com.lizhengxian.riseproblem;

import edu.princeton.cs.algs4.MinPQ;

public class CubeSum implements Comparable<CubeSum>{
    private final long sum ;
    private final long i;
    private final long j;
    public CubeSum(long i,long j){
    	this.sum = i*i*i+j*j*j;
    	this.i = i;
    	this.j =j;
    }
    public String toString(){
    	return sum+"="+ i +"+"+ j;
    }
	@Override
	public int compareTo(CubeSum that) {
		// TODO Auto-generated method stub
		if(this.sum<that.sum) return -1;
		if(this.sum>that.sum) return  1;
		else                  return  0;
	}
	public static void main(String[]args){
		MinPQ<CubeSum> math = new MinPQ<CubeSum>();
		int N = (int)Math.pow(10, 6);
		for(int i = 0 ;i<Math.pow(10, 6);i++){
			math.insert(new CubeSum(i, 0));
		}
		while(!math.isEmpty()){
			CubeSum s =math.delMin();
			System.out.println(s);
			if(s.j<N){
				math.insert(new CubeSum(s.i,s.j+1));
			}
		}
	}
	
     
}
