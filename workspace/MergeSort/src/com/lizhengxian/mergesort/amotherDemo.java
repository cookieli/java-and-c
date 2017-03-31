package com.lizhengxian.mergesort;

public class amotherDemo {
     public static void main(String args[]){
          Double[] a = new Double[]{ 17.0,2.0};
          Merge.TopDown(a);
          for(int i=0;i<a.length;i++){
        	  System.out.print(a[i]+"´ÎÊý "+Merge.TD_cnt+",");
          }
          //System.out.println(DownUp.DU_cnt);
     }
}
