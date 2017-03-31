package com.Algorithms.rise;

public class RingBuffer<T> {
	 private static final int DEFAULT_CAPACITY = 10;//Ĭ����������10
	 private int capacity = DEFAULT_CAPACITY;//���鳤��
	 private T elementData[];//Ԫ������
	 private int size=0;//��ǰ�ڵ���
	 private int head=-1;//����ͷ
	 private int tail =-1;//����β
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
			 System.out.println("����Ϊ��");
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
