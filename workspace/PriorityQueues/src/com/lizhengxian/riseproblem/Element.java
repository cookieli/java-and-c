package com.lizhengxian.riseproblem;

public class Element<T> {
      public T key;
      public void setpoint(Element<T> e){
    	  this.key = e.key;
      }
      public static void main(String[]args){
    	  Element<String> one = new Element<String>();
    	  Element<String> two = new Element<String>();
    	  one.setpoint(two);
    	  two.setpoint(one);
    	  two.key = "a";
    	  System.out.println(one.key);
      }
}
