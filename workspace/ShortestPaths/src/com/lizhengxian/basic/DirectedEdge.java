package com.lizhengxian.basic;

public class DirectedEdge {
     private final int v;
     private final int w;
     private final double weight;
     public DirectedEdge(int v,int w,double weight){
    	 this.v = v ;
    	 this.w = w ;
    	 this.weight = weight ;
     }
     public int from(){
    	 return this.v ;
     }
     public int to(){
    	 return this.w ;
     }
     public double weight(){
    	 return this.weight;
     }
     public String toString(){
    	 return String.format("%d->%d %.2f",v,w,weight);    }
     public static void main(String[]args){
    	 DirectedEdge d = new DirectedEdge(1,0,0.0 );
    	 System.out.println(d.from());
    	 System.out.println(d.to());
    	 System.out.println(d.weight());
    	 System.out.println(d.toString());
     }
}
