package com.lizhengxian.basic;

public class CyclicRotationCheck {
      public static  boolean check(String s,String t){
    	  if(s.length()==t.length()&&(s+t).contains(s))   return true;
    	  else                                            return false;
      }
      public static void main(String[] args){
    	  System.out.println(check("example","ampleexle"));
      }
}
