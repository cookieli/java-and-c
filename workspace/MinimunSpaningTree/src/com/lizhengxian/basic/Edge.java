package com.lizhengxian.basic;

public class Edge implements Comparable<Edge> {
	private int v;
	private final int w;
	private final double weight;
	public Edge(int v, int w, double weight){
		this.v = v ;
		this.w = w ;
		this.weight = weight ;
	}
	public int either(){
		return this.v ;
	}
	public int other(int v){
		if(v==this.v) return this.w ;
		else          return this.v ;
	}
    public double weight(){	
    	return this.weight;
    }
    public String toString(){
    	String a = " "+ this.v +"-" +this.w +":"+this.weight;
    	return a;
    }
    
	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		if(this.weight()>that.weight())      return +1;
		else if(this.weight()<that.weight()) return -1;
		else                                 return  0;
	}

}
