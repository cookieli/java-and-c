package com.lizhengxian.collection;

public class Demo {
       public static void main(String args[]){
    	   StackList<String> sl =new StackList<String>();
    	   sl.push("a");
    	   System.out.println(sl.size());
    	   System.out.println(sl.pop());
    	   System.out.println(sl.isEmpty());
       }
}
