package com.lizhengxian.basicProblem;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
     private Key[] keys;
     private Value[] vals;
     private int N = 0;
     public BinarySearchST(){}
     public BinarySearchST(int capacity){
    	 keys = (Key[]) new Comparable[capacity];
    	 vals = (Value[]) new Object[capacity]; 
     }
     public boolean isEmpty(){
    	 return N==0;
     }
     public int size(){
    	 return N;
     }
     public void delete(Key key){
    	 if(isEmpty()) return;
    	 int i = rank(key);
    	 if(i==N||keys[i].compareTo(key)!=0) return;
         for(int j = i;j<N;j++){
        	 keys[j] = keys[j+1];
        	 vals[j] = vals[j+1];
         }
         N--;
         keys[N] = null;
         vals[N] = null;
     }
     public Key floor(Key key){
    	 int i = rank(key);
    	 if(i<N&&keys[i]==key) return key;
    	 if(i==0) return null;
    	 else return keys[i-1];
     }
     public void put(Key key,Value val){
    	 int i = rank(key);
    	 if(i<N&&keys[i]==key) {
    		 vals[i] = val;
    		 return;
    	 }
    	 for(int j = N;j>i;j--){
			 keys[j] = keys[j-1];
			 vals[j] = vals[j-1];
		 }
    	 keys[i] = key;
    	 vals[i] = val;
    	 N++;
    	 
     }
     public Value get(Key key){
    	 if(isEmpty()) return null;
    	 int i = rank(key);
    	 if(i<N&&keys[i]==key) return vals[i];
    	 else return null;
     }
     public int rank(Key key){
    	 int lo = 0;
    	 int hi = N-1;
    	 while(hi>=lo){
    		 int mid = lo +(hi-lo)/2;
    		 int cmp = key.compareTo(keys[mid]);
    		 if(cmp<0) hi = mid-1;
    		 else if(cmp>0) lo = mid+1;
    		 else return mid;
    	 }
    	 return lo;
     }
     /**
     * @param args
     */
    public static void main(String[]args){
    	 BinarySearchST<String,Integer> st = new BinarySearchST<String,Integer>(10);
    	 st.put("a", 0);
    	 st.put("b", 1);
//    	 st.put("c", 2);
//    	 st.put("d", 3);
    	 System.out.println(st.get("b"));
     }
}
