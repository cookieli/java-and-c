package com.lizhengxian.myonelist;

public class MyThread2 extends Thread{
	 private MyOneList list;
     public MyThread2(MyOneList list){
   	  this.list =list;
     }
     public void run(){
   	  MyService msRef = new MyService();
   	  msRef.addServiceMethod(list,"A");
     }
}