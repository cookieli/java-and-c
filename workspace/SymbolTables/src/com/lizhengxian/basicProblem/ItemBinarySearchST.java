package com.lizhengxian.basicProblem;

class Item<Key extends Comparable<Key>,Value> {
	Key key;
	Value val;
	public Item(){}
	public Item(Key key,Value val){
		this.key = key;
		this.val = val;
	}
	
	
}

public class ItemBinarySearchST<Key extends Comparable<Key>,Value> {
    private Item[] items;
    private int N;
	
	public ItemBinarySearchST(){}
	public ItemBinarySearchST(int capacity){
		items = new Item[capacity];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void put(Key key,Value val){
		if(isEmpty()){
			items[N] = new Item(key,val);
			N++;
			return;
		}
		int i = rank(key);
		if(i<N&&items[i].key.compareTo(key)==0) {
			items[i] = new Item(key,val);
			return;
		}
		for(int j = N;j>i;j--){
			items[j] = items[j-1];
		}
		items[i] = new Item(key,val);
		N++;
	}
	public Value get(Key key){
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N&&items[i].key.compareTo(key)==0) return (Value) items[i].val;
		else return null;
				
	}
	public int rank(Key key){
		int lo = 0;
		int hi =N-1;
		while(lo<=hi){
			int mid = lo +(hi-lo)/2;
			int cmp = key.compareTo((Key) items[mid].key);
			if(cmp > 0) lo = mid+1;
			else if(cmp<0) hi = mid-1;
			else return mid;
		}
		return lo;
	}
	public static void main(String[] args){
		
		ItemBinarySearchST<Integer,String> st = new ItemBinarySearchST<Integer,String>(10);
		st.put(1, "a");
		st.put(2, "b");
		System.out.println(st.get(2));
	}
}
