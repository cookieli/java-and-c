package com.lizhengxian.myonelist;

public class MyThread1 extends Thread{
      private MyOneList list;
      public MyThread1(MyOneList list){
    	  this.list =list;
      }
      public void run(){
    	  MyService msRef = new MyService();
    	  msRef.addServiceMethod(list,"A");
      }
}
