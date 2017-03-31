package com.Algorithms.rise;

public class TwoStacks<T> {
       private Deque<T> de; //= new Deque<T>();
       int leftStack = 0;
       int rightStack = 0; 
       public TwoStacks(){
    	   de = new Deque<T>();
       }
       public void push1(T item){
    	   de.pushLeft(item);
    	   leftStack++;
       }
       public T pop1(){
    	   if(leftStack>0) 
    		   {
    		     leftStack--;
    		     return de.popLeft();
    		   }
    	   else 
    		   System.out.println("LeftStack is Empty!!!");
    	       return null;
       }
       public void push2(T item){
    	   de.pushRight(item);
    	   rightStack++;
    	   
       }
       public T pop2(){
    	   if(rightStack>0){
               rightStack--;    		   
              return de.popRight();
    	   }
    	   else
    		   System.out.println("RightStack is Empty");
    	       return null;
       }
       public static void main(String args[]){
    	     TwoStacks<Integer> two = new TwoStacks<Integer>();
    	     two.push1(1);
    	     two.push1(2);
    	     two.pop2();
       }
}
