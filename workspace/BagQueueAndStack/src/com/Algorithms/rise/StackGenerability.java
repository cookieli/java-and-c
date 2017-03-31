package com.Algorithms.rise;

import edu.princeton.cs.algs4.Stack;

public class StackGenerability {
       Stack<Integer> stack = new Stack<Integer>();
       public boolean isGenera(int pushData[],int popData[]){
    	   for (int i=0,j=0;i<pushData.length;i++){
    		   stack.push(pushData[i]);
    		   while(!stack.isEmpty()&&stack.peek()==popData[j]){
    			   stack.pop();
    			   j++;
    		   }
    	   }
    	   if(stack.isEmpty()) return true;
    	   else return false;   
       }
       public static void main(String args[]){
    	   StackGenerability st = new StackGenerability();
    	   int[] pushData = new int[]{1,2,3,4,5,6,7,8,9};
    	   int[] popData = new int[]{3,1,2,4,5,7,6,8,9};
    	   System.out.println(st.isGenera(pushData,popData));
       }
}
