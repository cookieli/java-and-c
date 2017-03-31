package com.lizhengxian.riseproblem;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

public class MedianFinding <Key extends Comparable<Key>>{
       private MaxPQ<Key> low;//存放小于中位数的数
       private MinPQ<Key> high;//存放大于中位数的数
       private Key medianlow;
       private Key medianhigh;
       private int N = 0;
       public MedianFinding(){
    	   low = new MaxPQ<Key>();
    	   high = new MinPQ<Key>();
       }
       public boolean isEmpty(){
    	   return N == 0;
       }
       public int size(){
    	   return N;
       }
       public void insert(Key item){
    	   //添加第一个元素时
    	   if(N==0)
    	   medianlow = item;
    	   //添加第二个元素时
    	   else  if(N==1)
    	   medianhigh = item;
    	   //添加第奇数个元素时
    	   else if(N%2==0){
    	   if(item.compareTo(medianlow)>0&&item.compareTo(medianhigh)<0){
    		   Key temp1 = medianhigh;
    		   Key temp2 = medianlow;
    		   low.insert(temp2);
    		   low.insert(temp1);
    		   medianhigh = null;
    		   medianlow = item;
    	   }
    	   else if(item.compareTo(medianlow)<=0){
    		   low.insert(item);
    		   Key temp1 = medianhigh;
    		   high.insert(temp1);
    		   medianhigh = null;
    	   }
    	   else if(item.compareTo(medianhigh)>=0){
    		   high.insert(item);
    		   Key temp2 = medianlow;
    		   Key temp1 = medianhigh;
    		   low.insert(temp2);
    		   medianlow = temp1;
    		   medianhigh = null;
    	   }
        }
    	 //添加第偶数个元素时
    	   else{
    		   Key templow = low.max();
    		   Key temphigh = high.min();
    		   if(item.compareTo(templow)<0){
    			   medianhigh = medianlow;
    			   medianlow = low.delMax();
    			   low.insert(item);
    		   }
    		   else if(item.compareTo(temphigh)>0){
    			   medianhigh = high.delMin();		
    			   high.insert(item);
                 }
    		   else if(item.compareTo(templow)>0&&item.compareTo(medianlow)<0){
    			   medianhigh =  medianlow;
    			   medianlow  = item;
    		   }
    		   else if(item.compareTo(temphigh)<0&&item.compareTo(medianlow)>0){
    			   medianhigh =  item;
    		   }
    	   }
    	   N++;
     }
       public Double findmedian(){
    	   if(medianhigh==null){
    		   return (Double) medianlow;
    	   }
    	   else {
    		   return ((Double)medianlow+(Double)medianhigh)/2;
    	   }
       }
       public Double delMedian(){
    	   //如果有奇数个元素
    	   if(N%2==1){
    	   Double median = (Double)medianlow;
    	   Key templow = low.delMax();
    	   Key temphigh = high.delMin();
    	   medianhigh = temphigh;
    	   medianlow = templow;
    	   N--;
    	   return median;
    	}
    	   //如果有偶数个元素
    	   else{
    			   Double median =((Double) medianlow + (Double) medianhigh)/2;
    			   medianhigh = null;
    			   N--;
    			   return median;
    	   }
       }
       public static void main(String[]args){
    	   MedianFinding<Double> MF = new MedianFinding<Double>();
    	   MF.insert(3.0);
    	   MF.insert(4.0);
    	   MF.insert(5.0);
    	   MF.insert(2.0);
    	   System.out.println(MF.delMedian());
    	   System.out.println(MF.findmedian());
    	   System.out.println(MF.size());
       }
}
