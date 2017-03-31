package com.Algorithms.rise;

public class RingBuffer<T> {
	 private static final int DEFAULT_CAPACITY = 10;//默认数组容量10
	 private int capacity = DEFAULT_CAPACITY;//数组长度
	 private T elementData[];//元素数组
	 private int size=0;//当前节点数
	 private int head=-1;//队列头
	 private int tail =-1;//队列尾
	 public RingBuffer(){
		 elementData = (T[])new Object[DEFAULT_CAPACITY]; 
	 }
	 public RingBuffer(int capacity){
		 if(capacity<0){
			 capacity = DEFAULT_CAPACITY;
		 }
		 this.capacity = capacity;
		 elementData = (T[])new Object[capacity];
	 }
	 public boolean isFull(){
		 return size == capacity;
	 }
	 public boolean isEmpty(){
		 return size ==0;
	 }
	 public void enqueue(T item){
		 if(isFull()){
			 System.out.println("Buffer is Full");
			 return;
		 }
		 else if(isEmpty()){
			head =0;
		    tail =0; 
		 }
		 else{
			 tail++;
			 if(tail>capacity-1)
				 tail = tail-capacity;
		 }
		 size++;
		 elementData[tail] = item ;
	 }
	 public T dequeue(){
		 T item = null;
		 if(isEmpty()){
			 System.out.println("队列为空");
		 }
		 else{
			 item = elementData[head];
			 elementData[head] = null;
			 head++;
			 if(head>capacity-1){
				 head = head - capacity;
			 }
		 }
		 return item;
	 }
	 
	 
	 
    
}
