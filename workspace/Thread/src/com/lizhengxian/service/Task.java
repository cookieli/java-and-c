package com.lizhengxian.service;

public class Task {
      private String getData1;
      private String getData2;
      public void doLongTask(){
      for(int i=0;i<100;i++)
      {
    	  System.out.println("nosynchronized threadName="+
          Thread.currentThread().getName()+"i="+(i+1));
    	  System.out.println("");
    	  synchronized(this){
    		  for(int j=0;j<100;j++){
    			  System.out.println("synchronized thread Name="
    					            +Thread.currentThread().getName()+"j="+(j+1));
    		  }
    	  }
      }
      }
}
