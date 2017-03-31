package com.lizhengxian.service;

import com.lizhengxian.mylist.MyList;

public class ThreadB extends Thread{
	 private ObjectService service;
	 private Task task;
	 private MyList list;
     public ThreadB(){}
     public ThreadB(ObjectService service){
  	   this.service = service;
     }
     public ThreadB(Task task){
    	 this.task=task;
     }
     public ThreadB(MyList list){
  	   this.list = list;
     }
     public void run(){
    	 for(int i=0;i<100000;i++)
   	  {
   		  list.add("threadB"+(i+1));
   	  }
     }
}
