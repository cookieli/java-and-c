package com.lizhengxian.basicProblem;

public class ArrayST<Key extends Comparable<Key>,Value> {
	 private Key[] keys;
	 private Value[] vals;
	 private int N;
	 public ArrayST(){}
	 public ArrayST(int capacity){
		 keys = (Key[]) new Comparable[capacity];
		 vals = (Value[])new Object[capacity];
	 }
	 public int size(){
		 return N;
	 }
	 public boolean isEmpty(){
		 return N==0;
	 }
	 public void put(Key key,Value val){
		for(int i = 0;i<N;i++){
			if(keys[i] ==key){
				vals[i] = val;return;
			}
		}
		keys[N++] = key;
		vals[N-1] = val;
	 }
	 public Value get(Key key){
		 for(int i=0;i<N;i++){
			 if(keys[i] == key) {
				 MoveToFront(i);
				 return vals[i];
				 
			 }
		 }
		 return null;
	 }
	 public void MoveToFront(int i){
		 Key keyTemp = keys[i];
		 Value ValTemp = vals[i];
		 for(int j = 0 ; j < i ; j++){
			 keys[j+1] = keys[j];
			 vals[j+1] = vals[j];
		 }
		 keys[0] = keyTemp;
		 vals[0] = ValTemp;
	 }
	 
     /**
     * @param args
     */
    public static void main(String[] args){
    	 ArrayST<Integer,String> st = new ArrayST<Integer,String>(10);
    	 st.put(1, "a");
    	 st.put(2, "c");
    	 st.put(2, "d");
    	 st.put(3, "c");
    	 System.out.println(st.get(2));
    	 System.out.println(st.get(3));
     }
}
