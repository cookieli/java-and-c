package com.lizhengxian.service;

public class ObjectService {
     public void serviceMethod(){
    	 synchronized(this){
    		 try {
    			 System.out.println("begin time="+System.currentTimeMillis());
				 Thread.sleep(2000);
				 System.out.println("end time="+System.currentTimeMillis());
				 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    	 }
     }
}
