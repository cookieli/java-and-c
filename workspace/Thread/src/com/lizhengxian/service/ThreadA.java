package com.lizhengxian.service;

import com.lizhengxian.mylist.MyList;

public class ThreadA extends Thread{
       private ObjectService service;
       private Task task;
       private MyList list;
       public ThreadA(){}
       public ThreadA(ObjectService service){
    	   this.service = service;
       }
       public ThreadA(Task task){
    	   this.task = task;
       }
       public ThreadA(MyList list){
    	   this.list = list;
       }
       public void run(){
    	  for(int i=0;i<100000;i++)
    	  {
    		  list.add("threadA"+(i+1));
    	  }
       }
       
}
